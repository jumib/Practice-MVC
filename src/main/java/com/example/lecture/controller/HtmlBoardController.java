package com.example.lecture.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;
import java.util.Locale;

@Controller
public class HtmlBoardController {
    private static final Logger logger =
            LoggerFactory.getLogger(HtmlBoardController.class);

    @GetMapping(value = "/get", params = "register")
    public String getRegister(){
        logger.info("getRegister()");

        return "register";
    }

    @GetMapping(value = "/get", params = "read")
    public String getRead(){
        logger.info("getRead()");

        return "htmlRead";
    }

    @GetMapping("/html/register")
    public String registerForm() {
        logger.info("registerForm");

        return "htmlRegister";
        }

    @PostMapping("/html/register")
    public String register() {
        logger.info("register(POST)");
        return "htmlRegister";
    }

    @GetMapping("/html/modify")
    public String modifyForm() {
        logger.info("modifyForm()");

        return "htmlModifyForm";
        }

    @PostMapping("/html/modify")
    public String modify() {
        logger.info("modifyForm()");

        return "htmlModifyForm";
    }

    @GetMapping("/html/delete")
    public String deleteForm() {
        logger.info("deleteForm()");

        return "htmlDeleteForm";
        }

    @PostMapping("/html/delete")
    public String delete() {
        logger.info("deleteForm()");

        return "htmlDeleteForm";
    }

    @GetMapping("/html/list")
    public String listForm() {
        logger.info("listForm()");

        return "htmlListForm";
        }

    @GetMapping("/html/board/read/{boardNo}")
    public String readForm(
            //모든 게시판에는 게시판 번호가 있ㄷ.
            //Pathvariable을 통해 가변번호를 받을 수 있다.
            @PathVariable("boardNo") int boardNo) {
        logger.info("readForm: " + boardNo);

        return "htmlRead";
    }
    @GetMapping("/regtestpage")
    public String registerTestPage(){
        logger.info("registerTestPage()");
        return "/form/registerForm";
    }

    @PostMapping("/regtest")
    public String registerTest(String userId, String passwd){
        logger.info("registerTest()");

        logger.info("userId = " + userId);
        logger.info("passwd = " + passwd);

        return "/form/success";
    }
    @GetMapping("/getRegTest")
    public String getRegTest(String userId, Date date){
        logger.info("getRegTest()");
        logger.info("userId = " + userId);
        logger.info("date = " + date);

        return "/form/success";
    }
}



