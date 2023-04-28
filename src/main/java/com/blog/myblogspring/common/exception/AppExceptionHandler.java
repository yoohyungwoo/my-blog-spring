package com.blog.myblogspring.common.exception;

import com.blog.myblogspring.common.config.ExceptionConfig;
import com.blog.myblogspring.common.model.BlogRes;
import com.blog.myblogspring.common.model.BlogResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AppExceptionHandler {

    @Autowired
    ExceptionConfig exceptionConfig;

    @ExceptionHandler(BlogException.class)
    public BlogResponseEntity<BlogRes<Void>> GssExceptionHandler(BlogException blogException){
        BlogRes result = exceptionConfig.getExceptionResult(blogException.getYmlKey());
        return new BlogResponseEntity<>(result);
    }
}
