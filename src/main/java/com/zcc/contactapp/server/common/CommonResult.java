package com.zcc.contactapp.server.common;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by cc on 2019/4/2.
 */
@Data
public class CommonResult<T> {

    public CommonResult(T data) {
        this.data = data;
    }

    public CommonResult(int code, T data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    int code = 100;

    T data;

    String msg = "";

}
