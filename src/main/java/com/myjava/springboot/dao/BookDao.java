package com.myjava.springboot.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.myjava.springboot.pojo.Book;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BookDao extends BaseMapper<Book> {
}
