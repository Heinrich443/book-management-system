package com.myjava.springboot.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.myjava.springboot.pojo.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class BookServiceTest {

    @Autowired
    private BookService service;

    @Test
    public void testGatAll() {
        List<Book> books = service.getAll();
        for (Book book: books) {
            System.out.println(book);
        }
    }

    @Test
    public void testGetById() {
        Book book = service.getById(61);
        System.out.println(book);
    }

    @Test
    public void testSave() {
        Book book = new Book();
        book.setType("aaaaaaaa");
        book.setName("bbbbbbbb");
        book.setDescription("cccccccc");
        Boolean save = service.save(book);
        System.out.println(save);
    }

    @Test
    public void testModify() {
        Book book = new Book();
        book.setId(67);
        book.setName("aaaaaaaa");
        book.setDescription("aaaaaaaa");
        Boolean modify = service.modify(book);
        System.out.println(modify);
    }

    @Test
    public void testRemove() {
        Boolean remove = service.remove(67);
        System.out.println(remove);
    }

    @Test
    public void testGetPage1() {
        int currentPage = 1, pageSize = 5;
        List<Book> books = service.getPage(currentPage, pageSize);
        for (Book book: books) {
            System.out.println(book);
        }
    }

    @Test
    public void testGetPage2() {
        Book book1 = new Book();
        book1.setName("java");
        book1.setDescription("spring");
        List<Book> books = service.getPage(book1);
        for (Book book: books) {
            System.out.println(book);
        }
    }

    @Test
    public void testGetPage3() {

    }
}
