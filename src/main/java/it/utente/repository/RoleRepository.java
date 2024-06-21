package it.utente.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.utente.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
	   Optional<Role> findByName(String name);
	  
}
