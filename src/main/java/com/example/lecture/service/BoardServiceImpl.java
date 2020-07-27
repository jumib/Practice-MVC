package com.example.lecture.service;

import com.example.lecture.entity.Board;
import com.example.lecture.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//클래스 BoardService가 인터페이스!!
//Service라는 어노테이션
//Spring <<- Event Driven방식으로 동작을 하고있음
public class BoardServiceImpl implements BoardService {
    // 클래스 사용할 때? -> 객체가 필요하다
    //new를 해줘야 한다는 의미
    // autowired가 붙으면 자동으로 생성자를 만든다는 의미
    @Autowired
    private BoardRepository boardRepository;

    @Override
    public void register(Board board) throws Exception {
        boardRepository.create(board);
    }

    @Override
    public List<Board> list() throws Exception {
        return boardRepository.list();
    }

    @Override
    public Board read(Integer boardNo) throws Exception {
        return boardRepository.read(boardNo);
    }

    @Override
    public void remove(Integer boardNo) throws Exception {
        boardRepository.remove(boardNo);
    }

    @Override
    public void modify(Board board) throws Exception {
        boardRepository.modify(board);
    }
}