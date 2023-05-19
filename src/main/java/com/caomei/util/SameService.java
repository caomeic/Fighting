package com.caomei.util;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author 🍓
 * create in 2023/5/19 15:55
 * 我想干嘛：
 */
public class SameService<T> {
    /**
     * 泛型注入
     */
    @Autowired
    private Mapper<T> mapper;

    /**
     * 按条件分页查询
     *
     * @param t        查询条件
     * @param pageNum  当前页码
     * @param pageSize 一页显示多少条
     * @return
     */
    public PageInfo<T> findPage(T t, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<T> list = findList(t);
        return new PageInfo<T>(list);
    }

    /**
     * 查询所有
     *
     * @return
     */
    public List<T> findAll() {
        return mapper.selectAll();
    }

    /**
     * 通过条件查询
     *
     * @param param
     * @return
     */
    public List<T> findList(T param) {
        return mapper.select(param);
    }

    /**
     * 通过条件查询,分页查询
     *
     * @param t        查询条件
     * @param pageNum  当前页码
     * @param pageSize 一页显示多少条
     * @return
     */
    public List<T> findList(T t, int pageNum, int pageSize) {
        return mapper.selectByRowBounds(t, new RowBounds(pageNum, pageSize));
    }

    /**
     * 通过条件查一个
     *
     * @param t
     */
    public void findOne(T t) {
        mapper.selectOne(t);
    }

    /**
     * 通过id查询
     *
     * @param id
     * @return
     */
    public T getById(Object id) {
        return (T) mapper.selectByPrimaryKey(id);

    }

    /**
     * 通过id删除
     *
     * @param id
     */

    public void deleteById(Object id) {
        mapper.deleteByPrimaryKey(id);
    }

    /**
     * 添加信息
     *
     * @param t
     */

    public void add(T t) {
        mapper.insertSelective(t);
    }

    /**
     * 更新商品信息
     *
     * @param t
     */
    public void update(T t) {
        mapper.updateByPrimaryKeySelective(t);
    }

    /**
     * 返回对应条件的信息数
     *
     * @param t
     * @return
     */
    public Integer findCount(T t) {
        return mapper.selectCount(t);
    }

    /**
     * 通过指定条件删除
     *
     * @param param
     */

    public void delete(T param) {
        mapper.delete(param);
    }
}
