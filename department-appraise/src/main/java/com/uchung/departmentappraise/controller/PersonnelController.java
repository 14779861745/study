package com.uchung.departmentappraise.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.uchung.departmentappraise.model.Personnel;
import com.uchung.departmentappraise.service.IPersonnelService;
import com.uchung.departmentappraise.until.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 员工控制器层
 */
@RequestMapping("person")
@RestController
public class PersonnelController extends BaseController{

    @Autowired
    private IPersonnelService personnelService;

    /**
     * 获取所有的员工信息列表
     * @return
     */
    @GetMapping("list")
    public JsonResult<List<Personnel>> list(){
        List<Personnel> list = personnelService.findAll();
        return new JsonResult<>(SUCCESS,list);
    }

    /**
     * 获取分页的员工信息
     * @param pageNo 第几页
     * @param pageNum 多少条
     * @return
     */
    @GetMapping("page")
    public JsonResult<Map<String,Object>> page(Integer pageNo,Integer pageNum, Map<String,Object> map){
        //  创建Page对象，将page，limit参数传入，必须位于从数据库查询数据的语句之前，否则不生效
        Page page= PageHelper.startPage(pageNo, pageNum);
        //  ASC是根据id 正向排序，DESC是反向排序
        PageHelper.orderBy("id ASC");
        // 从数据库查询，这里返回的的findAll就已经分页成功了
        Page<Personnel> list = personnelService.getAll();
        // 获取查询记录总数，必须位于从数据库查询数据的语句之后，否则不生效
        map.put("list",list);
        map.put("total",page.getTotal());
        return new JsonResult<>(SUCCESS,map);
    }

    /**
     * 添加员工
     * @param personnel
     * @return
     */
    @PostMapping("add")
    public JsonResult<Void> add(@RequestBody Personnel personnel){
        personnelService.addPerson(personnel);
        return new JsonResult<>();
    }

    /**
     * 修改员工信息
     * @param personnel
     * @return
     */
    @PostMapping("change")
    public JsonResult<Void> change(@RequestBody Personnel personnel){
        personnelService.changePerson(personnel);
        return new JsonResult<>();
    }

    /**
     * 删除员工信息
     * @param id
     * @return
     */
    @PostMapping("delete")
    public JsonResult<Void> delete(@RequestParam("id") Integer id){
        personnelService.delete(id);
        return new JsonResult<>();
    }
}
