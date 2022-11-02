package com.ljm.Mysql;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService{

 @Autowired
 private UserMapper mapper;

 public List<User> select(){

//     List<User> users = mapper.selectList(new LambdaQueryWrapper<>());
     List<User> select = mapper.getSelect();
//     return  users;
     return select;

 }

    @Override
    public List<User> getSelect() {


        List<User> list = this.list(new LambdaQueryWrapper<>());
        return list;
    }
}
