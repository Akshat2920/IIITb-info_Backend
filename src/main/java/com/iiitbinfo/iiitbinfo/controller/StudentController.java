package com.iiitbinfo.iiitbinfo.controller;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.iiitbinfo.iiitbinfo.entity.Student;
import com.iiitbinfo.iiitbinfo.dto.StudentRequest;
import com.iiitbinfo.iiitbinfo.Services.StudentServices;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/student")
public class StudentController {
    private final StudentServices studentServices;

}
