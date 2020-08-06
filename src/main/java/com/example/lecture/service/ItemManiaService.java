package com.example.lecture.service;

import com.example.lecture.entity.ItemMania;

import java.util.List;

public interface ItemManiaService {
    public List<ItemMania> list() throws Exception;
    public void register(ItemMania itemMania) throws Exception;
    public ItemMania read(Integer boardNum) throws Exception;
    public void remove(Integer boardNum) throws Exception;
    public void modify(ItemMania itemMania) throws Exception;


}
