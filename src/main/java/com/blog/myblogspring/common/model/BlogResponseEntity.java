package com.blog.myblogspring.common.model;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;

public class BlogResponseEntity<T> extends ResponseEntity<BlogRes<T>> {
    public BlogResponseEntity(HttpStatusCode status) {
        super(status);
    }

    public BlogResponseEntity(BlogRes<T> body) {
        super(body, HttpStatus.OK);
    }

    public BlogResponseEntity(BlogRes<T> body, HttpStatusCode status) {
        super(body, status);
    }

    public BlogResponseEntity(MultiValueMap<String, String> headers, HttpStatusCode status) {
        super(headers, status);
    }

    public BlogResponseEntity(BlogRes<T> body, MultiValueMap<String, String> headers, HttpStatusCode status) {
        super(body, headers, status);
    }

    public BlogResponseEntity(BlogRes<T> body, MultiValueMap<String, String> headers, int rawStatus) {
        super(body, headers, rawStatus);
    }
}
