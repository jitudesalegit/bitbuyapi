package com.bitbuy.jwt.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Entity
public class Role {

    @Id
    @NotBlank(message = "Username is mandatory")
 	@NotEmpty(message = "Username should not be empty")
    private String roleName;
    
    private String roleDescription;

    @NotBlank(message = "Username is mandatory")
 	@NotEmpty(message = "Username should not be empty")
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }
}
