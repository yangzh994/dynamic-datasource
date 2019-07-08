package com.github.datasourcemany.mapper;

import com.github.datasourcemany.model.User;
import org.apache.ibatis.annotations.Insert;

public interface UserMapper {


    @Insert("insert into user(name) values(#{name})")
    public int insert(User user);
}
