package com.example.lecture.controller;

import com.example.lecture.entity.Board;
import com.example.lecture.service.BoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BoardController {
    private static final Logger log =
            LoggerFactory.getLogger(BoardController.class);

    @Autowired
    private BoardService service;

    @GetMapping("/getRegister")
    public String getRegister(Board board, Model model) {
        return "board/register";
    }

    @PostMapping("/postRegister")
    public String postRegister(Board board, Model model) throws Exception {
        log.info("postRegister()");

        service.register(board);

        model.addAttribute(
                "msg",
                "Register Success");

        return "board/success";
    }

    @GetMapping("/list")
    public String list(Model model) throws Exception {
        log.info("list()");
        //속성추가 (이름 : list)
        //controller -> service -> Repository방식으로
        //동작하게 설계되어있다.
        //DB에서 받아온 정보가 list에 들어있다
        model.addAttribute(
                "list",
                service.list());
        // html파일
        return "board/list";
    }

    @GetMapping("/read")
    public String read(int boardNo, Model model) throws Exception {
        log.info("read()");

        model.addAttribute("board", service.read(boardNo));

        return "board/read";
    }

    @PostMapping("/remove")
    public String remove(int boardNo, Model model) throws Exception {
        log.info("remove()");

        service.remove(boardNo);
        model.addAttribute("msg", "Success Delete!");

        return "board/success";
    }

    @GetMapping("/getModify")
    public String modify(int boardNo, Model model) throws Exception {
        log.info("getModify()");
        model.addAttribute(service.read(boardNo)); //modify 순서 : 한번 읽고 - 수정하고 -돌려주기

        return "board/modify";
    }

    @PostMapping("/postModify")
    public String modify(Board board, Model model) throws Exception {
        log.info("postModify()");
        service.modify(board);
        model.addAttribute("msg", "Modify Success");

        return "board/success";
    }
}
