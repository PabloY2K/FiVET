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

package cl.ucn.disc.pdis.fivet.orm;


import java.util.List;
import java.util.Optional;

/**
 * Data Access Object: DAO
 * @author pablo
 */
public interface DAO <T extends BaseEntity> {

    /**
     * Get optional T.
     */
    Optional<T> get(Integer id);

    /**
     *  Optional T with attribute and value
     * @param attrib
     * @param value
     * @return optional T
     */
    Optional<T> get(String attrib, Object value);

    /**
     * Get all of the Ts.
     */
    List<T> getAll();

    /**
     * Save a T.
     * @param t to save
     */
    void save(T t);

    /**
     * Delete a T.
     * @param t to delete.
     */
    void delete(T t);

    /**
     * Delete a T.
     * @param id of the t to delete;
     */
    void delete(Integer id);


}

