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


import cl.ucn.disc.pdis.fivet.grpc.AddControlReq;
import cl.ucn.disc.pdis.fivet.grpc.AddFichaMedicaReq;
import cl.ucn.disc.pdis.fivet.grpc.AddPersonaReq;
import cl.ucn.disc.pdis.fivet.grpc.AuthenticateReq;
import cl.ucn.disc.pdis.fivet.grpc.ControlEntity;
import cl.ucn.disc.pdis.fivet.grpc.FichaMedicaEntity;
import cl.ucn.disc.pdis.fivet.grpc.FichaMedicaReply;
import cl.ucn.disc.pdis.fivet.grpc.FivetServiceGrpc;
import cl.ucn.disc.pdis.fivet.grpc.PersonaEntity;
import cl.ucn.disc.pdis.fivet.grpc.PersonaReply;
import cl.ucn.disc.pdis.fivet.grpc.RetrieveFichaMedicaReq;
import cl.ucn.disc.pdis.fivet.grpc.RetrievePersonaReq;
import cl.ucn.disc.pdis.fivet.grpc.SearchFichaMedicaReq;
import cl.ucn.disc.pdis.fivet.grpc.SexoEntity;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import lombok.extern.slf4j.Slf4j;

import java.time.ZonedDateTime;
import java.util.Iterator;


/**
 * The Client of Fivet.
 *
 * @author pablo
 */
@Slf4j
public final class Cliente {

    /**
     * The Client.
     */
    public static void main(String[] args) {
        log.debug("Starting the Client ..");

        // The Channel
        ManagedChannel channel = ManagedChannelBuilder
                .forAddress("127.0.0.1", 8080)
                .usePlaintext()
                .build();

        //The Stub
        FivetServiceGrpc.FivetServiceBlockingStub stub = FivetServiceGrpc.newBlockingStub(channel);
        // Persona Request
        try {
            PersonaReply persona = stub.addPersona(AddPersonaReq.newBuilder()
                    .setPersona(PersonaEntity.newBuilder()
                            .setRut("204149763")
                            .setNombre("Pablo Herrera")
                            .setEmail("pablo.herrera@alumnos.ucn.cl")
                            .setDireccion("Santa Margarita 806")
                            .setPassword("hola123")
                            .build())
                    .build());
            log.debug("Persona from AddPersona: {}", persona.getPersona());

            PersonaReply personaAuth = stub.authenticate(AuthenticateReq.newBuilder()
                    .setLogin("pablo.herrera@alumnos.ucn.cl")
                    .setPassword("hola123")
                    .build());
            log.debug("Persona from Authenticate: {}", personaAuth);
        } catch (StatusRuntimeException e) {
            log.warn("RPC failed: {} ", e.getStatus());
        }
        // FichaMedicaRequest
        try {
            FichaMedicaReply fichaMedica = stub.addFichaMedica(AddFichaMedicaReq.newBuilder()
                    .setFicha(FichaMedicaEntity.newBuilder()
                            .setNumero(1)
                            .setNombrePaciente("Milu")
                            .setEspecie("Perro")
                            .setFechaNacimiento("10-10-10")
                            .setRaza("Quiltro")
                            .setColor("Blanco")
                            .setTipo("Perro Grande")
                            .setSexo(SexoEntity.HEMBRA)
                            .setDuenio(PersonaEntity.newBuilder()
                                    .setRut("204149763")
                                    .setNombre("Pablo Herrera")
                                    .setEmail("pablo.herrera@alumnos.ucn.cl")
                                    .setDireccion("Santa Margarita 806")
                                    .build())
                            .build())
                    .build());
            log.debug("FichaMedica from AddFicha: {}", fichaMedica.getFichaMedica());
        } catch (StatusRuntimeException e) {
            log.warn("RPC failed: {}", e.getStatus());
        }


        // Add Control request
        try {
            ControlEntity controlEntity = ControlEntity.newBuilder()
                    .setFecha(ZonedDateTime.now().toString())
                    .setTemperatura(38.5)
                    .setPeso(10.5)
                    .setAltura(0.6)
                    .setDiagnostico("Sin problemas")
                    .setVeterinario(stub.retrievePersona(RetrievePersonaReq.newBuilder()
                            .setLogin("204149763")
                            .build()).getPersona())
                    .build();

            FichaMedicaReply fichaMedicaReply = stub.addControl(AddControlReq.newBuilder()
                    .setControl(controlEntity)
                    .setNumeroFicha(1)
                    .build());
            log.debug("FichaMedica from AddControl: {}", fichaMedicaReply.getFichaMedica());

        } catch (StatusRuntimeException e) {
            log.warn("RPC failed: {}", e.getStatus());
        }

        // Retrieve FichaMedica request
        try {
            FichaMedicaReply fichaMedica = stub.retrieveFichaMedica(RetrieveFichaMedicaReq.newBuilder()
                    .setNumeroFicha(1)
                    .build());
            log.debug("FichaMedica from RetrieveFichaMedica: {}", fichaMedica.getFichaMedica());
        } catch (StatusRuntimeException e) {
            log.warn("RPC failed: {}", e.getStatus());
        }

        // Search FichaMedica request
        try {
            Iterator<FichaMedicaReply> fichaMedicaReply = stub.searchFichaMedica(SearchFichaMedicaReq.newBuilder()
                    .setQ("1")
                    .build());
            while (fichaMedicaReply.hasNext()) {
                log.debug("FichaMedica from SearchFichaMedica: {}", fichaMedicaReply.next().getFichaMedica());
            }

        } catch (StatusRuntimeException e) {
            log.warn("RPC failed: {}", e.getStatus());
        }

        log.debug("Done.");
    }
}
