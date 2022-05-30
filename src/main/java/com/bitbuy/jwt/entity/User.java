package com.bitbuy.jwt.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import java.util.Set;

@Entity
public class User {
	
    @Id
    @Size(min = 4, max=16, message = "user name should have between 4 and 16 charasters")
    @NotBlank(message = "Username should not be blank")
    @NotEmpty(message = "Username should not be empty")
    @NotNull(message = "Username should not be null")
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
    
    @Size(min = 1, max=100, message = "Password should have between 4 and 16 charasters")
    @NotBlank(message = "User password should not be blank")
    @NotEmpty(message = "User password should not be empty")
    @NotNull(message = "User password should not be null")
    private String userPassword;
    
    @Email
    @Size(min = 3, max=30, message = "Password should have between 3 and 30 charasters")
	@NotBlank(message = "User email should not be blank")
	@NotEmpty(message = "User email should not be empty")
	@NotNull(message = "User email should not be null")
	private String emailId;

	@NotBlank(message = "User phone number should not be blank")
	@NotEmpty(message = "User phone number should not be empty")
	@NotNull(message = "User phone number should not be null")
	@Size(min=10,max=11, message="Phone should have between 10 and 11 digits")
	@Pattern(regexp="(^$|[0-9]{10})", message="Phone should be between 10 or 11 digits")
	private String phoneNumber;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "USER_ROLE",
            joinColumns = {
                    @JoinColumn(name = "USER_ID")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "ROLE_ID")
            }
    )
    private Set<Role> role;

	  
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

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Set<Role> getRole() {
        return role;
    }

    public void setRole(Set<Role> role) {
        this.role = role;
    }
}
