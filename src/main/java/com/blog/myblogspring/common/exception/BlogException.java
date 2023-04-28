package com.blog.myblogspring.common.exception;

import lombok.Data;

public class BlogException extends RuntimeException{

    private final String ymlKey;

    public BlogException(String ymlKey){
        this.ymlKey = ymlKey;
    }

    public String getYmlKey(){
        return this.ymlKey;
    }
}
