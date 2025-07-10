package com.waltoncrm.authenticationproject.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.waltoncrm.authenticationproject.Model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    
}
