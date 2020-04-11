package com.uchung.departmentappraise.mapper;

import com.uchung.departmentappraise.model.Personnel;
import com.uchung.departmentappraise.model.Salary;
import org.springframework.data.repository.query.Param;
import java.util.Date;
import java.math.BigDecimal;
import java.util.List;

public interface SalaryMapper {
        int deleteByPrimaryKey(Integer id);

        int insert(Salary record);

        int insertSelective(Salary record);

        Salary selectByPrimaryKey(Integer id);

        int updateByPrimaryKeySelective(Salary record);

        int updateByPrimaryKey(Salary record);

    /**
     * 定时发工资
     * @param list
     * @param salary
     * @param time
     * @param isDelete
     */
        void insertMany(@Param("list") List<Personnel> list, @Param("salary")BigDecimal salary,
@Param("time")Date time,@Param("isDelete")boolean isDelete);
        }