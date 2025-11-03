package com.myjava.springboot.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.myjava.springboot.pojo.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class BookDaoTest {

    @Autowired
    private BookDao bookDao;

    /**
     * 根据id查图书信息
     */
    @Test
    public void testSelectById() {
        Book book = bookDao.selectById(12);
        System.out.println(book);
    }

    /**
     * 查询所有图书
     */
    @Test
    public void testSelectList() {
        List<Book> books = bookDao.selectList(null);
        for (Book book: books) {
            System.out.println(book);
        }
    }

    /**
     * 新增图书
     */
    @Test
    public void testInsert() {
        Book book = new Book();
        book.setType("aaaaaaaa");
        book.setName("bbbbbbbb");
        book.setDescription("cccccccc");
        int count = bookDao.insert(book);
        System.out.println(count);
    }

    /**
     * 修改图书
     */
    @Test
    public void testUpdateById() {
        Book book = new Book();
        book.setId(66);
        book.setName("aaaaaaaa");
        book.setDescription("aaaaaaaa");
        int count = bookDao.updateById(book);
        System.out.println(count);
    }

    /**
     * 删除图书
     */
    @Test
    public void testDeleteById() {
        int count = bookDao.deleteById(66);
        System.out.println(count);
    }

    /**
     * 分页查询
     */
    @Test
    public void testPagination() {
        int currentPage = 1, pageSize = 5;
        Page<Book> page = new Page<>(currentPage, pageSize);
        List<Book> books = bookDao.selectList(page, null);
        for (Book book: books) {
            System.out.println(book);
        }
    }

    /**
     * 条件查询
     */
    @Test
    public void testCondition() {
        LambdaQueryWrapper<Book> lwq = new LambdaQueryWrapper<>();
        lwq.like(Book::getName, "java").like(Book::getDescription, "spring");
        List<Book> books = bookDao.selectList(null, lwq);
        for (Book book: books) {
            System.out.println(book);
        }
    }

    /**
     * 条件查询+分页
     */
    @Test
    public void testPageAndCondition() {
        int currentPage = 1, pageSize = 3;
        Page<Book> page = new Page<>(currentPage, pageSize);
        LambdaQueryWrapper<Book> lwq = new LambdaQueryWrapper<>();
        lwq.like(Book::getDescription, "spring");
        List<Book> books = bookDao.selectList(page, lwq);
        for (Book book: books) {
            System.out.println(book);
        }
    }
}
