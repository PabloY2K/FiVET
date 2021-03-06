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
import cl.ucn.disc.pdis.fivet.orm.DAO;
import cl.ucn.disc.pdis.fivet.orm.ORMLiteDAO;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import lombok.NonNull;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


/**
 * The Fivet Controller Implementation.
 *
 * @author pablo
 */
@Slf4j
public class FivetControllerImpl implements FivetController {
    private final DAO<Persona> daoPersona;
    private final DAO<FichaMedica> fichaMedicaDAO;

    /**
     * The Hasher.
     */

    private static final PasswordEncoder PASSWORD_ENCODER = new Argon2PasswordEncoder();

    /**
     * The FivetControllerImpl Constructor.
     *
     * @param dbUrl to connect
     */
    @SneakyThrows
    public FivetControllerImpl(String dbUrl) {
        ConnectionSource cs = new JdbcConnectionSource(dbUrl);
        this.daoPersona = new ORMLiteDAO<>(cs, Persona.class);
        this.fichaMedicaDAO = new ORMLiteDAO<>(cs, FichaMedica.class);
        this.daoPersona.dropAndCreateTable();
        this.fichaMedicaDAO.dropAndCreateTable();
    }

    /**
     * Authentication of a person in the system.
     *
     * @param login  The login account
     * @param passwd The password of the user
     * @return a Persona
     */
    @Override
    public Optional<Persona> authenticate(String login, String passwd) {
        Optional<Persona> persona = this.daoPersona.get("rut", login);

        if (persona.isEmpty()) {
            persona = this.daoPersona.get("email", login);
        }
        if (persona.isEmpty()) {
            return Optional.empty();
        }

        if (PASSWORD_ENCODER.matches(persona.get().getPassword(), passwd)) {
            return Optional.empty();
        }

        log.warn("Incorrect password");
        return Optional.empty();
    }

    /**
     * Add a Persona into the backend.
     *
     * @param persona  to add
     * @param password to hash
     */
    @Override
    public void add(@NonNull Persona persona, @NonNull String password) {
        // Hash Password
        persona.setPassword(PASSWORD_ENCODER.encode(password));
        //Save the Persona
        this.daoPersona.save(persona);
    }

    /**
     * Retrieve a Persona by email or rut.
     *
     * @param login email or rut
     * @return a Optional Persona
     */
    @Override
    public Optional<Persona> retrieveByLogin(String login) {
        Optional<Persona> persona = this.daoPersona.get("rut", login);

        if (persona.isEmpty()) {
            persona = this.daoPersona.get("email", login);
        }
        if (persona.isEmpty()) {
            return Optional.empty();
        }
        return persona;
    }

    @Override
    public void delete(Integer id) {
        this.daoPersona.delete(id);
    }

    @Override
    public void addPersona(Persona persona) {
        this.daoPersona.save(persona);
    }

    @Override
    public void addControl(@NonNull Control control, int numeroFichaMedica) {
        Optional<FichaMedica> fichaMedica = this.fichaMedicaDAO.get("numero", numeroFichaMedica);
        if (fichaMedica.isPresent()) {
            fichaMedica.get().add(control);
        } else {
            log.warn("The Fichamedica was not found");
        }
    }

    @Override
    public void addFichaMedica(@NonNull FichaMedica fichaMedica) {
        this.fichaMedicaDAO.save(fichaMedica);
    }

    @Override
    public Optional<FichaMedica> retrieveFichaMedica(int numeroFichaMedica) {
        Optional<FichaMedica> fichaMedica = this.fichaMedicaDAO.get("numero", numeroFichaMedica);
        if (fichaMedica.isEmpty()) {
            return Optional.empty();
        } else {
            return fichaMedica;
        }
    }

    @Override
    public List<FichaMedica> retrieveAllFichaMedica() {
        return new ArrayList<>(this.fichaMedicaDAO.getAll());
    }


}






