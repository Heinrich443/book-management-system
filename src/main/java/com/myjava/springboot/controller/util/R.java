package com.myjava.springboot.controller.util;

import lombok.Data;

@Data
public class R {

    private Boolean flag;

    private String msg;

    private Object data;

    public R(Boolean flag, Object data) {
        this.flag = flag;
        this.data = data;
    }

    public R(Boolean flag, String msg) {
        this.flag = flag;
        this.msg = msg;
    }
}
