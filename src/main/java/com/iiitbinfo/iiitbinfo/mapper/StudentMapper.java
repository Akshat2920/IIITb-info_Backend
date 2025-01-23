package com.iiitbinfo.iiitbinfo.mapper;
import com.iiitbinfo.iiitbinfo.dto.StudentLogin;
import com.iiitbinfo.iiitbinfo.dto.StudentRequest;
import com.iiitbinfo.iiitbinfo.entity.Student;

public class StudentMapper {
    public static Student toEntity(StudentRequest studentRequest){
        return Student.builder()
                .email(studentRequest.email())
                .rollNo(studentRequest.rollNo())
                .firstName(studentRequest.firstName())
                .lastName(studentRequest.lastName())
                .password(studentRequest.password())
                .build();
    }

    public static StudentLogin toDTO(Student student){
        return new StudentLogin(
            student.getRollNo(),
            student.getPassword()
        );
    }

}
