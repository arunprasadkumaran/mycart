/**
 * 
 */
package com.sample.cart.controller;

/**
 * @author arun.prasad
 *
 */
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sample.cart.delegate.LoginDelegate;
import com.sample.cart.viewbean.LoginBean;


@Controller
public class LoginController {
	@Autowired
	private LoginDelegate loginDelegate;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
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
			boolean isValidUser = loginDelegate.isValidUser(loginBean.getUserName(), loginBean.getPassword());
			if (isValidUser) {
				System.out.println("User Login Successful");
				request.setAttribute("loggedInUser", loginBean.getUserName());
				model = new ModelAndView("welcome");
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

	public LoginDelegate getLoginDelegate() {
		return loginDelegate;
	}

	public void setLoginDelegate(LoginDelegate loginDelegate) {
		this.loginDelegate = loginDelegate;
	}
}
