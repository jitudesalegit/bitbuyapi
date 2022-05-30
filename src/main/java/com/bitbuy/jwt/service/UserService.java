package com.bitbuy.jwt.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.bitbuy.jwt.dao.RoleDao;
import com.bitbuy.jwt.dao.UserDao;
import com.bitbuy.jwt.entity.Role;
import com.bitbuy.jwt.entity.User;
import com.bitbuy.jwt.entity.UserPersonalInfo;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private RoleDao roleDao;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	UserPersonalInfo userpersonalInfo;
	
	
	public void initRoleAndUser() {

		Role adminRole = new Role();
		adminRole.setRoleName("Admin");
		adminRole.setRoleDescription("Admin role");
		roleDao.save(adminRole);

		Role userRole = new Role();
		userRole.setRoleName("User");
		userRole.setRoleDescription("Default role for newly created record");
		roleDao.save(userRole);

		User adminUser = new User();
		adminUser.setUserName("admin123");
		adminUser.setUserPassword(getEncodedPassword("admin@pass"));
		adminUser.setUserFirstName("admin");
		adminUser.setUserLastName("admin");
		adminUser.setEmailId("admin@gmail.com");
		adminUser.setPhoneNumber("1234588771");
		Set<Role> adminRoles = new HashSet<>();
		adminRoles.add(adminRole);
		adminUser.setRole(adminRoles);
		userDao.save(adminUser);

//        User user = new User();
//        user.setUserName("raj123");
//        user.setUserPassword(getEncodedPassword("raj@123"));
//        user.setUserFirstName("raj");
//        user.setUserLastName("sharma");
//        Set<Role> userRoles = new HashSet<>();
//        userRoles.add(userRole);
//        user.setRole(userRoles);
//        userDao.save(user);
	}

	public UserPersonalInfo registerUser(User user) throws Exception {
		
		Role role = roleDao.findById("User").get();
		Set<Role> userRoles = new HashSet<>();
		userRoles.add(role);
		user.setRole(userRoles);
		user.setUserPassword(getEncodedPassword(user.getUserPassword()));
		
		if (userDao.save(user) == null) {
			return null;
		} else {
			userpersonalInfo.setUserName(user.getUserName());
			userpersonalInfo.setUserFirstName(user.getUserFirstName());
			userpersonalInfo.setUserLastName(user.getUserLastName());
			userpersonalInfo.setPhoneNumber(user.getPhoneNumber());
			userpersonalInfo.setEmailId(user.getEmailId());
			return userpersonalInfo;
		}
		
		
	}

	public String getEncodedPassword(String password) {
		return passwordEncoder.encode(password);
	}

	public User getUser(String uuid) {

		return userDao.findById(uuid).get();
	}

	public UserPersonalInfo getUserDetails(String uuid) {

		User user = userDao.findById(uuid).get();

		if (user != null) {
			userpersonalInfo.setUserName(user.getUserName());
			userpersonalInfo.setUserFirstName(user.getUserFirstName());
			userpersonalInfo.setUserLastName(user.getUserLastName());
			userpersonalInfo.setPhoneNumber(user.getPhoneNumber());
			userpersonalInfo.setEmailId(user.getEmailId());
			return userpersonalInfo;
		} else
			return null;

	}

	public UserPersonalInfo updateUser(String uuid, UserPersonalInfo updatedUser) throws Exception {
		
		User user = getUser(uuid);
		
		if (user != null) {
			user.setUserFirstName(updatedUser.getUserFirstName());
			user.setUserLastName(updatedUser.getUserLastName());
			user.setEmailId(updatedUser.getEmailId());
			user.setPhoneNumber(updatedUser.getPhoneNumber());
						
			user = userDao.save(user);
			updatedUser.setUserName(uuid);
			
			if (user != null)
				return updatedUser;
			else
				return null;

		} else {
			return null;
		}

	}

}
