package com.bear.handler;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ControllerExceptionHandler {
	private final Logger logger = LoggerFactory.getLogger(getClass());
	@ExceptionHandler(Exception.class)
	public ModelAndView exceptionHandler(HttpServletRequest request, Exception exception) {
		logger.error("Request URL : {} , Exception : {} ",request.getRequestURL(),exception);
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("url",request.getRequestURL());
		modelAndView.addObject("exception",exception);
		modelAndView.setViewName("error/error");
		return modelAndView;

	}
}
