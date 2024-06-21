package it.utente.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.utente.entity.Shop;
import jakarta.transaction.Transactional;

@Repository
public interface ShopRepository extends JpaRepository<Shop,Integer> {
	 @Modifying
	    @Transactional
	    @Query(value = "INSERT INTO shop (idshops, denominazione, indirizzo) " +
	                   "VALUES (:idshops, :denominazione, :indirizzo) " +
	                   "ON DUPLICATE KEY UPDATE denominazione = :denominazione, indirizzo = :indirizzo", nativeQuery = true)
	    void upsertShop(@Param("idshops") int idshops, 
	                       @Param("denominazione") String denominazione, 
	                       @Param("indirizzo") String indirizzo
	                       );
}
