package com.app.SpringSecurity.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
class HomeController
{
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "Success";
		
	}
}