package com.uchung.departmentappraise.service.impl;

import com.uchung.departmentappraise.mapper.OtherMapper;
import com.uchung.departmentappraise.model.Other;
import com.uchung.departmentappraise.service.IOtherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 其他逻辑层
 */
@Service
public class OtherServiceImpl implements IOtherService {

    @Autowired
    @SuppressWarnings("all")
    private OtherMapper otherMapper;

    @Override
    public List<Other> findAll() {
        return otherMapper.selectAll();
    }
}
