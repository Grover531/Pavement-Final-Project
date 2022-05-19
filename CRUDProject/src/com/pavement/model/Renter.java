package com.pavement.model;

public class Renter {
	private Integer id;
	private String email;
	private String firstName;
	private String lastName;
	private String contactNumber;
	
	public Renter() {
		
	}

	public Renter(Integer id, String email, String firstName, String lastName, String contactNumber) {
		this(email, firstName, lastName, contactNumber);
		this.id = id;
	}

	public Renter(String email, String firstName, String lastName, String contactNumber) {
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.contactNumber = contactNumber;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	@Override
	public String toString() {
		return "Renter [id=" + id + ", email=" + email + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", contactNumber=" + contactNumber + "]";
	}

}
