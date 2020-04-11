package com.uchung.departmentappraise.service;

import com.uchung.departmentappraise.service.exception.OtherException;
import com.uchung.departmentappraise.service.exception.InfoEmptyException;
import com.uchung.departmentappraise.model.Personnel;
import com.github.pagehelper.Page;
import com.uchung.departmentappraise.service.exception.InfoEmptyException;

import java.util.List;

/**
 * 员工信息逻辑接口
 */
public interface IPersonnelService {
    /**
     * 寻找所有员工信息
     * @return 员工列表
     */
    List<Personnel> findAll();

    /**
     * 分页寻找所有的员工
     * @return
     */
    Page<Personnel> getAll();

    /**
     * 添加员工信息
     */
    void addPerson(Personnel personnel)throws InfoEmptyException;

    /**
     * 修改员工信息
     * @param personnel
     */
    void changePerson(Personnel personnel)throws InfoEmptyException,OtherException;

    void delete(Integer id)throws InfoEmptyException,OtherException;
}
