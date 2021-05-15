package com.springtests.mvc.springmvctest.controller;

import com.springtests.mvc.springmvctest.model.Alien;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String home() {
        System.out.println("home page req");
        return "index";
    }

    @RequestMapping("sendVals")
    public ModelAndView sendVals(@RequestParam("text1") String textVal,
                                 @RequestParam("num1") String numVal) {
        ModelAndView mv = new ModelAndView("values");
        mv.addObject("resText", textVal);
        mv.addObject("resNum", numVal);

        return mv;
    }

    @RequestMapping("alienate")
    public String alienate(@RequestParam("id2") String id2,
                           @RequestParam("name2") String name2,
                           Model alienModel) {
        Alien newAlien = new Alien(id2, name2);
        alienModel.addAttribute("alien", newAlien);
        return "alienated";
    }

    ///Model attribute adds objects to the model automatically
    @RequestMapping("alienationWithStyle")
    public String alienationWithStyle(@ModelAttribute("alienStyle") Alien alien) {
        return "alienated";
    }
}
