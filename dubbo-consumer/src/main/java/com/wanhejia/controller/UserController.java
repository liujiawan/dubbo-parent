package com.wanhejia.controller;

import com.wanhejia.api.HelloService;
import com.wanhejia.entity.User;
import com.wanhejia.service.UserService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author:0xOO
 * @Date: 2018/9/26 0026
 * @Time: 14:42
 */

@RestController
@RequestMapping("/testBoot")
public class UserController {

    @Autowired
    private UserService userService;
    @RequestMapping("getUser/{id}")
    public String getUser(@PathVariable int id) throws Exception {
       User user= userService.getById(1);
        userService.saveAndUpdate();
       return null;
    }
}
