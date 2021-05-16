package com.springtests.mvc.springmvctest.controller;

import com.springtests.mvc.springmvctest.model.Alien;
import com.springtests.mvc.springmvctest.repository.AlienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//if @Controller is chosen @ResponseBody needs to be entered for all methods since
//spring expects you to jump to views
//If we are only going to use this controller as a service, RestController annotation should be used
//@RestController
@Controller
public class AlienController {
    @Autowired
    AlienRepository alienRepo;

    @GetMapping("aliens")
    @ResponseBody
    public List<Alien> getAliens() {
        return alienRepo.findAll();
    }

    @GetMapping("alien/{id}")
    @ResponseBody
    public Alien getAlien(@PathVariable("id") int id) {
        return alienRepo.findById(id);
    }

    @PostMapping("alien")
    @ResponseBody
    public Alien addAlien(@RequestBody Alien alien) {
        alienRepo.save(alien);
        return alien;
    }
}
