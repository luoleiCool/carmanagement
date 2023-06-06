package com.luol.carmanagement.service.impl;

import com.luol.carmanagement.entity.AreaUser;
import com.luol.carmanagement.entity.SystemUser;
import com.luol.carmanagement.repository.SystemLogRepository;
import com.luol.carmanagement.repository.SystemUserRepository;
import com.luol.carmanagement.service.SystemUserService;
import jakarta.annotation.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class SystemUserServiceImpl implements SystemUserService {

    @Resource
    private SystemUserRepository systemUserRepository;

    @Override
    public SystemUser getSystemUser(Integer id) {
        return systemUserRepository.findSystemUserById(id);
    }

    @Override
    public Page<SystemUser> getSystemUser(Integer pageNum, Integer size) {
        PageRequest pageRequest = PageRequest.of(pageNum, size, Sort.by("id").ascending());
        return systemUserRepository.findAll(pageRequest);
    }

    @Override
    public void delUser(Integer id) {
        systemUserRepository.deleteById(id);
    }


    @Override
    public boolean saveUser(SystemUser systemUser) {
        try {
            systemUserRepository.saveAndFlush(systemUser);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public boolean editUser(SystemUser systemUser) {
        try {
            systemUserRepository.saveAndFlush(systemUser);
        }catch (Exception e){
            return false;
        }
        return true;
    }
}
