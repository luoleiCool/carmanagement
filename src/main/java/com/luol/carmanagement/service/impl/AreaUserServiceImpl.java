package com.luol.carmanagement.service.impl;

import com.luol.carmanagement.entity.AreaUser;
import com.luol.carmanagement.repository.AreaUserRepository;
import com.luol.carmanagement.service.AreaService;
import com.luol.carmanagement.service.AreaUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class AreaUserServiceImpl implements AreaUserService {


    @Autowired
    private AreaUserRepository areaUserRepository;

    @Override
    public Page<AreaUser> getAreaUserList(Integer pageNum, Integer size) {
        PageRequest pageRequest = PageRequest.of(pageNum, size, Sort.by("createTime").descending());
        return areaUserRepository.findAll(pageRequest);
    }

    @Override
    public void delAreaUser(Integer id) {
        areaUserRepository.deleteById(id);
    }


    @Override
    public boolean saveAreaUser(AreaUser areaUser) {
        try {
            areaUserRepository.saveAndFlush(areaUser);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public boolean editAreaUser(AreaUser areaUser) {
        try {
            areaUserRepository.saveAndFlush(areaUser);
        }catch (Exception e){
            return false;
        }
        return true;
    }
}
