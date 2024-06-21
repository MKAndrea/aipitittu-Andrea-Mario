package it.utente.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="prodotti")
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	@Column(name="idProdotto")
	private int id;
	@Column(name="nome_prodotto")
	private String nome_prodotto ;
	@Column(name="prezzo")
	private double prezzo;
	@Column(name="idshop")
	private int idshop;

	public Product() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome_prodotto() {
		return nome_prodotto;
	}

	public void setNome_prodotto(String nome_prodotto) {
		this.nome_prodotto = nome_prodotto;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	public int getIdshop() {
		return idshop;
	}

	public void setIdshop(int idshop) {
		this.idshop = idshop;
	}

}

