/**
 * 
 */
package com.sample.cart.controller;

import javax.servlet.http.Cookie;
/**
 * @author arun.prasad
 *
 */
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sample.cart.viewbean.LoginBean;

@Controller("logoutController")
@RequestMapping("/logout")
public class LogoutController {

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView logOut(HttpServletRequest request, HttpServletResponse response) {
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("JSESSIONID")) {
					System.out.println("JSESSIONID=" + cookie.getValue());
					break;
				}
			}
		}
		// invalidate the session if exists
		HttpSession session = request.getSession(false);
		System.out.println("User=" + session.getAttribute("UserName"));
		if (session != null) {
			session.removeAttribute("UserName");
			session.invalidate();
		}
		ModelAndView model = new ModelAndView("login");
		LoginBean loginBean = new LoginBean();
		model.addObject("loginBean", loginBean);
		return model;
	}

}
