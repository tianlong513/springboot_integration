package com.tl.config;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.MultipartConfigElement;

/**
 * @program: tl
 * @description: applicationConfig配置
 * @author: tianlong
 * @create: 2018-12-18 16:51
 **/
@Configuration
public class ApplicationConfig {

    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        //最大文件
        factory.setMaxFileSize("10240KB");
        //设置总上传数据大小
        factory.setMaxRequestSize("102400KB");
        return factory.createMultipartConfig();
    }
}
