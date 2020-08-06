package com.example.lecture.controller;

import com.example.lecture.entity.Member;
import com.example.lecture.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {
    private static final Logger log = LoggerFactory.getLogger(MemberController.class);

    @Autowired
    private MemberService service;

    @GetMapping("/getjoin")
    public String getjoin(Member member, Model model) throws Exception {
        log.info("getjoin()");

        return "member/join";
    }

    @PostMapping("/postjoin")
    public String postjoin(Member member, Model model) throws Exception {
        log.info("postjoin()");

        service.join(member);

        model.addAttribute("msg","success");

        return "member/success";
    }

}
