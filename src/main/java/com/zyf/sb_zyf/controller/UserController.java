package com.zyf.sb_zyf.controller;

import com.zyf.sb_zyf.pojo.DTO.UserDTO;
import com.zyf.sb_zyf.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController//把接口方法返回对象转换为json文本
@RequestMapping("/user")//加一个类级别的映射user，则接口方法映射为/user/方法名
// 通过localhost:8080/user接口从前端访问
public class UserController {

    @Autowired
    IUserService userService;

    //增加
    @PostMapping//接受前端的post请求
    //@RequestBody可以把前端传来的json文本转换为对象
    public String add(@RequestBody UserDTO user){
        userService.add(user);
        return "success!";
    }

    //删除
    @DeleteMapping
    public String delete(@PathVariable UserDTO user){
        userService.delete(user);
        return "success!";
    }

    //修改
    @PutMapping
    public String update(@RequestBody Integer id,UserDTO user){
        userService.update(id, user);
        return "success!";
    }



    //查询
    @GetMapping
    public String queryByID(Integer id){
        userService.queryByID(id);
        return "success!";
    }
}
