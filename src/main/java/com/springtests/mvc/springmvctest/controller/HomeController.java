package com.springtests.mvc.springmvctest.controller;

import com.springtests.mvc.springmvctest.model.Alien;
import org.apache.tomcat.util.digester.ArrayStack;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @ModelAttribute
    public void readyModelData(Model genericModel) {
        genericModel.addAttribute("somethingElse", "this is from somewhere else");
    }

    @RequestMapping("/")
    public String home() {
        System.out.println("home page req");
        return "index";
    }

    ///@RequestMapping("sendVals") will accept any method of connection
    // below mapping will only accept POST
    @RequestMapping(value = "sendVals", method = RequestMethod.POST)
    public ModelAndView sendVals(@RequestParam("text1") String textVal,
                                 @RequestParam("num1") String numVal) {
        ModelAndView mv = new ModelAndView("values");
        mv.addObject("resText", textVal);
        mv.addObject("resNum", numVal);

        return mv;
    }

    ///@RequestMapping("alienate") will accept any method of connection
    // below mapping will only accept POST
    @RequestMapping(value = "alienate", method = RequestMethod.POST)
    public String alienate(@RequestParam("id2") String id2,
                           @RequestParam("name2") String name2,
                           Model alienModel) {
        Alien newAlien = new Alien(id2, name2);
        alienModel.addAttribute("alien", newAlien);
        return "alienated";
    }


    // below mapping will only accept POST
    ///Model attribute adds objects to the model automatically
    @PostMapping("alienationWithStyle")
    public String alienationWithStyle(@ModelAttribute("alienStyle") Alien alien) {
        return "alienated";
    }
}
