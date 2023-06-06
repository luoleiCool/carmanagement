package com.luol.carmanagement.service.impl;

import com.luol.carmanagement.entity.Area;
import com.luol.carmanagement.entity.SystemLog;
import com.luol.carmanagement.repository.AreaRepository;
import com.luol.carmanagement.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class AreaServiceImpl implements AreaService {


    @Autowired
    private AreaRepository areaRepository;

    @Override
    public Page<Area> getAreaList(Integer pageNum, Integer size) {
        PageRequest pageRequest = PageRequest.of(pageNum, size, Sort.by("createTime").descending());
        return areaRepository.findAll(pageRequest);
    }

    @Override
    public void delArea(Integer id) {
        areaRepository.deleteById(id);
    }


    @Override
    public boolean saveArea(Area area) {
        try {
            areaRepository.saveAndFlush(area);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public boolean editArea(Area area) {
        try {
            areaRepository.saveAndFlush(area);
        }catch (Exception e){
            return false;
        }
        return true;
    }
}
