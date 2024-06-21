package it.utente.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import it.utente.entity.Shop;

@Controller
public class ShopController {
	
	 
	 
	  @GetMapping("/shopInsert")
	    public String showShopInsertForm(Model model) {
	        // Crea un oggetto Shop vuoto da passare al form
	        model.addAttribute("shop", new Shop());
	        return "shopInsert"; // Questo deve corrispondere al nome del tuo file HTML in src/main/resources/templates/
	    }
}
