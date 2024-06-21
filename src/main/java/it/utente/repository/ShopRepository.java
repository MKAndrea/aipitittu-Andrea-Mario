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
	    @Query(value = "INSERT INTO shop (id, name, address,image_preview,city,phonenumber,:tax_code) " +
	                   "VALUES (:id, :name,: address, :image_preview,:city,:phonenumber,:tax_code) " +
	                   "ON DUPLICATE KEY UPDATE name = :name, address = :address,image_preview = :image_preview,city = :city"
	                   + "phonenumber = :phonenumber,tax_code = :tax_code", nativeQuery = true)
	    void upsertShop(@Param("id") int id, 
	                       @Param("name") String name, 
	                       @Param("address") String address,
	                       @Param("image_preview") String image_preview,
	                       @Param("city") String city,
	                       @Param("phonenumber") String phonenumber,
	                       @Param("tax_code") String tax_code
	                       );
}
