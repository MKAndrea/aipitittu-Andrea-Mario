package it.utente.entity;


import jakarta.persistence.*;

@Entity
@Table(name="shops")
public class Shop {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="name")
	private String name;
	@Column(name="address")
	private String address;
	@Column(name="image_preview")
	private String image_preview;
	@Column(name="city")
	private String city;
	@Column(name="phonenumber")
	private String phonenumber;
	@Column(name="tax_code")
	private String tax_code;
	@Column(name="deleted")
	private String deleted;

	
	public Shop() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getImage_preview() {
		return image_preview;
	}

	public void setImage_preview(String image_preview) {
		this.image_preview = image_preview;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getTax_code() {
		return tax_code;
	}

	public void setTax_code(String tax_code) {
		this.tax_code = tax_code;
	}

	public String getDeleted() {
		return deleted;
	}

	public void setDeleted(String deleted) {
		this.deleted = deleted;
	}

	
}
