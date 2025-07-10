package com.waltoncrm.authenticationproject.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.waltoncrm.authenticationproject.Dao.StudentRepository;
import com.waltoncrm.authenticationproject.Model.Student;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    List<Student> students = new ArrayList<>();


    @Override
    public String CreateStudent(Student student) {
        studentRepository.save(student);
        return "Saved Successfully";
    }

    @Override
    public List<Student> ReadStudents() {
        List<Student> studentList = studentRepository.findAll();
        return studentList;
    }

    @Override
    public boolean DeleteStudent(Long Id) {
        studentRepository.deleteById(Id);
        return true;
    }
    
}
