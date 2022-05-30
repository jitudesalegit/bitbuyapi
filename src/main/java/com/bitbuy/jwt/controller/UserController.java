package com.bitbuy.jwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bitbuy.jwt.entity.User;
import com.bitbuy.jwt.entity.UserPersonalInfo;
import com.bitbuy.jwt.service.UserService;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	private UserService userService;

	@PostConstruct
	public void initRoleAndUser() {
		userService.initRoleAndUser();
	}

	@PostMapping({ "/register" })
	public ResponseEntity<UserPersonalInfo> registerUser(@Valid @RequestBody(required = true) User user)
			throws Exception {
		UserPersonalInfo userPersonalInfo = userService.registerUser(user);

		if (userPersonalInfo == null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(userPersonalInfo);
		}

	}

	@GetMapping({ "/users/{uuid}" })
	public ResponseEntity<UserPersonalInfo> getUser(@Valid @PathVariable(required = true) String uuid)
			throws Exception {
		UserPersonalInfo userPersonalInfo = userService.getUserDetails(uuid);

		if (userPersonalInfo == null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(userPersonalInfo);
		}

	}

	@PostMapping({ "/users/{uuid}" })
	public ResponseEntity<UserPersonalInfo> updateUser(@Valid @PathVariable(required = true) String uuid,
			@Valid @RequestBody(required = true) UserPersonalInfo updatedUser) throws Exception {
		UserPersonalInfo userPersonalInfo = userService.updateUser(uuid, updatedUser);

		if (userPersonalInfo == null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(userPersonalInfo);
		}

	}

}
