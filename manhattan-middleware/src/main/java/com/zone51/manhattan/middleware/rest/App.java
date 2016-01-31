package com.zone51.manhattan.middleware.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("")
public class App {

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody String index() {
		return "Welcome to manhattan Middleware REST";
	}
}
