package it.utente.crud;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import it.utente.entity.Role;
import it.utente.entity.Utente;

import it.utente.repository.UtenteRepository;
import jakarta.transaction.Transactional;
import it.utente.repository.RoleRepository;
@Service
public class UtenteCrud {
	  @Autowired
	    private UtenteRepository repository;
	  @Autowired
	    private RoleRepository rolerepository;
	  @Autowired
	    private BCryptPasswordEncoder passwordEncoder;

	    
	public List<Utente> getAllUsers() {
        return repository.findAll();
    }


    public Utente getUserById(int id) {
        return repository.findById(id).orElse(null);
    }

    public Utente upsertUsers(Utente utente) {
        Optional<Utente> existingUsers = repository.findById(utente.getId());

        if (existingUsers.isPresent()) {
            // Aggiorna il prodotto esistente
            Utente updateUtente = existingUsers.get();
            updateUtente.setUsername(utente.getUsername());
            updateUtente.setPassword(utente.getPassword());
            updateUtente.setEmail(utente.getEmail());
            updateUtente.setFirstname(utente.getFirstname());
            updateUtente.setLastname(utente.getLastname());
            updateUtente.setToken(utente.getToken());
            updateUtente.setPhonenumber(utente.getPhonenumber());
  
            if (!utente.getPassword().equals(updateUtente.getPassword())) {
                updateUtente.setPassword(passwordEncoder.encode(utente.getPassword()));
            }
            return repository.save(updateUtente);
        } else {
            utente.setPassword(passwordEncoder.encode(utente.getPassword()));
            return repository.save(utente);
        }
    }
    public void deleteUsers(int id) {
    	repository.deleteById(id);
    }
    @Transactional
    public Utente registerUser(String username, String password,String email,String firstname,String lastname,String phonenumber) throws RuntimeException {
        // Controlla se l'utente esiste già
        if (repository.existsByUsername(username)) {
            throw new IllegalArgumentException("Username already exists");
        }
        // Controlla se il ruolo esiste
        Role role = rolerepository.findByName("admin")
                                  .orElseThrow(() -> new RuntimeException("Default role not found"));
        // Crea un nuovo utente
        Utente user = new Utente();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password)); // Codifica la password
        user.setEmail(email);
        user.setFirstname(firstname);
        user.setLastname(lastname);
        user.setPhonenumber(phonenumber);
        user.addRole(role);


        // Salva l'utente nel database
        return repository.save(user);
    }
}
