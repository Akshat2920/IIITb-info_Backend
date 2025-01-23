package com.iiitbinfo.iiitbinfo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import jakarta.validation.Valid;

import com.iiitbinfo.iiitbinfo.entity.Student;
import com.iiitbinfo.iiitbinfo.dto.StudentRequest;
import com.iiitbinfo.iiitbinfo.dto.StudentLogin;
import com.iiitbinfo.iiitbinfo.Services.StudentServices;
import com.iiitbinfo.iiitbinfo.helper.JWTHelper;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthenticationController {
    private final StudentServices studentServices;
    @Autowired
    private JWTHelper jwtHelper;

    public AuthenticationController(StudentServices studentServices, JWTHelper jwtHelper) {
        this.studentServices = studentServices;
        this.jwtHelper = jwtHelper;
    }

    //****----LOGIN----****
    @PostMapping("/login") 
    public ResponseEntity<String> loginAdmin(@RequestBody @Valid StudentLogin studentLogin) {
        return ResponseEntity.ok(studentServices.loginStudent(studentLogin));
    }

    //****----SIGNUP----****
    @PostMapping("/signup")
    public ResponseEntity<Student> createAdmin(@RequestBody StudentRequest studentRequest) {
        Student newStudent = studentServices.addNewStudent(studentRequest);
        return ResponseEntity.ok(newStudent);
    }

    //****----VALIDATING TOKEN----****
    @GetMapping("/validate")
    public ResponseEntity<?> validateToken(@RequestHeader("Authorization") String authorizationHeader) {
        //System.out.println(authorizationHeader);
        String token = null;
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            token = authorizationHeader.substring(7); // Remove "Bearer " from the token
        }

        if (token == null || token.isEmpty()) {
            return ResponseEntity.status(401).body("Token is missing");
        }

        try {
            // Validate the token (you may need to extract the username from the token if necessary)
            String username = jwtHelper.extractUsername(token);
            boolean isValid = jwtHelper.validateToken(token, username);

            if (isValid) {
                return ResponseEntity.ok().body("Token is valid");
            } else {
                return ResponseEntity.status(401).body("Invalid token");
            }
        } catch (Exception e) {
            return ResponseEntity.status(401).body("Invalid token");
        }
    }
}
