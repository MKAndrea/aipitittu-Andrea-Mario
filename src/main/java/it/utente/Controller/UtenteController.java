package it.utente.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.utente.crud.UtenteCrud;
import it.utente.entity.Utente;

@Controller
public class UtenteController {
	   @Autowired
	   private UtenteCrud utentecrud;

	   
	   @GetMapping("/register")
	   public String showRegistrationForm(Model model) {
	      model.addAttribute("user", new Utente());
	      return "register";
	   }
	   

	   @PostMapping(value = "/register", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	    public String registerUser(@RequestParam String username, @RequestParam String password,@RequestParam String email,
	    		@RequestParam String firstname,@RequestParam String lastname,@RequestParam String phonenumber,Model model) {
	        try {
	            Utente registerUser = utentecrud.registerUser(username, password,email,firstname,lastname,phonenumber);
	            model.addAttribute("message", "User registered successfully");
	            return "login"; // Restituisce il template login.html
	        } catch (IllegalArgumentException e) {
	            model.addAttribute("error", e.getMessage());
	            return "register"; // In caso di errore, restituisce la vista di registrazione
	        } catch (RuntimeException e) {
	            model.addAttribute("error", e.getMessage());
	            return "register"; // In caso di errore, restituisce la vista di registrazione
	        }
	    }
	   
}
