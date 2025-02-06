package Joe.coursework.springboot_rest_api.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import Joe.coursework.springboot_rest_api.bean.Student;

@RestController
@RequestMapping("students")
public class StudentController {

    // http://localhost:8080/student
    @GetMapping("student")
    public ResponseEntity<Student> getStudent() {
        Student student = new Student (1, "Joe", "Calcagno");

        // return new ResponseEntity<>(student, HttpStatus.OK);
        return ResponseEntity.ok().header("customer-header", 
        "joe").body(student);
    }


    // http://localhost:8080/students
    @GetMapping
    public ResponseEntity<List<Student>> getStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1,"Joe", "Calcagno"));
        students.add(new Student(2,"Anthony", "Volpe"));
        students.add(new Student(3,"Sebastion", "Aho"));
        students.add(new Student(4,"John", "Cinii"));
        
        return ResponseEntity.ok(students);
    }

    // Spring Boot rest API with path variable
    // {id} - uri template variable
    // http://localhost:8080/students/1/aaron/judge
    @GetMapping("{id}/{first-name}/{last-name}")
    public ResponseEntity<Student> studentPathVariable(@PathVariable("id") int studentId,
                                       @PathVariable("first-name") String firstName,
                                       @PathVariable("last-name") String lastName) {
        Student student = new Student(studentId, firstName, lastName)   ;                 
        return ResponseEntity.ok(student);

    }

    // Spring boot REST API with Request Param
    // http://localhost:8080/students/query?id=1&firstName=Anthony&lastName=Rizzo
    @GetMapping("query")
    public ResponseEntity<Student> studentRequestVariable(@RequestParam int id,
                                            @RequestParam String firstName,
                                            @RequestParam String lastName) {
        Student student = new Student(id, firstName, lastName);
        return ResponseEntity.ok(student);

    }

    //Spring boot rest api that handles HTTP Post Request - create resource
    //@PostMapping and @RequestBody
    @PostMapping("create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    // Spring boot REST API that handles http put Reuqest - updating resource
    // http://localhost:8080/students/3/update
    @PutMapping("{id}/update")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable("id") int studentId) {
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return ResponseEntity.ok(student);
    }

    // Spring Boot REST API that handles HTTP delete Request - deleting resource
    @DeleteMapping("{id}/delete")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") int studentId) {
        System.out.println(studentId);
        return ResponseEntity.ok("Student deleted successfully");
    }

}
