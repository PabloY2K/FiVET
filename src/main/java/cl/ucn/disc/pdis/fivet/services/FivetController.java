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

import cl.ucn.disc.pdis.fivet.model.Control;
import cl.ucn.disc.pdis.fivet.model.FichaMedica;
import cl.ucn.disc.pdis.fivet.model.Persona;

import java.util.List;
import java.util.Optional;

/**
 * The Fivet Controller interfase.
 *
 * @author pablo
 */

public interface FivetController {
    /**
     * Autenticar method.
     *
     * @param login rut or email to login
     * @param password to login
     * @return a Persona
     */
    Optional<Persona> authenticate(String login, String password);
    /**
     * Add a Persona into the backend.
     *
     * @param persona to add
     * @param password to hash
     */

    void add(Persona persona, String password);
    /**
     * Delete a Persona from the backend.
     *
     * @param id to use.
     */

    void delete(Integer id);
    /**
     * Retrieve a Persona by email or rut.
     *
     * @param login email or rut
     * @return a Optional Persona
     */

    Optional<Persona> retrieveByLogin(String login);
    /**
     * Add a Persona to the backend.
     *
     * @param persona to add
     */

    void addPersona(Persona persona);
    /**
     * Add a control to the backend.
     *
     * @param control to add
     * @param numeroFicha to attach
     */

    void addControl(Control control, int numeroFicha);
    /**
     * Add a FichaMedica to the backend.
     *
     * @param fichamedica to add.
     */

    void addFichaMedica(FichaMedica fichamedica);
    /**
     * Retrieve a FichaMedica from backend.
     *
     * @param numeroFichaMedica to retrieve
     * @return a FichaMedica
     */

    Optional<FichaMedica> retrieveFichaMedica(int numeroFichaMedica);
    /**
     * Retrieve all Fichas Medicas from the backend.
     */

    List<FichaMedica> retrieveAllFichaMedica();

}

