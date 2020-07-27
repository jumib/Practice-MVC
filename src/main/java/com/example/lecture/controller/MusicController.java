package com.example.lecture.controller;

import com.example.lecture.entity.Music;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// @Controller는 HTML 핸들링에 특화되어 있으므로
// 데이터를 처리하고자 할 경우 ResponseEntity를 활용해줘야 한다.
// @RestController는 json 형식으로 데이터 처리에 특화되어 있으므로
// HTML을 처리하고자 할 경우 ModelAndView를 활용해야 한다.

// @RestController는 어떤 데이터든 json으로 처리
@RestController
@RequestMapping("musics")
public class MusicController {
    final static Logger log =
            LoggerFactory.getLogger(MusicController.class);

    @GetMapping("")
    public ModelAndView musicIndex() {
        log.info("musicIndex()");

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("music/musicIndex");

        return modelAndView;
    }
    //rest는 디폴트로 제이슨처리 (스트링으로 보여줌) (핸들링할거 많으면 써주면 좋다)
    //모델엔뷰를 쓸때는 html핸들링 많을때
    //그냥 컨트롤러는 responseentity 를 붙여서 데이터를 핸들링
    @GetMapping("/test")
    public Music musicTest() {
        log.info("musicTest()");

        Music music = new Music();

        return music;
    }

    @GetMapping("/play")
    public ModelAndView musicPlay() {
        log.info("musicPlay()");

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("music/musicPlay");

        return modelAndView;
    }

    @GetMapping("/menu")
    public ModelAndView musicMenu() {
        log.info("musicMenu()");

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("music/musicMenu");

        return modelAndView;
    }

    @GetMapping("/record")
    public ModelAndView musicRecord() {
        log.info("musicRecord()");

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("music/musicRecord");

        return modelAndView;
    }

    @GetMapping("/titles")
    public List<Music> musicTitles(){
        log.info("musicTitles()");

        List<Music> list = new ArrayList<Music>();

        Music music1 = new Music();
        list.add(music1);

        Music music2 = new Music();
        list.add(music2);

        return list;
    }

    @GetMapping("/artists")
    public Map<String, Music> musicArtists(){
        log.info("musicArtists()");

        Map<String, Music> map = new HashMap<String, Music>();
        Music music1 = new Music();
        map.put("jiha", music1);

        Music music2 = new Music();
        map.put("ABC", music2);

        return map;

    }

    @GetMapping("/respTest")
    public ResponseEntity<Void> musicRespTest(){
        log.info("musicRespTest()");

        return new ResponseEntity<Void>(HttpStatus.OK);
        //일반컨트롤러에서 제이스ㄴ처리하고싶다 -->ResponseEntity쓰기
        //restcontroller는 html컨트롤을 못하기 때문에 모델앤뷰를 해준다.
    }
    @GetMapping("/respstring")
    public ResponseEntity<String> musicResponseString(){
        log.info("musicResponseString()");

        return new ResponseEntity<String>("Success", HttpStatus.OK);

    }

    @GetMapping("/respclass")
    public ResponseEntity<Music> musicRespClass(){
        log.info("musicRespClass()");

        Music music = new Music();
        return new ResponseEntity<Music>(music, HttpStatus.OK);
    }

    @GetMapping("/resplist")
    public ResponseEntity<List<Music>> musicRespList(){
        log.info("");

        List<Music> list = new ArrayList<Music>();

        Music music1 = new Music();
        list.add(music1);

        Music music2 = new Music();
        list.add(music2);

        return new ResponseEntity<List<Music>>(list, HttpStatus.OK);
    }

    @GetMapping("/respfile") //이미지처리할때 바이트형식 주의하기
    public ResponseEntity<byte[]> musicImgFile()throws Exception{
        log.info("");

        InputStream in = null;
        ResponseEntity<byte[]> entity = null;

        try{
            HttpHeaders headers = new HttpHeaders();

            in = new FileInputStream("/home/bitai/proj/PythonWorkshop/test_image_2.jpg");
            headers.setContentType(MediaType.IMAGE_JPEG);

            entity = new ResponseEntity<byte[]>(
                    IOUtils.toByteArray(in),
                    headers, HttpStatus.CREATED);
        } catch(Exception e){
            e.printStackTrace();
            entity = new ResponseEntity<byte[]>(
                    HttpStatus.BAD_REQUEST);
        } finally {
            in.close();
        }
        return entity;
    }

}