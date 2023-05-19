package com.caomei.basemapper;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author 🍓
 * create in 2023/5/19 15:38
 * 我想干嘛：
 */
public interface sameMethod<T> extends Mapper<T> , MySqlMapper<T> {
}
