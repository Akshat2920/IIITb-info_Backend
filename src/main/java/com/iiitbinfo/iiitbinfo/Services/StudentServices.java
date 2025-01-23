package com.iiitbinfo.iiitbinfo.Services;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.iiitbinfo.iiitbinfo.helper.JWTHelper;
import com.iiitbinfo.iiitbinfo.dto.StudentLogin;
import com.iiitbinfo.iiitbinfo.dto.StudentRequest;
import com.iiitbinfo.iiitbinfo.Repo.StudentRepo;
import com.iiitbinfo.iiitbinfo.mapper.StudentMapper;
import com.iiitbinfo.iiitbinfo.entity.Student;
import com.iiitbinfo.iiitbinfo.Exception.InvalidPasswordException;
import com.iiitbinfo.iiitbinfo.Exception.StudentNotFoundException;

@Service
@RequiredArgsConstructor
public class StudentServices {
    private final StudentRepo studentRepo;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final JWTHelper jwt;

    public Student addNewStudent(StudentRequest studentRequest){
        Student student = StudentMapper.toEntity(studentRequest);
        student.setPassword(bCryptPasswordEncoder.encode(student.getPassword()));
        return studentRepo.save(student);
    }

    public String loginStudent(StudentLogin studentLogin){
        Student student = studentRepo.findByRollNo(studentLogin.rollNo())
                                     .orElseThrow(() -> new StudentNotFoundException("Ivalid User"));

        if (!bCryptPasswordEncoder.matches(studentLogin.password(), student.getPassword())) {
            throw new InvalidPasswordException("Invalid password");
        }
        return jwt.generateToken(studentLogin.rollNo());
    }
}
