package com.ljm.Mysql;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
@Mapper
public interface UserMapper extends BaseMapper<User> {

   List<User> getSelect();
}
