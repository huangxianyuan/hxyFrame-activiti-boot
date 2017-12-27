package com.hxy.config;

import com.hxy.modules.common.page.PageHelper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
public class MybatisConf {  
        @Bean
        public PageHelper pageHelper() {
           System.out.println("MyBatisConfiguration.pageHelper()");  
            PageHelper pageHelper = new PageHelper();  
            Properties p = new Properties();  
            p.setProperty("offsetAsPageNum", "true");  
            p.setProperty("rowBoundsWithCount", "true");  
            p.setProperty("reasonable", "true");  
            pageHelper.setProperties(p);  
            return pageHelper;  
        }  
}  