package it.utente.crud;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.utente.entity.Product;
import it.utente.repository.ProductRepository;

@Service
public class ProductCrud {
	  @Autowired
	    private ProductRepository repository;
	  
	public List<Product> getAllProducts() {
        return repository.findAll();
    }

    public Product getProductById(int id) {
        return repository.findById(id).orElse(null);
    }

    // Metodo upsert
    public Product upsertProduct(Product product) {
        Optional<Product> existingProduct = repository.findById(product.getId());

        if (existingProduct.isPresent()) {
            // Aggiorna il prodotto esistente
            Product updateProduct = existingProduct.get();
            updateProduct.setNome_prodotto(product.getNome_prodotto());
            updateProduct.setPrezzo(product.getPrezzo());
            updateProduct.setIdshop(product.getIdshop());
            return repository.save(updateProduct);
        } else {
            // Inserisce un nuovo prodotto
            return repository.save(product);
        }
    }

    public void deleteProduct(int id) {
    	repository.deleteById(id);
    }
}
