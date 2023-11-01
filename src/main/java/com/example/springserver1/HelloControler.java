package com.example.springserver1;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloControler {
    @GetMapping("/hello")
    @ResponseBody
    public String hello(){
        return "이거 어캐 하는거임?";
    }
}
