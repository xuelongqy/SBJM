package com.qingyi.SBJM.Interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * Interceptor demo(拦截器Demo)
 *
 * @author qingyi xuelongqy@foxmail.com
 * @Title: InterceptorDemo类
 * @Description: 拦截器Demo
 * @version: V1.0
 * @date 2017 -01-17 20:56:35
 */
public class InterceptorDemo implements HandlerInterceptor {

	/**
	 * 预处理回调方法，实现处理器的预处理（如登录检查），第三个参数为响应的处理器（如我们上一章的Controller实现）；
	 * 返回值：true表示继续流程（如调用下一个拦截器或处理器）；
	 * false表示流程中断（如登录检查失败），不会继续调用其他的拦截器或处理器，此时我们需要通过response来产生响应；
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("preHandler 方法执行,请求之前!");
		return true;
	}

	/**
	 * 后处理回调方法，实现处理器的后处理（但在渲染视图之前），此时我们可以通过modelAndView（模型和视图对象）
	 * 对模型数据进行处理或对视图进行处理，modelAndView也可能为null。
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("postHandler 方法执行,请求之后!");
	}

	/**
	 * 整个请求处理完毕回调方法，即在视图渲染完毕时回调，如性能监控中我们可以在此记录结束时间并输出消耗时间，还可以进行一些资源清理，类似于try-
	 * catch-finally中的finally，但仅调用处理器执行链中preHandle返回true的拦截器的afterCompletion。
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("afterComletion 拦截器走完!");
	}

}
