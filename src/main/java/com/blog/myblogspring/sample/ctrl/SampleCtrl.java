package com.blog.myblogspring.sample.ctrl;

import com.blog.myblogspring.common.model.BlogRes;
import com.blog.myblogspring.common.model.BlogResponseEntity;
import com.blog.myblogspring.sample.model.SampleReq;
import com.blog.myblogspring.sample.model.SampleRes;
import com.blog.myblogspring.sample.svc.SampleSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sample")
public class SampleCtrl {

    @Autowired
    private SampleSvc sampleSvc;

    @GetMapping
    public BlogResponseEntity<SampleRes> retrieveSample(SampleReq sampleReq){
        SampleRes result = sampleSvc.retrieveSample(sampleReq);
        return new BlogResponseEntity<>(new BlogRes<>(result),HttpStatus.OK);
    }
}
