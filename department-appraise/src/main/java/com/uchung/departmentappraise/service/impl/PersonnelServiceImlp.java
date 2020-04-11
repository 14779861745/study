package com.uchung.departmentappraise.service.impl;
import com.github.pagehelper.Page;
import com.uchung.departmentappraise.mapper.PersonnelMapper;
import com.uchung.departmentappraise.model.Other;
import com.uchung.departmentappraise.model.Personnel;
import com.uchung.departmentappraise.service.IPersonnelService;
import com.uchung.departmentappraise.service.exception.InfoEmptyException;
import com.uchung.departmentappraise.service.exception.OtherException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 员工信息逻辑实现层
 */
@Service
public class PersonnelServiceImlp implements IPersonnelService {

    @Autowired
    private PersonnelMapper personnelMapper;
    @Override
    public List<Personnel> findAll() {
        return personnelMapper.selectAll();
    }

    @Override
    public Page<Personnel> getAll() {
        return personnelMapper.getAllPage();
    }

    @Override
    public void addPerson(Personnel personnel)throws InfoEmptyException {
        if(personnel!=null){
            personnel.setIsDelete(false);
            personnel.setStatus(true);
            personnel.setCreateDate(new Date());
            personnel.setUpdateDate(new Date());
            personnelMapper.insert(personnel);
        }else {
            throw new InfoEmptyException("添加的信息为空");
        }
    }

    @Override
    public void changePerson(Personnel personnel)throws InfoEmptyException, OtherException {
        if(personnel!=null&&personnel.getId()!=null){
            personnel.setUpdateDate(new Date());
            int num = personnelMapper.updateByPrimaryKey(personnel);
            if(num!=1){
                throw new OtherException("发生未知错误");
            }
        }else {
            throw new InfoEmptyException("修改的信息不存在");
        }
    }

    @Override
    public void delete(Integer id) throws InfoEmptyException, OtherException{
        if(id!=null){
            Personnel personnel = personnelMapper.selectByPrimaryKey(id);
            personnel.setIsDelete(true);
            personnel.setUpdateDate(new Date());
            int num = personnelMapper.updateByPrimaryKey(personnel);
            if(num!=1){
                throw new OtherException("发生未知错误");
            }
        }else {
            throw new InfoEmptyException("参数不存在");
        }
    }
}
