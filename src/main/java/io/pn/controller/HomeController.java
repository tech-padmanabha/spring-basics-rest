package io.pn.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class HomeController {
	
	@GetMapping("/info")
	public String startingPoint(HttpServletRequest request) {
		
		String data = String.format(
				"""
				Here are the Details of Client:
				User Agent  : %s
				Client IP : %s
				Client Port : %d
				User : %s
				""",
				request.getHeader("User-Agent"),
				request.getRemoteAddr().toString(),
				request.getRemotePort(),
				request.getRemoteUser()
				);
		
		return data;
	}
}
