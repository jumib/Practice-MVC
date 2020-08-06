package com.example.lecture.service;


import com.example.lecture.entity.Members;


public interface MembersService {
    public void signup(Members members) throws Exception;
    public boolean login(Members members) throws Exception;
    public boolean idcheck(Members members) throws Exception;
}
