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
import com.j256.ormlite.table.DatabaseTable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * The Persona Class.
 *
 * @author pablo
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@DatabaseTable(tableName = "persona")
public final class Persona extends BaseEntity {

    /**
     * The Rut.
     */
    @Getter
    @Setter
    @DatabaseField(unique = true, canBeNull = false)
    private String rut;

    /** The Nombre.
     */
    @Getter
    @Setter
    @DatabaseField(canBeNull = false)
    private String nombre;
    /**
     * The Email.
     */
    @Getter
    @Setter
    @DatabaseField(unique = true, canBeNull = false)
    private String email;
    /**
     * The Password.
     */

    @Getter
    @Setter
    @DatabaseField(canBeNull = false)
    private String password;
    /**
     * The Direccion.
     */
    @Getter
    @Setter
    @DatabaseField(canBeNull = true)
    private String direccion;

}
