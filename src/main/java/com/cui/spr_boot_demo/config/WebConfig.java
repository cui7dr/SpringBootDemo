package com.cui.spr_boot_demo.config;

import com.cui.spr_boot_demo.filter.LogFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author cui7dr
 * @date 2021/8/12
 */
@Configuration
public class WebConfig {

    @Bean
    public FilterRegistrationBean registrationBean(){
        FilterRegistrationBean filterRegistrationBean=new FilterRegistrationBean();
        LogFilter logFilter=new LogFilter();
        filterRegistrationBean.setFilter(logFilter);
        filterRegistrationBean.addUrlPatterns("/controller/test1","/controller/test3");//配置过滤器规则
        filterRegistrationBean.addInitParameter("name","SpringBoot");//设置 init 参数
        filterRegistrationBean.setName("logFilter");//设置过滤器名称
        filterRegistrationBean.setOrder(2);//执行次数
        return filterRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean(){
        FilterRegistrationBean filterRegistrationBean=new FilterRegistrationBean();
        LogFilter logFilter=new LogFilter();
        filterRegistrationBean.setFilter(logFilter);
        filterRegistrationBean.addUrlPatterns("*");//配置过滤器规则
        filterRegistrationBean.setName("logFilter");//设置过滤器名称
        filterRegistrationBean.setOrder(1);//执行次数
        return filterRegistrationBean;
    }

}
