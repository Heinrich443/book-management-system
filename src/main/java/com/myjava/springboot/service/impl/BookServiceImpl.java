package com.myjava.springboot.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.myjava.springboot.dao.BookDao;
import com.myjava.springboot.pojo.Book;
import com.myjava.springboot.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Override
    public List<Book> getAll() {
        return bookDao.selectList(null);
    }

    @Override
    public Book getById(int id) {
        return bookDao.selectById(id);
    }

    @Override
    public Boolean save(Book book) {
        return bookDao.insert(book) > 0;
    }

    @Override
    public Boolean modify(Book book) {
        return bookDao.updateById(book) > 0;
    }

    @Override
    public Boolean remove(int id) {
        return bookDao.deleteById(id) > 0;
    }

    @Override
    public List<Book> getPage(int currentPage, int pageSize) {
        Page<Book> page = new Page<>(currentPage, pageSize);
        return bookDao.selectList(page, null);
    }

    @Override
    public List<Book> getPage(Book book) {
        LambdaQueryWrapper<Book> lqw = new LambdaQueryWrapper<>();
        lqw.eq(book.getId() != null, Book::getId, book.getId())
                .like(book.getType() != null, Book::getType, book.getType())
                .like(book.getName() != null, Book::getName, book.getName())
                .like(book.getDescription() != null, Book::getDescription, book.getDescription());
        return bookDao.selectList(lqw);
    }

    @Override
    public List<Book> getPage(int currentPage, int pageSize, Book book) {
        Page<Book> page = new Page<>(currentPage, pageSize);
        LambdaQueryWrapper<Book> lqw = new LambdaQueryWrapper<>();
        lqw.eq(book.getId() != null, Book::getId, book.getId())
                .like(book.getType() != null, Book::getType, book.getType())
                .like(book.getName() != null, Book::getName, book.getName())
                .like(book.getDescription() != null, Book::getDescription, book.getDescription());
        return bookDao.selectList(page, lqw);
    }
}
