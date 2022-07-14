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

package cl.ucn.disc.pdis.fivet.services;

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
import cl.ucn.disc.pdis.fivet.grpc.SearchFichaMedicaReq;
import cl.ucn.disc.pdis.fivet.model.Control;
import cl.ucn.disc.pdis.fivet.model.FichaMedica;
import cl.ucn.disc.pdis.fivet.model.ModelAdapter;
import cl.ucn.disc.pdis.fivet.model.Persona;
import com.google.protobuf.Any;
import com.google.rpc.Code;
import com.google.rpc.ErrorInfo;
import com.google.rpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.protobuf.StatusProto;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;

import static org.apache.commons.lang3.StringUtils.isNumeric;

/**
 * The FivetServiceImpl Class.
 *
 * @author pablo
 */

@Slf4j
public class FivetServiceImpl extends FivetServiceGrpc.FivetServiceImplBase {

    private final FivetController fivetController;

    public FivetServiceImpl(String databaseUrl) {
        this.fivetController = new FivetControllerImpl(databaseUrl);
    }

    /**
     * Build a StatusRuntimeException with a message.
     *
     * @param code    code to use.
     * @param message message to use.
     * @return the StatusRunTimeException
     */
    private static StatusRuntimeException buildException(final Code code, final String message) {
        return StatusProto.toStatusRuntimeException(Status.newBuilder()
                .setCode(code.getNumber())
                .setMessage(message)
                .addDetails(Any.pack(ErrorInfo.newBuilder()
                        .setReason(message)
                        .build()))
                .build());
    }

    @Override
    public void authenticate(AuthenticateReq request, StreamObserver<PersonaReply> responseObserver) {
        Optional<Persona> personaOptional = this.fivetController.authenticate(
                request.getLogin(),
                request.getPassword()
        );

        personaOptional.ifPresentOrElse(persona -> {
            responseObserver.onNext(PersonaReply
                    .newBuilder()
                    .setPersona(ModelAdapter.build(persona))
                    .build());
            responseObserver.onCompleted();
        }, () -> responseObserver.onError(buildException(Code.PERMISSION_DENIED, "Wrong Credentials!!!")));
    }

    @Override
    public void addPersona(AddPersonaReq req, StreamObserver<PersonaReply> responseObserver) {
        PersonaEntity personaEntity = req.getPersona();
        Optional<Persona> optionalPersona = this.fivetController.retrieveByLogin(personaEntity.getEmail());
        optionalPersona.ifPresentOrElse(persona ->
                responseObserver.onError(buildException(Code.ALREADY_EXISTS, "That Persona already exists")), () -> {
                Optional<Persona> optionalPersona1 = this.fivetController.retrieveByLogin(personaEntity.getRut());
                optionalPersona1.ifPresentOrElse(persona ->
                    responseObserver.onError(buildException(Code.ALREADY_EXISTS,
                            "That Persona already exists")), () -> {
                        Persona persona = ModelAdapter.build(personaEntity);
                        this.fivetController.add(persona, persona.getPassword());
                        responseObserver.onNext(PersonaReply.newBuilder()
                            .setPersona(ModelAdapter.build(persona))
                            .build());                });
                });
    }

    @Override
    public void addControl(AddControlReq req, StreamObserver<FichaMedicaReply> responseObserver) {
        ControlEntity controlEntity = req.getControl();
        Optional<FichaMedica> optionalFichaMedica = this.fivetController.retrieveFichaMedica(req.getNumeroFicha());
        optionalFichaMedica.ifPresentOrElse(fichaMedica -> {
            Control control = ModelAdapter.build(controlEntity);
            Optional<Persona> optionalVeterinario =
                    this.fivetController.retrieveByLogin(controlEntity.getVeterinario().getRut());
            optionalVeterinario.ifPresentOrElse(veterinario -> {
                control.setVeterinario(veterinario);
                this.fivetController.addControl(control, fichaMedica.getNumeroFicha());
                responseObserver.onNext(FichaMedicaReply.newBuilder()
                        .setFichaMedica(ModelAdapter.build(fichaMedica))
                        .build());
                responseObserver.onCompleted();
            }, () -> responseObserver.onError(buildException(Code.NOT_FOUND, "The Veterinario was not found")));
        }, () -> responseObserver.onError(buildException(Code.NOT_FOUND, "The FichaMedica was not found")));
    }

