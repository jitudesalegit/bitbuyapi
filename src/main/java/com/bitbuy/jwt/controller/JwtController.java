package com.bitbuy.jwt.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bitbuy.jwt.entity.JwtRequest;
import com.bitbuy.jwt.entity.JwtResponse;
import com.bitbuy.jwt.service.JwtService;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class JwtController {

    @Autowired
    private JwtService jwtService;

    @PostMapping({"/login"})
    public String bitBuyLogin(@Valid @RequestBody(required = true) JwtRequest jwtRequest) throws Exception {
    	JwtResponse  jwtResponseObj = jwtService.createJwtToken(jwtRequest);
        return "User:"+jwtResponseObj.getUser().getUserName()+" successfully logged in and JWT Token is : Bearer "+jwtResponseObj.getJwtToken() ;
    }
    
}
