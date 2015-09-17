package com.indusmed.controllers;

import javax.servlet.http.HttpSession;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.indusmed.base.Constants;

@Controller
public class DashboardViewController {
	@Autowired
	private HttpSession session;

	private static final Logger LOGGER = Logger.getLogger(DashboardViewController.class);

	@RequestMapping("/temp")
	public String getName() {
		LOGGER.debug("n get Name");
		return Constants.TEMP_PAGE;
	}

	@RequestMapping("/newUser")
	public String newUser() {
		if (session.getAttribute(Constants.DASHBOARD_USER) != null) {
			return Constants.ADD_NEW_USER;
		} else {
			return Constants.USER_LOGIN;
		}
	}	

	@RequestMapping({"/","/dashboard"})
	public String getPage() {
		if (session.getAttribute(Constants.DASHBOARD_USER) != null) {
			return Constants.DASHBOARD_USER;
		} else {
			return Constants.USER_LOGIN;
		}
	}
}