    @Override
    public void retrieveFichaMedica(RetrieveFichaMedicaReq request, StreamObserver<FichaMedicaReply> responseObserver) {
        Optional<FichaMedica> optionalFichaMedica =
                this.fivetController.retrieveFichaMedica(request.getNumeroFicha());
        optionalFichaMedica.ifPresentOrElse(fichaMedica -> {
            responseObserver.onNext(FichaMedicaReply.newBuilder()
                    .setFichaMedica(ModelAdapter.build(fichaMedica))
                    .build());

            responseObserver.onCompleted();

        }, () -> responseObserver.onError(buildException(Code.NOT_FOUND, "FichaMedica not found")));
    }

    @Override
    public void addFichaMedica(AddFichaMedicaReq req, StreamObserver<FichaMedicaReply> responseObserver) {

        FichaMedicaEntity fichaMedicaEntity = req.getFicha();

        Optional<FichaMedica> optionalFichaMedica =
                this.fivetController.retrieveFichaMedica(fichaMedicaEntity.getNumero());

        optionalFichaMedica.ifPresentOrElse(fichaMedica ->
                        responseObserver.onError(buildException(Code.ALREADY_EXISTS, "FichaMedica already exists")),
                () -> {

                    FichaMedica fichaMedica = ModelAdapter.build(fichaMedicaEntity);

                    Optional<Persona> optionalDuenio =
                            this.fivetController.retrieveByLogin(fichaMedica.getDuenio().getRut());

                    optionalDuenio.ifPresentOrElse(fichaMedica::setDuenio, () -> {

                        this.fivetController.addPersona(fichaMedica.getDuenio());
                        Optional<Persona> duenio =
                                this.fivetController.retrieveByLogin(fichaMedica.getDuenio().getRut());

                        duenio.ifPresent(fichaMedica::setDuenio);
                    });

                    log.debug("Duenio id: {}", fichaMedica.getDuenio().getId());

                    this.fivetController.addFichaMedica(fichaMedica);

                    responseObserver.onNext(FichaMedicaReply.newBuilder()
                            .setFichaMedica(ModelAdapter.build(fichaMedica))
                            .build());

                    responseObserver.onCompleted();
                });
    }

    /**
     * Metabuscador.
     *
     * @param request q to use
     * @param responseObserver of FichaMedicaReply
     */
    public void searchFichaMedica(SearchFichaMedicaReq request, StreamObserver<FichaMedicaReply> responseObserver) {
        String metadata = request.getQ();

        if (metadata.isEmpty()) {
            responseObserver.onError(buildException(Code.INVALID_ARGUMENT, "Invalid Argument"));
        } else {
            // 1. Buscar por numero de Ficha Medica

            if (isNumeric(metadata)) {
                Optional<FichaMedica> optionalFichaMedica =
                        this.fivetController.retrieveFichaMedica(Integer.parseInt(metadata));

                optionalFichaMedica.ifPresentOrElse(fichaMedica -> {
                    responseObserver.onNext(FichaMedicaReply.newBuilder()
                            .setFichaMedica(ModelAdapter.build(fichaMedica))
                            .build());
                    responseObserver.onCompleted();
                }, () -> responseObserver.onError(buildException(Code.NOT_FOUND, "The FichaMedica was not found !!!")));
            } else {

                int count = 0;
                List<FichaMedica> fichaMedicaList = this.fivetController.retrieveAllFichaMedica();

                for (FichaMedica fichaMedica : fichaMedicaList) {

                    // 2. Buscar por el rut del dueño

                    if (metadata.equalsIgnoreCase(fichaMedica.getDuenio().getRut())) {
                        count++;
                        responseObserver.onNext(FichaMedicaReply.newBuilder()
                                .setFichaMedica(ModelAdapter.build(fichaMedica))
                                .build());

                        // 3. Buscar por el nombre de la mascota
                    } else if (metadata.equalsIgnoreCase(fichaMedica.getNombrePaciente())) {
                        count++;
                        responseObserver.onNext(FichaMedicaReply.newBuilder()
                                .setFichaMedica(ModelAdapter.build(fichaMedica))
                                .build());

                        // 4. Buscar por el nombre del dueño
                    } else if (metadata.equalsIgnoreCase(fichaMedica.getDuenio().getNombre())) {
                        count++;
                        responseObserver.onNext(FichaMedicaReply.newBuilder()
                                .setFichaMedica(ModelAdapter.build(fichaMedica))
                                .build());
                    }
                }

                if (count > 0) {
                    responseObserver.onCompleted();
                } else {
                    responseObserver.onError(buildException(Code.NOT_FOUND, "The FichaMedica was not found!!!"));
                }
            }
        }
    }
}
