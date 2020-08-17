package com.neuedu.print.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.neuedu.print.bean.ResultBean;


public class LoginInterceptor implements HandlerInterceptor {
	//属性注入
	private List<String> excludeUrls;

	public void setExcludeUrls(List<String> excludeUrls) {
		this.excludeUrls = excludeUrls;
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//先判断不进行拦截的语法:"http://localhost:8080/myoffice/login" --》"/login"
		String url = request.getRequestURI().replaceFirst(request.getContextPath(), "");
		for (String u : excludeUrls) {
			if (url.startsWith(u)) {
				return true;
			}
		}
		
		ResultBean resultBean =(ResultBean) request.getSession().getAttribute("rm");
		//通过判断发现Session中没有存在登录后的信息，简单说，没有登录 ，必须重新登录 
		if (null == resultBean || null == resultBean.getData()) {
			//重定向至登录 页面
			response.sendRedirect(request.getContextPath() + "/login");
		}
		//正常请求流程
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}

}
