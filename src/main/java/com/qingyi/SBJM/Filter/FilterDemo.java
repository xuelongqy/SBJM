package com.qingyi.SBJM.Filter;

import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.DispatcherType;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义过滤器
 *
 * @author qingyi xuelongqy@foxmail.com
 * @Title: FilterDemo类
 * @Description: 自定义过滤器
 * @version: V1.0
 * @date 2017 -01-16 21:39:02
 */
@WebFilter(dispatcherTypes = {DispatcherType.REQUEST }, urlPatterns = { "/*" }) //过滤器注解,参数:过滤模式、过滤路径
public class FilterDemo extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        System.out.println("这里是过滤器操作!");
        //继续下一个拦截器(如果拦截不需要再执行则去掉)
        filterChain.doFilter(request,response);
    }
}
