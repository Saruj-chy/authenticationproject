package com.waltoncrm.authenticationproject.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.waltoncrm.authenticationproject.Model.Student;
import com.waltoncrm.authenticationproject.Service.StudentServiceImpl;


@Controller
// @RestController
public class StudentController {
    
    private final StudentServiceImpl studentServiceImpl;

    public StudentController(StudentServiceImpl studentServiceImpl){
        this.studentServiceImpl = studentServiceImpl;
    }

    // @GetMapping("student")
    // public List<Student> getStudentData() {
    //     return studentServiceImpl.ReadStudents();
    // }

    @GetMapping("/req/student")
    public String showStudentRegForm() {
        return "student";
    }

    @GetMapping("login")
    public String login() {
        return "login";
    }
    

    @PostMapping("student")
    public String createStudent(@RequestBody Student student) {        
        return studentServiceImpl.CreateStudent(student);
    }

    @DeleteMapping("student/{id}")
    public String deleteStudent(@PathVariable Long id){
        if(studentServiceImpl.DeleteStudent(id))
            return "Delete Successfully";
        return "Not Found";
    }
    
    

    
}
