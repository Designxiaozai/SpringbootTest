package com.ljm.Mysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MysqlController {

     @Autowired
     private UserServiceImpl service;

    @GetMapping
    public List<User> Connection(){
        List<User> select = service.select();
        return  select;
    }

}
