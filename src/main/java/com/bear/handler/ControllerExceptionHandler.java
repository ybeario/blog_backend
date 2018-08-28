package com.bear.handler;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ControllerExceptionHandler {
	private final Logger logger = LoggerFactory.getLogger(getClass());

	@ExceptionHandler(Exception.class)
	public ModelAndView exceptionHandler(HttpServletRequest request, Exception exception) throws Exception {
		logger.error("Request URL : {} , Exception : {} ", request.getRequestURL(), exception);
		//判断是否已经明确了异常状态码
		if (AnnotationUtils.findAnnotation(exception.getClass(), ResponseStatus.class) != null) {
			throw exception;
		}
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("url", request.getRequestURL());
		modelAndView.addObject("exception", exception);
		modelAndView.setViewName("error/error");
		return modelAndView;

	}
}
