package net.talaatharb.patientmanagementsystem.controllers;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping(path = { "/login", "/index", "/web/**"}, produces = MediaType.TEXT_HTML_VALUE)
	public String home() {
		return "forward:/index.html";
	}

}
