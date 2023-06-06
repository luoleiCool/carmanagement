package com.luol.carmanagement.service;

import com.luol.carmanagement.entity.Area;
import com.luol.carmanagement.entity.SystemLog;
import org.springframework.data.domain.Page;

public interface AreaService {
    /**
     * 分页查询
     * @param pageNum
     * @param size
     * @return
     */
    Page<Area> getAreaList(Integer pageNum, Integer size);

    /**
     * 删除区域
     * @param id
     */
    void delArea(Integer id);

    /**
     * 添加区域
     * @param area
     * @return
     */
    boolean saveArea(Area area);


    /**
     * 修改区域
     * @param area
     * @return
     */
    boolean editArea(Area area);
}
