package com.caomei.mapper;

import com.caomei.Model.User;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author 🍓
 * create in 2023/5/19 15:43
 * 我想干嘛：
 */
public interface UserMapper extends Mapper<User> {
    List<User> getAllUser();
}
