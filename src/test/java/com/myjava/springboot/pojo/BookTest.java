package com.myjava.springboot.pojo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookTest {

    @Test
    public void testBook() {
        Book book1 = new Book();
        book1.setName("aaaaaaaa");
        book1.setType("bbbbbbbb");
        book1.setDescription("cccccccc");
        System.out.println(book1);
    }
}
