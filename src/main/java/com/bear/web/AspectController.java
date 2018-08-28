package com.bear.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
* @author Y.bear
* @version 创建时间：2018年8月28日 上午11:02:57
* 类说明
*/
@Controller
@RequestMapping("/aspect")
public class AspectController {
	@GetMapping("/{id}/{name}")
	public String aspectLog(@PathVariable int id,@PathVariable String name) {
		System.out.println("------content------"+id+"-----"+name);
		return "index";
	}
}
