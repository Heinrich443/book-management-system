package com.myjava.springboot.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.myjava.springboot.pojo.Book;

import java.util.List;

public interface BookService {

    /**
     * 查询图书列表
     */
    List<Book> getAll();

    /**
     * 查询单本图书
     */
    Book getById(int id);

    /**
     * 新增图书
     */
    Boolean save(Book book);

    /**
     * 修改图书信息
     */
    Boolean modify(Book book);

    /**
     * 删除图书
     */
    Boolean remove(int id);

    /**
     * 分页查询
     */
    Page<Book> getPage(int cucrrentPage, int pageSize);

    /**
     * 条件查询+分页
     */
    Page<Book> getPage(int currentPage, int pageSize, Book book);
}
