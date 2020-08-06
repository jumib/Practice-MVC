package com.example.lecture.controller;

import com.example.lecture.entity.Members;
import com.example.lecture.repository.MembersRepository;
import com.example.lecture.service.MembersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MembersController {
    private static final Logger log = LoggerFactory.getLogger(MembersController.class);

    @Autowired
    private MembersService service;

    @GetMapping("/log")
    public String log(Members members) {
        log.info("log()");

        return "members/log";
    }


    @PostMapping("/postaccess")
    private String postaccess(Members members) throws Exception{
        log.info("postaccess()");

        boolean results = service.login(members);
        if(!results){
            return "members/complete";
        } else {
            return "members/fail";
        }
    }


    @GetMapping("/getsignup")
    public String getsignup(Members members, Model model) throws Exception {
        log.info("getsignup()");

        return "members/signup";
    }

    @PostMapping("/postsignup")
    private String postsignup(Members members, Model model) throws Exception{
        log.info("postsignup()");

        service.signup(members);
        model.addAttribute("msg","complete");

        return "members/complete";
    }

    @PostMapping("/postcheck")
    private String postcheck(Members members) throws Exception{
        log.info("postcheck()");
        boolean results = service.idcheck(members);
        if(results){
            return "members/possible";
        } else {
            return "members/impossible";
        }
    }
}
