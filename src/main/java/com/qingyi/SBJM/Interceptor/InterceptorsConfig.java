package com.qingyi.SBJM.Interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * <p>拦截器配置类</p>
 *
 * @author qingyi xuelongqy@foxmail.com
 * @version V1.0
 * @ClassName: InterceptorsConfig
 * @Package com.qingyi.SBJM.Interceptor
 * @Description: 拦截器配置类
 * @date 2017/1/17 13:48
 */
@Configuration
public class InterceptorsConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 多个拦截器组成一个拦截器链
        // addPathPatterns 用于添加拦截规则
        // excludePathPatterns 用户排除拦截
        registry.addInterceptor(new InterceptorDemo()).addPathPatterns("/**");
        super.addInterceptors(registry);
    }
}
