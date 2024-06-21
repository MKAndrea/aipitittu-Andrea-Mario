package it.utente.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import it.utente.entity.Utente;
import jakarta.transaction.Transactional;


public interface UtenteRepository extends JpaRepository<Utente,Integer>{
	 Optional<Utente> findByUsername(String username);
	    boolean existsByUsername(String username);
	    
	    @Query("SELECT u FROM Utente u WHERE u.username = :username")
	    Utente getUserByUsername(@Param("username") String username);
		
		
		 
	    @Modifying
	    @Transactional
	    @Query(value = "INSERT INTO users (id, username,password,email,firstname,lastname token, phonenumber) " +
	                   "VALUES (:id, :username,:password,:email,:firstname,:lastname ,:token, :phonenumber) " +
	                   "ON DUPLICATE KEY UPDATE username = :username, password = :password, email = :email, " +
	                   "firstname = :firstname, lastname = :lastname, token = :token, phonenumber = :phonenumber, "
	                   , nativeQuery = true)
	    void upsertUser(@Param("id") int id, 
	                    @Param("username") String username, 
	                    @Param("password") String password,
	                    @Param("email") String email, 
	                    @Param("firstname") String firstname, 
	                    @Param("lastname") String lastname, 
	                    @Param("token") String token, 
	                    @Param("phonenumber") String phonenumber
	                   );
}
