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
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

/**
 * @author Jaber
 *
 */
@Entity
public class Sales {

	@Id
	@SequenceGenerator(name = "sales_sequence", sequenceName = "sales_sequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sales_sequence")
	private Integer id;
	@Column(name = "local_date_time", columnDefinition = "TIMESTAMP")
	private LocalDateTime creationDate;
	@ManyToOne
	private Client client;
	@ManyToOne
	private Product product;
	private String seller;
	private Integer count;
	private Integer total;

	public Sales() {
	}

	public Sales(LocalDateTime creationDate, Client client, String seller, Integer total) {
		this.setCreationDate(creationDate);
		this.setClient(client);
		this.setSeller(seller);
		this.setTotal(total);
	}

	@Override
	public String toString() {
		return "Sales [id=" + id + ", creationDate=" + creationDate + ", client=" + client.toString() + ", product="
				+ product.toString() + ", seller=" + seller + ", count=" + count + ", total=" + total + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		Sales sales = (Sales) obj;
		return Objects.equals(id, sales.id);

	}

	@Override
	public int hashCode() {
		return Objects.hash(id, creationDate, client, seller, count, total);
	}

	public Integer getID() {
		return id;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Client getClient() {
		return client;
	}

	public void setSeller(String seller) {
		this.seller = seller;
	}

	public String getSeller() {
		return seller;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Product getProduct() {
		return product;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Integer getCount() {
		return count;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Integer getTotal() {
		return total;
	}

}
