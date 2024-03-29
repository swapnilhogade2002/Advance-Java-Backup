package com.test.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "CONTACT")
public class Contact {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cid;

//    @NotBlank(message = "Name is required.")
//    @Size(min = 2, max = 8, message = "Minimum size should be 2 and maximum 2")
	private String name;

//    @NotBlank(message = "Surname is required.")
	private String surname;

//    @NotBlank(message = "Work is required.")
	private String work;

//    @NotBlank(message = "Email is required.")
	private String email;

	// Update the type of the phone field to String
//    @NotBlank(message = "Phone is required.")
	private String phone;

	private String image;

//    @Column(length = 50)
	private String description;

	@ManyToOne
	private User user;

	// Getters and setters

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getWork() {
		return work;
	}

	public void setWork(String work) {
		this.work = work;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Contact [cid=" + cid + ", name=" + name + ", surname=" + surname + ", work=" + work + ", email=" + email
				+ ", phone=" + phone + ", image=" + image + ", description=" + description + ", user=" + user + "]";
	}
}
