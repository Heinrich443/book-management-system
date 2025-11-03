package com.myjava.springboot.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.myjava.springboot.controller.util.R;
import com.myjava.springboot.pojo.Book;
import com.myjava.springboot.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService service;

    @GetMapping("/{id}")
    public R selectById(@PathVariable("id") Integer id) {
        Book book = service.getById(id);
        return new R(true, book);
    }

    @GetMapping
    public R list() {
        List<Book> books = service.getAll();
        return new R(true, books);
    }

    @GetMapping("/{currentPage}/{pageSize}")
    public R selectPage(@PathVariable("currentPage") int currentPage, @PathVariable("pageSize") int pageSize, Book book) {
        Page<Book> page = service.getPage(currentPage, pageSize);
        if (currentPage > page.getPages()) {
            currentPage = (int) page.getPages();
        }
        return new R(true, service.getPage(currentPage, pageSize, book));
    }

    @PostMapping
    public R saveBook(@RequestBody Book book) {
        Boolean flag = service.save(book);
        return new R(flag, flag ? "操作成功^_^" : "操作失败-_-!");
    }

    @DeleteMapping("/{id}")
    public R deleteBook(@PathVariable("id") Integer id) {
        Boolean flag = service.remove(id);
        return new R(flag, flag ? "操作成功^_^" : "操作失败-_-!");
    }

    @PutMapping
    public R updateBook(@RequestBody Book book) {
        Boolean flag = service.modify(book);
        return new R(flag, flag ? "操作成功^_^" : "操作失败-_-!");
    }
}
