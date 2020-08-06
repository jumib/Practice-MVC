package com.example.lecture.controller;

import com.example.lecture.entity.ItemMania;
import com.example.lecture.service.ItemManiaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ItemManiaController {
    private static final Logger log = LoggerFactory.getLogger(ItemManiaController.class);

    @Autowired
    private ItemManiaService service;

    @GetMapping("/lists")
    public String list(Model model) throws Exception {
        log.info("lists()");
        model.addAttribute("list", service.list()); //서비스 객체가 없어서 그럼, 만들어줘야

        return "itemMania/list";
    }

    @GetMapping("/getRegisters")
    public String getRegister(ItemMania itemMania, Model model) {
        log.info("getRegisters()");

        return "itemMania/register";
    }

    @PostMapping("/postRegisters")
    public String postRegister(ItemMania itemMania, Model model) throws Exception {
        log.info("postRegisters()");

        service.register(itemMania);

        model.addAttribute(
                "msg",
                "Register Success");

        return "itemMania/success";
    }

    @GetMapping("/reads")
    public String read(int num, Model model) throws Exception {
        log.info("reads()");

        model.addAttribute("itemMania", service.read(num));

        return "itemMania/read";
    }

    @PostMapping("/removes")
    public String remove(int boardNum, Model model) throws Exception {
        log.info("removes()");

        service.remove(boardNum);
        model.addAttribute("msg", "Success Delete");

        return "itemMania/success";
    }

    @GetMapping("/getmodifies")
    public  String modify(int boardNum, Model model) throws Exception {
        log.info("getmodifies()");
        model.addAttribute(service.read(boardNum)); //modify 순서 : 한번 읽고 - 수정하고 -돌려주기

        return "itemMania/modify";
    }

    @PostMapping("/postmodifies")
    public String modify(ItemMania itemMania, Model model) throws Exception {
        log.info("postmodifies()");
        service.modify(itemMania);
        model.addAttribute("msg", "Modify Success");

        return "itemMania/success";
    }
}