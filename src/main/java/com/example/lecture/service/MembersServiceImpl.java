package com.example.lecture.service;

import com.example.lecture.entity.Members;
import com.example.lecture.repository.MembersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class MembersServiceImpl implements MembersService {

    @Autowired
    private MembersRepository membersRepository ;

    @Override
    public void signup(Members members) throws Exception {
        membersRepository.signup(members);
    }

    @Override
    public boolean login(Members members) throws Exception {
        return membersRepository.login(members);
    }

    @Override
    public boolean idcheck(Members members) throws Exception {
        return membersRepository.idcheck(members);
    }

    @Override
    public String idsearch(Members members) throws Exception {
        return membersRepository.idsearch(members);
    }

    @Override
    public String pwsearch(Members members) throws Exception {
        return membersRepository.pwsearch(members);
    }
}
