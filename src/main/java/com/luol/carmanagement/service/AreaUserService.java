package com.luol.carmanagement.service;

import com.luol.carmanagement.entity.AreaUser;
import org.springframework.data.domain.Page;

public interface AreaUserService {
    /**
     * 分页查询
     * @param pageNum
     * @param size
     * @return
     */
    Page<AreaUser> getAreaUserList(Integer pageNum, Integer size);

    /**
     * 删除区域
     * @param id
     */
    void delAreaUser(Integer id);

    /**
     * 添加区域
     * @param area
     * @return
     */
    boolean saveAreaUser(AreaUser areaUser);


    /**
     * 修改区域
     * @param area
     * @return
     */
    boolean editAreaUser(AreaUser areaUser);
}
