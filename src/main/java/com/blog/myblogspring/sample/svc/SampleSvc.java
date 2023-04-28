package com.blog.myblogspring.sample.svc;

import com.blog.myblogspring.common.exception.BlogException;
import com.blog.myblogspring.sample.dao.SampleDao;
import com.blog.myblogspring.sample.model.SampleReq;
import com.blog.myblogspring.sample.model.SampleRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SampleSvc {

    @Autowired
    private SampleDao sampleDao;

    public SampleRes retrieveSample(SampleReq sampleReq){
        if("testException".equals(sampleReq.getUserId())){
            throw new BlogException("testException");
        }
        return sampleDao.retrieveSample(sampleReq);
    }
}
