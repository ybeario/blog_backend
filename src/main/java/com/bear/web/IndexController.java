package com.bear.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.bear.NotFoundException;



@Controller
public class IndexController {
	@GetMapping("/notExist")
	public String notExist() throws NotFoundException {

		if (true) {
			throw new NotFoundException("博客不存在");
		}
		return "index";
	}
	@GetMapping("/byzero")
	public String byZero() {
		int i=1/0;
		return "index";
	}
	@GetMapping("/")
	public String index() {
		return "index";
	}
}
