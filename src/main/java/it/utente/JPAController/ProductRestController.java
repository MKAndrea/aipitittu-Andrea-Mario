package it.utente.JPAController;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.utente.crud.ProductCrud;
import it.utente.entity.Product;
@RestController
@RequestMapping("/api")
public class ProductRestController {
	 @Autowired
	    private ProductCrud productcrud;
	
	
	@GetMapping(value="/allProduct",produces="application/json")
	    public List<Product> getAllProducts() {
	        return productcrud.getAllProducts();
	    }

	    @GetMapping("/findProduct/{id}")
	    public Product getProductById(@PathVariable int id) {
	        return productcrud.getProductById(id);
	    }

	    @PostMapping("/upsertProduct")
	    public Product upsertProduct(@RequestBody Product product) {
	        return productcrud.upsertProduct(product);
	    }
	    
	    //@DeleteMapping uso il delete se voglio cancellare con postman
	    @GetMapping("/DeleteProduct/{id}")
	    public void deleteProduct(@PathVariable int id) {
	    	productcrud.deleteProduct(id);
	    }
}
