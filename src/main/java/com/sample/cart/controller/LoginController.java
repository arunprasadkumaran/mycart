/**
 * 
 */
package com.sample.cart.controller;

import java.util.concurrent.atomic.AtomicLong;

import javax.servlet.http.Cookie;
/**
 * @author arun.prasad
 *
 */
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sample.cart.service.UserService;
import com.sample.cart.viewbean.LoginBean;

@Controller("loginController")
public class LoginController {
	@Autowired
	private UserService userService;

	private final AtomicLong counter = new AtomicLong();

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView displayLogin(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView model = new ModelAndView("login");
		LoginBean loginBean = new LoginBean();
		model.addObject("loginBean", loginBean);
		return model;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView executeLogin(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("loginBean") LoginBean loginBean) {
		ModelAndView model = null;
		try {
			boolean isValidUser = userService.isValidUser(loginBean.getUserName(), loginBean.getPassword());
			if (isValidUser) {
				System.out.println(counter.incrementAndGet() + "::User Login Successful");
				request.setAttribute("loggedInUser", loginBean.getUserName());
				model = new ModelAndView("welcome");
				HttpSession session = request.getSession();
				session.setAttribute("UserName", loginBean.getUserName());
				session.setMaxInactiveInterval(60);
				// Cookie userName = new Cookie("UserName",
				// loginBean.getUserName());
				Cookie sessionId = new Cookie("JSESSIONID", session.getId());
				sessionId.setMaxAge(60);
				// response.addCookie(userName);
				response.addCookie(sessionId);

			} else {
				model = new ModelAndView("login");
				model.addObject("loginBean", loginBean);
				request.setAttribute("message", "Invalid credentials!!");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return model;
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
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
			session.invalidate();
		}
		ModelAndView model = new ModelAndView("login");
		LoginBean loginBean = new LoginBean();
		model.addObject("loginBean", loginBean);
		return model;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
