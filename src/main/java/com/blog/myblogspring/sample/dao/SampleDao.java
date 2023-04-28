package com.blog.myblogspring.sample.dao;


import com.blog.myblogspring.sample.model.SampleReq;
import com.blog.myblogspring.sample.model.SampleRes;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SampleDao {

    SampleRes retrieveSample(SampleReq sampleReq);

}
