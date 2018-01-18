package com.hxy.modules.common.xss;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 类XssFilter的功能描述:
 * XSS过滤
 * @auther hxy
 * @date 2017-08-25 16:20:08
 */
public class XssFilter implements Filter {
	/**
	 * 封装，不需要过滤的list列表
	 */
	protected static List<Pattern> patterns = new ArrayList<Pattern>();

	@Override
	public void init(FilterConfig config) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		String url = httpRequest.getRequestURI().substring(httpRequest.getContextPath().length());
		if (url.startsWith("/") && url.length() > 1) {
			url = url.substring(1);
		}
		if (isInclude(url)){
			chain.doFilter(httpRequest, httpResponse);
			return;
		} else {
			XssHttpServletRequestWrapper xssRequest = new XssHttpServletRequestWrapper(
					(HttpServletRequest) request);
			chain.doFilter(xssRequest, response);
		}
	}

	@Override
	public void destroy() {
	}

	/**
	 * 是否需要过滤
	 * @param url
	 * @return
	 */
	private boolean isInclude(String url) {
		for (Pattern pattern : patterns) {
			Matcher matcher = pattern.matcher(url);
			if (matcher.matches()) {
				return true;
			}
		}
		return false;
	}

}