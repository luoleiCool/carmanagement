package com.luol.carmanagement.repository;

import com.luol.carmanagement.entity.SystemUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author luolei
 */
public interface SystemUserRepository extends JpaRepository<SystemUser, Integer> {


    /**
     * 查询用户登录
      * @param userName
     * @param password
     * @return
     */
    SystemUser findSystemUserByUserNameAndPassword(String userName, String password);
}
