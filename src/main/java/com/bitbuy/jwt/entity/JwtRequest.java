package com.bitbuy.jwt.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class JwtRequest {

    @NotBlank(message = "Username should not be blank")
    @NotEmpty(message = "Username should not be empty")
    @NotNull(message = "Username should not be null")
	private String userName;
	
    @NotBlank(message = "Password should not be blank")
    @NotEmpty(message = "Password should not be empty")
    @NotNull(message = "Password should not be null")
    private String userPassword;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
