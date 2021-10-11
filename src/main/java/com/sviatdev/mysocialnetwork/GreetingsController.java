package com.sviatdev.mysocialnetwork;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class GreetingsController {

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required = false, defaultValue = "World")
                                       String name, Map<String, Object> map){
        map.put("name", name);
        return "greeting";
    }

    @GetMapping
    public String main(Map<String, Object> map){
        map.put("text", "Hello, sviatdev!");
        return "main";
    }
}
