package com.sylvie233.ytgz_management_system_api.controller;

import com.sylvie233.ytgz_management_system_api.security.UserDetailsServiceImpl;
import com.sylvie233.ytgz_management_system_api.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
public class AdminControllter {

    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @PostMapping("/login")
    public Result<String> login(@RequestParam String username, @RequestParam String password, HttpServletRequest request) {
        return userDetailsService.login(username, password, request);
    }
}
