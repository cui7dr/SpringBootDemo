package com.cui.spr_boot_demo.filter;

import org.springframework.boot.web.servlet.ServletComponentScan;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.Enumeration;

/**
 * @author cui7dr
 * @date 2021/8/12
 */
@WebFilter(urlPatterns = "/*",filterName = "LogFilter")//Servlet3.0 规范
public class LogFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("logFilter.init is called");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("filter 打印的请求参数");
        Enumeration<String> parameterNames=request.getParameterNames();
        while (parameterNames.hasMoreElements()){
            String key=parameterNames.nextElement();
            String value=request.getParameter(key);
            System.out.println(key+"==>"+value);
        }
        long bgn=System.currentTimeMillis();
        //一定要调用链式调用传递，否则也进不了 controller
        chain.doFilter(request,response);
        long end=System.currentTimeMillis();
        System.out.println("filter 中记录耗时："+(end-bgn)+"ms");
    }

    @Override
    public void destroy() {
        System.out.println("logFilter.destroy is called");
    }
}
