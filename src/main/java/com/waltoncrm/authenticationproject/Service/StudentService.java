package com.waltoncrm.authenticationproject.Service;

import java.util.List;

import com.waltoncrm.authenticationproject.Model.Student;

public interface StudentService {
    String CreateStudent(Student student);
    List<Student> ReadStudents();
    boolean DeleteStudent(Long Id);
}
