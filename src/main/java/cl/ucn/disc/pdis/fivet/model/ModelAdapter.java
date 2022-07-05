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

package cl.ucn.disc.pdis.fivet.model;

import cl.ucn.disc.pdis.fivet.grpc.ControlEntity;
import cl.ucn.disc.pdis.fivet.grpc.FichaMedicaEntity;
import cl.ucn.disc.pdis.fivet.grpc.PersonaEntity;
import cl.ucn.disc.pdis.fivet.grpc.SexoEntity;
import cl.ucn.disc.pdis.fivet.model.Control;
import cl.ucn.disc.pdis.fivet.model.FichaMedica;
import cl.ucn.disc.pdis.fivet.model.Persona;
import lombok.experimental.UtilityClass;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@UtilityClass
public final class ModelAdapter {

public static PersonaEntity build(final Persona persona) {
    return PersonaEntity.newBuilder()
            .setRut(persona.getRut())
            .setNombre(persona.getNombre())
            .setEmail(persona.getEmail())
            .setDireccion(persona.getDireccion())
            .build();
}
public static ZonedDateTime build(final String fecha) {
    return ZonedDateTime.parse(fecha, DateTimeFormatter.ISO_ZONED_DATE_TIME);
}
public static LocalDate buildLocalDate (final String fechaNacimiento) {
    return LocalDate.parse(fechaNacimiento, DateTimeFormatter.ISO_LOCAL_DATE);
}
public static Collection<ControlEntity> buildControlEntities(final Collection<Control> controles) {
    List<ControlEntity> controlEntities = new ArrayList<>();
    for (Control control : controles) {
        controlEntities.add(build(control));
    }
    return controlEntities;
    }

public static Collection<Control> buildControles (final Collection<ControlEntity> controlEntities) {
    List<Control> controles = new ArrayList<>();
    for(ControlEntity controlEntity : controlEntities) {
        controles.add(build(controlEntity));
    }
    return controles;
}

public static FichaMedicaEntity build(final FichaMedica fichaMedica) {
    return FichaMedicaEntity.newBuilder()
            .setColor(fichaMedica.getColorPaciente())
            .addAllControles(buildControlEntities(fichaMedica.getControles()))
            .setDuenio(build(fichaMedica.getDuenio()))
            .setEspecie(fichaMedica.getEspeciePaciente())
            .setFechaNacimiento(fichaMedica.getFechaNacimiento())
            .setNombrePaciente(fichaMedica.getNombrePaciente())
            .setNumero(fichaMedica.getNumeroFicha())
            .setRaza(fichaMedica.getRazaPaciente())
            .setSexo(build(fichaMedica.getSexo()))
            .setTipo(fichaMedica.getTipoPaciente())
            .build();
}


public static FichaMedica build(final FichaMedicaEntity fichaMedicaEntity) {
    return FichaMedica.builder()
            .numeroFicha(fichaMedicaEntity.getNumero())
            .nombrePaciente(fichaMedicaEntity.getNombrePaciente())
            .fechaNacimiento(fichaMedicaEntity.getFechaNacimiento())
            .razaPaciente(fichaMedicaEntity.getRaza())
            .colorPaciente(fichaMedicaEntity.getColor())
            .especiePaciente(fichaMedicaEntity.getEspecie())
            .tipoPaciente(fichaMedicaEntity.getTipo())
            .sexo(build(fichaMedicaEntity.getSexo()))
            .duenio(build(fichaMedicaEntity.getDuenio()))
            .controles(buildControles(fichaMedicaEntity.getControlesList()))
            .build();
}



public static Persona build(final PersonaEntity personaEntity) {
    return Persona.builder()
            .rut(personaEntity.getRut())
            .nombre(personaEntity.getNombre())
            .email(personaEntity.getEmail())
            .direccion(personaEntity.getDireccion())
            .build();
}

public static Control build(final ControlEntity controlEntity) {
    return Control.builder()
            .altura(controlEntity.getAltura())
            .dignostico(controlEntity.getDiagnostico())
            .veterinario(build(controlEntity.getVeterinario()))
            .peso(controlEntity.getPeso())
            .fecha(build(controlEntity.getFecha()))
            .temperatura(controlEntity.getTemperatura())
            .build();
}

    public static ControlEntity build(final Control control) {
        return ControlEntity.newBuilder()
                .setAltura(control.getAltura())
                .setDiagnostico(control.getDignostico())
                .setVeterinario(build(control.getVeterinario()))
                .setPeso(control.getPeso())
                .setFecha(control.getFecha().toString())
                .setTemperatura(control.getTemperatura())
                .build();
    }

public static FichaMedica.Sexo build(final SexoEntity sexoEntity) {
    return FichaMedica.Sexo.valueOf(sexoEntity.name());
}
public static SexoEntity build(final FichaMedica.Sexo sexo) {
    return SexoEntity.valueOf(sexo.name());
}


}