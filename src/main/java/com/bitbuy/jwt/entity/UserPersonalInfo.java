package com.bitbuy.jwt.entity;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

@Component
public class UserPersonalInfo {

	private String userName;
	
    @Size(min = 2, max=16, message = "First name should have between 2 and 16 charasters")
	@NotBlank(message = "First name should not be blank")
	@NotEmpty(message = "First name should not be empty")
	@NotNull(message = "First name should not be null")
	private String userFirstName;

    @Size(min = 2, max=16, message = "Last name should have between 2 and 16 charasters")
	@NotBlank(message = "Last name should not be blank")
	@NotEmpty(message = "Last name should not be empty")
	@NotNull(message = "Last name should not be null")
	private String userLastName;

	@Email
    @Size(min = 3, max=30, message = "Password should have between 3 and 30 charasters")
	@NotBlank(message = "User email should not be blank")
	@NotEmpty(message = "User email should not be empty")
	@NotNull(message = "User email should not be null")
	private String emailId;

	@NotBlank(message = "User phone number should not be blank")
	@NotEmpty(message = "User phone number should not be empty")
	@NotNull(message = "User phone number should not be null")
	@Size(min=10,max=11, message="Phone should be between 10 or 11 digits")
	@Pattern(regexp="(^$|[0-9]{10})", message="Phone should have between 10 and 11 digits")
	private String phoneNumber;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserFirstName() {
		return userFirstName;
	}

	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	public String getUserLastName() {
		return userLastName;
	}

	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
