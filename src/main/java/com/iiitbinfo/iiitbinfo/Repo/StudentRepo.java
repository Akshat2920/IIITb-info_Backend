package com.iiitbinfo.iiitbinfo.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import com.iiitbinfo.iiitbinfo.entity.Student;


public interface StudentRepo extends JpaRepository<Student, Long>{
    Optional<Student> findByEmail(String email);
}
