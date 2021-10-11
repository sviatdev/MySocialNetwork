package com.sviatdev.mysocialnetwork;

import com.sviatdev.mysocialnetwork.domain.Message;
import com.sviatdev.mysocialnetwork.repos.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class GreetingsController {
    private final MessageRepo messageRepo;

    @Autowired
    public GreetingsController(MessageRepo messageRepo) {
        this.messageRepo = messageRepo;
    }

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World")
                                   String name, Map<String, Object> map) {
        map.put("name", name);
        return "greeting";
    }

    @GetMapping
    public String main(Map<String, Object> map) {
        Iterable<Message> messages = messageRepo.findAll();
        map.put("messages", messages);
        return "main";
    }

    @PostMapping
    public String addMessage(@RequestParam String text, @RequestParam String tag, Map<String, Object> map) {
        Message message = new Message(text, tag);
        messageRepo.save(message);

        Iterable<Message> messages = messageRepo.findAll();
        map.put("messages", messages);
        return "main";
    }

    @PostMapping("filter")
    public String filter(@RequestParam String filter, Map<String, Object> map) {
        Iterable<Message> messages;
        if (filter != null && !filter.isEmpty()) {
            messages = messageRepo.findByTag(filter);
        }else {
            messages = messageRepo.findAll();
        }

        map.put("messages", messages);

        return "main";
    }
}
