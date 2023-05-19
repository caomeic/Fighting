package com.caomei.controller;

import com.caomei.Model.User;
import com.caomei.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 🍓
 * create in 2023/5/19 15:59
 * 我想干嘛：
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @Transactional
    @GetMapping("/all")
    public List<User> getAll(){
        List<User> userList = userService.findAll();
        return userList;

    }

    @GetMapping("/page/{pageNumber}")
    public List<User> getPageAll(@PathVariable Integer pageNumber){
        /**
        *
        * @Description: 分页处理
        * @Param:
        * @Return:
        */
        PageHelper.startPage(pageNumber , 3);
        PageInfo<User> pageInfo = new PageInfo<>(userService.findAll());
//        if (pageInfo.getPageNum() < pageNumber) {
//            List list1 = new LinkedList();
//            list1.add(200);
//            return list1;
//        }
        List<User> users = pageInfo.getList();
        return users;
    }

}
