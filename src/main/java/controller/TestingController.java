package controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestingController {

    @GetMapping("user")
    public String helloUser(){
        return "Hello user";
    }

    @GetMapping("admin")
    public String helloAdmin(){
        return "Hello Admin";
    }
}
