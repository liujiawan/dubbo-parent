package com.wanhejia;

import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Author:zhansan
 * Date:2020/5/26
 * Description:
 */
@SpringBootApplication
@MapperScan(basePackages = {"com.wanhejia.**.dao"})
@DubboComponentScan("com.wanhejia.rmi")
public class NacosProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(NacosProviderApplication.class, args);
    }

}

