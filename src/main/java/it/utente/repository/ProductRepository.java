package it.utente.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.utente.entity.Product;
import jakarta.transaction.Transactional;
@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
	 @Modifying
	    @Transactional
	    @Query(value = "INSERT INTO prodotti (idProdotto, nome_prodotto, prezzo, idshop) " +
	                   "VALUES (:id, :nome_prodotto, :prezzo, :idshop) " +
	                   "ON DUPLICATE KEY UPDATE nome_prodotto = :nome_prodotto, prezzo = :prezzo, idshop = :idshop", nativeQuery = true)
	    void upsertProduct(@Param("id") int id, 
	                       @Param("nome_prodotto") String nome_prodotto, 
	                       @Param("prezzo") int prezzo, 
	                       @Param("idshop") int idshop);
}
