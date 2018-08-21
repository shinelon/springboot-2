package com.shinelon.cachedemo.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionController {
	
	public static final Logger logger = LoggerFactory.getLogger(ExceptionController.class);
	
	@ResponseBody
	@ExceptionHandler(value = Exception.class)
	public String errorHandler(Exception ex) {
		logger.error(ex.getMessage(),ex);
		return "system error ";
	}
}
