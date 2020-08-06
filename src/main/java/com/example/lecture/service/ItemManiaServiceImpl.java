package com.example.lecture.service;

import com.example.lecture.entity.ItemMania;
import com.example.lecture.repository.ItemManiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class ItemManiaServiceImpl implements ItemManiaService{

    @Autowired
    private ItemManiaRepository itemManiaRepository;


    @Override
    public List<ItemMania> list() throws Exception {

        return itemManiaRepository.list();
    }

    @Override
    public void register(ItemMania itemMania) throws Exception {
        itemManiaRepository.create(itemMania);
    }

    @Override
    public ItemMania read(Integer boardNum) throws Exception {
        return itemManiaRepository.read(boardNum);
    }

    @Override
    public void remove(Integer boardNum) throws Exception {
        itemManiaRepository.remove(boardNum);
    }

    @Override
    public void modify(ItemMania itemMania) throws Exception {
        itemManiaRepository.modify(itemMania);
    }
}
