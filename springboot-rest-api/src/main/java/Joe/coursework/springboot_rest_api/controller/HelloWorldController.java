package Joe.coursework.springboot_rest_api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


// http://localhost:8080/hello-world
@RestController
public class HelloWorldController {

    @GetMapping("/hello-world")
    public String helloWorld(){

        return "Hello World";
    }

}
