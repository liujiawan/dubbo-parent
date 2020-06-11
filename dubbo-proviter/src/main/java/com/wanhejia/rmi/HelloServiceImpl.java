package com.wanhejia.rmi;

import com.wanhejia.api.HelloService;
import com.wanhejia.entity.User;
import com.wanhejia.service.UserService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @author ly
 **/
@Service(version = "${dubbo.service.version}")
public class HelloServiceImpl implements HelloService {

    @Value("${spring.application.name}")
    private String serviceName;
    @Autowired
    private UserService userService;
    @Transactional
    public String sayHello(String name) {
        User user=new User();
        user.setAddress("1");
        user.setMobile("");
        user.setName("1");
        user.setRole(1);
        user.setCreateTime(new Date());
        userService.create(user);
        return "添加成功";
    }

}
