package com.cui.spr_boot_demo.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;
import java.util.Map;

/**
 * @author cui7dr
 * @date 2021/8/10
 */
@Component
public class LogInterceptor implements HandlerInterceptor {
    //在请求 rest 接口之前调用
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("请求 url: " + request.getRequestURL());
        Map<String, String[]> parameterMap = request.getParameterMap();
        Enumeration<String> parameterNames = request.getParameterNames();

        System.out.println("请求参数: ");
        while (parameterNames.hasMoreElements()) {
            String name = (String) parameterNames.nextElement();
            String value = request.getParameter(name);
            System.out.println(name + "==>" + value);
        }

        //假设参数 a 传递的如果是 1 的话，是不合法的请求，不继续往下执行
        if ("1".equals(request.getParameter("a"))) {
            return false;
        }
        return true;//如果返回 false 则不会继续往下执行，不会真正的进入到 controller
    }

    //请求处理之后进行调用，但是在视图被渲染之前（Controller 方法调用之后
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle is called...");
    }

    //在整个请求结束之后被调用
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception e) throws Exception {
        System.out.println("afterCompletion is called...");
    }
}
