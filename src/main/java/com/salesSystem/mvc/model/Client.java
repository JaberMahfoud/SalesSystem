/**
 * 
 */
package com.salesSystem.mvc.model;

import java.util.Objects;
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
public class Client {
	

	@Id
	@SequenceGenerator(
			name="client_sequence",
			sequenceName="client_sequence",
			allocationSize = 1
			)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "client_sequence"
			)
	private Integer id;
	private String name;
	private String lastName;
	private String mobile;

	public Client() {
	}

	public Client(String name, String lastName, String mobile) {
		this.setName(name);
		this.setLastName(lastName);
		this.setMobile(mobile);
	}
	@Override
	public String toString() {
		return "Client [id=" + id + ", name=" + name + ", lastName=" + lastName + ", mobile=" + mobile + "]";
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		Client client = (Client) obj;
		return Objects.equals(id, client.id);

	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, lastName, mobile);
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

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getMobile() {
		return mobile;
	}
}