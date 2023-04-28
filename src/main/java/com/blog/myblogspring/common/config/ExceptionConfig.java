package com.blog.myblogspring.common.config;

import com.blog.myblogspring.common.model.BlogRes;
import org.springframework.beans.factory.config.YamlMapFactoryBean;
import org.springframework.core.io.ClassPathResource;

import java.util.Map;

public class ExceptionConfig {

    private final Map<String, Object> exceptionsInfos;

    public ExceptionConfig(String filePath) {
        YamlMapFactoryBean yaml = new YamlMapFactoryBean();
        yaml.setResources(new ClassPathResource(filePath));
        this.exceptionsInfos = yaml.getObject();
    }

    public BlogRes getExceptionResult (String ymlKey){
        Map<String, Object> exceptionInfo = (Map<String, Object>) exceptionsInfos.get(ymlKey);
        if(exceptionInfo == null) {
            exceptionInfo = (Map<String, Object>) exceptionsInfos.get("undefined");
        }
        BlogRes result = new BlogRes<>();
        result.setMsg(String.valueOf(exceptionInfo.get("msg")));
        result.setCode(String.valueOf(exceptionInfo.get("code")));
        result.setStatus(String.valueOf(exceptionInfo.get("status")));
        return result;
    }



}
