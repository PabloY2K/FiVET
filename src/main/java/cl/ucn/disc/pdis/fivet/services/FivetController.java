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
import cl.ucn.disc.pdis.fivet.model.Persona;
import org.springframework.security.crypto.bcrypt.BCrypt;
/**
 * The Fivet Controller interfase
 */

public interface FivetController {
        /**
         *
         * @param login The login account
         * @param password The password of the user
         * @return a persona
         */
        Persona autenticar(String login, String password) {
            /**
             * add a Persona to the backend
             * @param persona to add
             * @param password to hash
             */
            @Override
            public void Add(Persona persona, String password) {
                persona.setPassword(BCrypt.hashpw(password, BCrypt.gensalt(12)));
                this.daoPersona.save(persona);
            }


        }
    }
}
