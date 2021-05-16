package com.springtests.mvc.springmvctest.controller;

import com.springtests.mvc.springmvctest.model.Alien;
import com.springtests.mvc.springmvctest.repository.AlienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {


    @Autowired
    private AlienRepository alienRepo;

    @GetMapping("getAliens")
    public String getAliens(Model model){
        model.addAttribute("alienList", alienRepo.findAll());
        return "showAliens";
    }

    @GetMapping("findAliens")
    public String findAliens(@RequestParam("id3") int id3, Model model){
        model.addAttribute("alien", alienRepo.findById(id3));
        return "alienated";
    }

    @GetMapping("findAlienByName")
    public String findAlienByName(@RequestParam("name3") String name3, Model model){
        //model.addAttribute("alienList", alienRepo.findByName(name3));
        model.addAttribute("alienList", alienRepo.findByNameIgnoreCaseContaining(name3));
        return "showAliens";
    }


    @GetMapping("findAlienWithBiggerId")
    public String findAlienWithBiggerId(@RequestParam("id4") int id4, Model model){
        model.addAttribute("alienList", alienRepo.filterAliensWithBiggerID(id4));
        return "showAliens";
    }

    ///@RequestMapping("alienate") will accept any method of connection
    // below mapping will only accept POST
    @RequestMapping(value = "alienate", method = RequestMethod.POST)
    public String alienate(@RequestParam("id2") int id2,
                           @RequestParam("name2") String name2,
                           Model alienModel) {
        Alien newAlien = new Alien(id2, name2);
        alienRepo.save(newAlien);
        alienModel.addAttribute(newAlien);
        return "alienated";
    }



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
                                 @RequestParam("num1") int numVal) {
        ModelAndView mv = new ModelAndView("values");
        mv.addObject("resText", textVal);
        mv.addObject("resNum", numVal);

        return mv;
    }

    // below mapping will only accept POST
    ///Model attribute adds objects to the model automatically
    @PostMapping("alienationWithStyle")
    public String alienationWithStyle(@ModelAttribute("alienStyle") Alien alien) {
        return "alienated";
    }
}
