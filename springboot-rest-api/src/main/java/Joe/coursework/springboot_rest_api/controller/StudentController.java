package Joe.coursework.springboot_rest_api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import Joe.coursework.springboot_rest_api.bean.Student;


@RestController
public class StudentController {

    // http://localhost:8080/student
    @GetMapping("student")
    public Student getStudent() {
        Student student = new Student (1, "Joe", "Calcagno");

        return student;
    }


    // http://localhost:8080/students
    @GetMapping("students")
    public List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1,"Joe", "Calcagno"));
        students.add(new Student(2,"Ellen", "Whittington"));
        students.add(new Student(3,"Joseph", "Ciampi"));
        students.add(new Student(4,"John", "Cinii"));
        
        return students;
    }
}
