/*
 * MIT License
 *
 * Copyright (c) [2022] [Pablo Herrera Novoa]
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package cl.ucn.disc.pdis.fivet;


import cl.ucn.disc.pdis.fivet.grpc.AuthenticateReq;
import cl.ucn.disc.pdis.fivet.grpc.FivetServiceGrpc;
import cl.ucn.disc.pdis.fivet.grpc.PersonaEntity;
import cl.ucn.disc.pdis.fivet.grpc.PersonaReply;
import cl.ucn.disc.pdis.fivet.model.Persona;
import cl.ucn.disc.pdis.fivet.services.FivetController;
import cl.ucn.disc.pdis.fivet.services.FivetControllerImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

/**
 * The Server of Fivet.
 *
 * @author pablo
 */
@Slf4j
public final class Servidor {
    /**
     * The Main.
     */
    @SneakyThrows
    public static void main(String[] args) {
        log.debug("Building the FivetServiceImpl ..");
        FivetServiceImpl fivetService = new FivetServiceImpl("jdbc:h2:mem:fivet");

        log.debug("Building and Starting The Server ..");

        // Build and start the server
        Server server = ServerBuilder.forPort(8080)
                .addService(fivetService)
                .build()
                .start();

        // Awaits
        server.awaitTermination();

        log.debug("Done.");
    }

    /**
     * The Fivet Implementation.
     */
    @Slf4j
    private static class FivetServiceImpl extends FivetServiceGrpc.FivetServiceImplBase {
        /**
         * The Controller.
         */
        private final FivetController fivetController;

        /**
         * The FivetService.
         *
         * @param databaseUrl to use
         */
        public FivetServiceImpl(String databaseUrl) {
            this.fivetController = new FivetControllerImpl(databaseUrl);
        }
        /**
         * Authenticate.
         *
         * @param request to use
         * @param responseObserver StreamObserver of PersonaReply
         */

        @Override
        public void authenticate(AuthenticateReq request, StreamObserver<PersonaReply> responseObserver) {
            // Retrieve from Controller
            Optional<Persona> persona = this.fivetController.retrieveByLogin(request.getLogin());

            if (persona.isPresent()) {
                //Return the observer
                responseObserver.onNext(PersonaReply.newBuilder()
                                .setPersona(PersonaEntity.newBuilder()
                        .setRut(persona.get().getRut())
                        .setNombre(persona.get().getNombre())
                        .setEmail(persona.get().getEmail())
                        .setDireccion(persona.get().getDireccion())
                                        .build())
                                        .build());
                responseObserver.onCompleted();
            } else {
                responseObserver.onNext(PersonaReply.newBuilder()
                                .setPersona(PersonaEntity.newBuilder()
                        .setRut("204149763")
                        .setNombre("Pablo Luis Sergio Herrera Novoa")
                        .setEmail("pablo.herrera@alumnos.ucn.cl")
                        .setDireccion("Santa Margarita 806")
                                        .build())
                                        .build());
                responseObserver.onCompleted();
                responseObserver.onError(new RuntimeException("Persona Not Found!"));
            }
        }

    }
}