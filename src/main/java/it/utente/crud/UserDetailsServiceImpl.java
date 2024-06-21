package it.utente.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import it.utente.entity.Utente;

import it.utente.repository.UtenteRepository;

public class UserDetailsServiceImpl implements UserDetailsService {
	   @Autowired
	    private UtenteRepository utenteRepository;
	     
	   @Override
	   public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	      Utente user = utenteRepository.findByUsername(username)
	            .orElseThrow(() -> new UsernameNotFoundException("User not found"));
	      return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
	            user.getAuthorities());
	   }
}
