package Joe.coursework.springboot_rest_api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
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
        students.add(new Student(2,"Anthony", "Volpe"));
        students.add(new Student(3,"Sebastion", "Aho"));
        students.add(new Student(4,"John", "Cinii"));
        
        return students;
    }

    // Spring Boot rest API with path variable
    // {id} - uri template variable
    // http://localhost:8080/students/1/aaron/judge
    @GetMapping("students/{id}/{first-name}/{last-name}")
    public Student studentPathVariable(@PathVariable("id") int studentId,
                                       @PathVariable("first-name") String firstName,
                                       @PathVariable("last-name") String lastName) {
        return new Student(studentId, firstName, lastName);

    }

    // Spring boot REST API with Request Param
    // http://localhost:8080/students/query?id=1&firstName=Anthony&lastName=Rizzo
    @GetMapping("students/query")
    public Student studentRequestVariable(@RequestParam int id,
                                            @RequestParam String firstName,
                                            @RequestParam String lastName) {
        return new Student(id, firstName, lastName);

    }

    //Spring boot rest api that handles HTTP Post Request - create resource
    //@PostMapping and @RequestBody
    @PostMapping("students/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@RequestBody Student student) {
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        
        return student;
    }

    // Spring boot REST API that handles http put Reuqest - updating resource
    // http://localhost:8080/students/3/update
    @PutMapping("students/{id}/update")
    public Student updateStudent(@RequestBody Student student, @PathVariable("id") int studentId) {
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return student;
    }

    // Spring Boot REST API that handles HTTP delete Request - deleting resource
    @DeleteMapping("students/{id}/delete")
    public String deleteStudent(@PathVariable("id") int studentId) {
        System.out.println(studentId);
        return "Student deleted successfully";
    }
    
}
