package com.wanhejia.service;

import com.wanhejia.api.HelloService;
import com.wanhejia.dao.UserDao;
import com.wanhejia.entity.User;
import io.seata.spring.annotation.GlobalTransactional;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.transaction.TransactionAutoConfiguration;
import org.springframework.http.server.reactive.HttpHeadResponseDecorator;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class UserService {
    @Autowired
	private UserDao userDao;

	@Reference(version = "${dubbo.service.version}")
	private HelloService helloService;

	public void setHelloService(HelloService helloService) {
		this.helloService = helloService;
	}
	public List<User> getByMap(Map<String,Object> map){
		return userDao.getByMap(map);
	}
	
	public User getById(Integer id){
		return userDao.getById(id);
	}
	@Transactional
	public User create(User user){
		userDao.create(user);
		return user;
	}
	
	public User update(User user){
		userDao.update(user);
		return user;
	}
	public int delete(Integer id){
		return userDao.delete(id);
	}
	@GlobalTransactional
	public void saveAndUpdate() throws Exception {
		helloService.sayHello("你好");
		User user=new User();
		user.setAddress("1");
		user.setMobile("");
		user.setName("1");
		user.setRole(1);
		user.setCreateTime(new Date());
		userDao.create(user);
		throw new Exception("库存不足");
	}
}