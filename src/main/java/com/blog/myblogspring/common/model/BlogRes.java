package com.blog.myblogspring.common.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.http.HttpHeaders;

@Data
public class BlogRes<T> {

    private T body;

    private String code = "200";

    private String status = "200";

    private String msg = "성공하였습니다.";

    public BlogRes(T body) {
        this.setBody(body);
    }

    public BlogRes(){};

}
