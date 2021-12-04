/**
 * 
 */
package com.salesSystem.mvc.model;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 * @author Jaber
 *
 */
@Entity
public class Product {
	

	@Id
	@SequenceGenerator(
			name="product_sequence",
			sequenceName="product_sequence",
			allocationSize = 1
			)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "product_sequence"
			)	
	private Integer id;
	private String name;
	private String description;
	private String category;
	private Integer price; 
	@Column(name = "local_date_time", columnDefinition = "TIMESTAMP")
	private LocalDateTime creationDate;
	public Product() {
	}

	public Product(String name, String description, String category, LocalDateTime creationDate) {
		this.setName(name);
		this.setDescription(description);
		this.setCategory(category);
		this.setCreationDate(creationDate);
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description=" + description + ", category=" + category
				+ ", price=" + price + ", creationDate=" + creationDate + "]";
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		Product product = (Product) obj;
		return Objects.equals(id, product.id);

	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, description, category,price, creationDate);
	}
	public Integer getID() {
		return id;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getCategory() {
		return category;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

	public LocalDateTime getCreationDate() {
	    
		return creationDate;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getPrice() {
		return price;
	}
}
