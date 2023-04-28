package com.blog.myblogspring.common.config;

import com.blog.myblogspring.common.model.LogInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AppConfig implements WebMvcConfigurer {

    @Bean
    public ExceptionConfig getExceptionInfoConfig() {
        return new ExceptionConfig("/exception/exception.yml");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getLogInterceptor())
                .addPathPatterns("/**");
    }

    LogInterceptor getLogInterceptor(){
        return new LogInterceptor();
    }
}
