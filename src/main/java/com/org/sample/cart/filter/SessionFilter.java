package com.org.sample.cart.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionFilter implements Filter {

	private ArrayList<String> urlList;

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;

		String url = request.getServletPath();
		System.out.println(url);
		if (!("/").equals(url)) {
			boolean allowedRequest = false;

			if (urlList.contains(url)) {
				allowedRequest = true;
			}
			if (!allowedRequest) {
				HttpSession session = request.getSession(false);
				if (null == session || null == session.getAttribute("UserName")) {
					response.sendRedirect("/login");
				}
			}
		}
		chain.doFilter(req, res);
	}

	public void init(FilterConfig config) throws ServletException {
		String urls = config.getInitParameter("avoid-urls");
		StringTokenizer token = new StringTokenizer(urls, ",");
		urlList = new ArrayList<String>();
		while (token.hasMoreTokens()) {
			urlList.add(token.nextToken());
		}
	}
}