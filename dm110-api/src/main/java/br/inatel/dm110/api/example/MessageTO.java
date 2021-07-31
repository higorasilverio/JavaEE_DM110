package br.inatel.dm110.api.example;

import java.io.Serializable;

public class MessageTO implements Serializable {

	private static final long serialVersionUID = -5106558229027863908L;

	private String firstName;
	private String lastName;
	private String message;

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

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "MessageTO [firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	
}