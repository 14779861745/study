package com.uchung.departmentappraise.controller;

import com.uchung.departmentappraise.model.Other;
import com.uchung.departmentappraise.service.IOtherService;
import com.uchung.departmentappraise.until.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("other")
public class OtherController extends BaseController{
    @Autowired
    private IOtherService iOtherService;

    /**
     * 获取other列表信息
     * @return
     */
    @GetMapping("list")
    public JsonResult<List<Other>> list(){
        List<Other> list = iOtherService.findAll();
        return new JsonResult<>(SUCCESS,list);
    }
}
