package com.cdac.hss.controllers;


import com.cdac.hss.config.JwtProvider;
import com.cdac.hss.entities.User;
import com.cdac.hss.enums.RoleName;
import com.cdac.hss.request.LoginRequest;
import com.cdac.hss.request.SignUpRequest;
import com.cdac.hss.response.AuthResponse;
import com.cdac.hss.response.JwtResponse;
import com.cdac.hss.service.CustomUserDetailsImpl;
import com.cdac.hss.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomUserDetailsImpl customUserDetails;

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/signin")
    public ResponseEntity<AuthResponse> authenticateUser(@RequestBody LoginRequest loginRequest) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequest.getEmail(),
                            loginRequest.getPassword()
                    )
            );

            SecurityContextHolder.getContext().setAuthentication(authentication);

            String jwt = JwtProvider.generateToken(authentication);

            AuthResponse res = new AuthResponse();
            res.setMessage("Signing success");
            res.setJwt(jwt);

            return new ResponseEntity<>(res, HttpStatus.CREATED);

        } catch (Exception ex) {
            ex.printStackTrace(); // Or use logger
            return new ResponseEntity<>(new AuthResponse("Authentication Failed: " + ex.getMessage(), null), HttpStatus.UNAUTHORIZED);
        }
    }


//
//    java.lang.StackOverflowError: null
//    at java.base/java.lang.reflect.InvocationTargetException.<init>(InvocationTargetException.java:68) ~[na:na]

    @PostMapping("/signup")
    public ResponseEntity<AuthResponse> registerUser(@RequestBody SignUpRequest signUpRequest) throws Exception {
        if (userService.getUserByEmail(signUpRequest.getEmail()) != null) {
//            return ResponseEntity.badRequest().body("Error: Email is already in use!");
            throw new Exception("Email already Exists ");

        }

        User user = new User(signUpRequest.getUserId(), signUpRequest.getUsername(), signUpRequest.getEmail(),
                passwordEncoder.encode(signUpRequest.getPassword()),signUpRequest.getMobile(),signUpRequest.getDesignation());

        List<Integer> rolesId = signUpRequest.getRoleId();
        List<Integer> domainsId = signUpRequest.getDomainId();

        userService.registerUser(user, rolesId, domainsId);
//      return ResponseEntity.ok("User registered successfully!");

        Authentication authentication = new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = JwtProvider.generateToken(authentication);

        AuthResponse res = new AuthResponse();
        res.setMessage("Signup Success");
        res.setJwt(jwt);

        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }



}
