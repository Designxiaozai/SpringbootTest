package com.ljm.Mysql;

import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface UserService extends IService<User> {

    List<User> getSelect();
}
