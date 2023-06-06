package com.luol.carmanagement.service;

import com.luol.carmanagement.entity.AreaUser;
import com.luol.carmanagement.entity.SystemLog;
import com.luol.carmanagement.entity.SystemUser;
import org.springframework.data.domain.Page;

public interface SystemUserService {

    SystemUser getSystemUser(Integer id);

    Page<SystemUser> getSystemUser(Integer pageNum, Integer size);


    /**
     * 删除用户
     * @param id
     */
    void delUser(Integer id);

    /**
     * 添加用户
     * @param systemUser
     * @return
     */
    boolean saveUser(SystemUser systemUser);


    /**
     * 修改用户
     * @param systemUser
     * @return
     */
    boolean editUser(SystemUser systemUser);
}
