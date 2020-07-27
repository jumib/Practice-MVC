package com.example.lecture.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

@Controller
public class MainController {
    static final Logger log =
            LoggerFactory.getLogger(MainController.class);

    // localhost:8080/으로 접속하면
    // 제어 유닛이 아래 코드를 실행시킨다.
    @GetMapping("/")
    /////////////요청(/)을 처리하려고 받아간 것 뿐이다. 끝난 거 아님
    public String index(Locale locale, Model model) {
        log.info("index()");

        //현재 날짜를 받아온다
        Date date = new Date();
        //DateFormat.getDateTimeInstance를 통해 연,월,일,지역정보를 가져온다다
        //형식지정자
        DateFormat dateFormat = DateFormat.getDateTimeInstance(
                DateFormat.LONG, DateFormat.LONG, locale
        );

        //dateFormat.format을 이용해 위의 정보를 문자열로 만든다
        //주어진 형식대호 서식이 있는 날짜형태의 문자를 만든다
        String formattedDate = dateFormat.format(date);
        //최종적으로 만든 정보를 servTime 속성에 전달한다
        model.addAttribute("servTime", formattedDate);

        // index.html을 보여준다.
        return "index";
    }
}


//model = 데이터
//view = 화면 (html)
//controller = RestController & Controller