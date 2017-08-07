package com.akuan.springboot.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: GlobalExceptionHandler
 * @Description: GlobalExceptionHandler
 * @author: zhaozhenkuan
 * @date: 2017-07-27 下午7:21
 * @version: V1.0
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    private static final String DEFAULT_ERROR_VIEW = "error";

    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultExceptionHandler(HttpServletRequest req, Exception e) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("exception", e);
        modelAndView.addObject("url", req.getRequestURL());
        modelAndView.setViewName(DEFAULT_ERROR_VIEW);
        return modelAndView;
    }

    @ExceptionHandler(value = MyException.class)
    @ResponseBody
    public Map<String, String> myExceptionHandler(HttpServletRequest req, MyException e) throws Exception {
        Map<String, String> map = new HashMap<>();
        map.put("message", e.getMessage());
        map.put("url", req.getRequestURL().toString());
        return map;
    }
}
