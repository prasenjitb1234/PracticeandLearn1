package com.validate.springvalidation.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class LoginData {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // or GenerationType.AUTO
	private Long id;

	@NotBlank(message = "User name cannot be empty ")
	@Size(min = 3, max = 16, message = "Username must be between 3 to 16 characters")
	private String userName;
	
	@Pattern(regexp="^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$" ,message ="Invalid Email !! ")
	private String email;
	
	
	@AssertTrue(message="Must agree terms and conditions !!")
	private boolean agreed;
	
	
	
	
	public boolean isAgreed() {
		return agreed;
	}
	public void setAgreed(boolean agreed) {
		this.agreed = agreed;
	}
	@Override
	public String toString() {
		return "LoginData [id=" + id + ", userName=" + userName + ", email=" + email + "]";
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LoginData(Long id,
			@NotBlank(message = "User name cannot be empty ") @Size(min = 3, max = 12, message = "Username must be between 3 to 12 characters") String userName,
			String email) {
		super();
		this.id = id;
		this.userName = userName;
		this.email = email;
	}
	public LoginData() {
		super();
		// TODO Auto-generated constructor stub
	}

	

}
