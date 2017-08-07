package com.akuan.springboot.exception;

/**
 * @ClassName: MyException
 * @Description: MyException
 * @author: zhaozhenkuan
 * @date: 2017-07-27 下午7:19
 * @version: V1.0
 */
public class MyException extends RuntimeException {

    public MyException(String message) {
        super(message);
    }

    public MyException(String message, Throwable cause) {
        super(message, cause);
    }

    public MyException(Throwable cause) {
        super(cause);
    }

}
