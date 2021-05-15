package com.springtests.mvc.springmvctest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String home(){
        System.out.println("home page req");
        return "index.jsp";
    }

    @RequestMapping("sendVals")
    public String sendVals(HttpServletRequest req){
        String textVal= req.getParameter("text1");
        String numVal= req.getParameter("num1");

        HttpSession session= req.getSession();
        session.setAttribute("resText",textVal);
        session.setAttribute("resNum",numVal);

        return "values.jsp";
    }
}
