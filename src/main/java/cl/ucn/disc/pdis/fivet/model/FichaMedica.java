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
import cl.ucn.disc.pdis.fivet.orm.BaseEntity;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.util.Collection;

/**
 * The Ficha Medica Class
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@DatabaseTable(tableName="fichaMedica")
public final class FichaMedica extends BaseEntity {

    /**
     * The Number of the Ficha
     */
    @Getter
    @Setter
    @DatabaseField(canBeNull = false, unique = true)
    private Integer numeroFicha;
    /**
     * The Name of the Paciente
     */
    @Getter
    @Setter
    @DatabaseField(canBeNull = false)
    private String nombrePaciente;
    /**
     * The Species of the Paciente
     */
    @Getter
    @Setter
    @DatabaseField(canBeNull = false)
    private String especiePaciente;
    /**
     * The Birthday of the Paciente
     */
    @Getter
    @Setter
    @DatabaseField(canBeNull = false)
    private String fechaNacimiento;
    /**
     * The Race of the Paciente
     */
    @Getter
    @Setter
    @DatabaseField(canBeNull = false)
    private String razaPaciente;

    /**
     * The Color of the Paciente
     */
    @Getter
    @Setter
    @DatabaseField(canBeNull = false)
    private String colorPaciente;
    /**
     * The Type of the Paciente
     */
    @Getter
    @Setter
    @DatabaseField(canBeNull = false)
    private String tipoPaciente;
    /**
     * The Options of Sexo for the Paciente
     */
    public enum Sexo {
        MACHO,
        HEMBRA
    }
    /**
     * The Sexo of the Paciente
     */
    @Getter
    @Setter
    @DatabaseField(canBeNull = false)
    private Sexo sexo;
    /**
     * The Duenio of the Paciente
     */
    @Getter
    @Setter
    @DatabaseField(foreign = true, foreignAutoRefresh = true, columnName = "persona_id")
    private Persona duenio;
    /**
     * The Controles.
     */
    @Getter
    @ForeignCollectionField(eager = true, orderColumnName = "fecha")
    private Collection<Control> controles;
    /**
     * Append a Control
     *
     * @param control to append
     */
    public void add(Control control) {
        this.controles.add(control);
    }
}
