package com.shinelon.cachedemo.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shinelon.cachedemo.service.CacheService;

@Controller
public class IndexController {

	private static final Logger logger = LoggerFactory.getLogger(IndexController.class);
	@Autowired
	private CacheService cacheService;

	@RequestMapping("/")
	@ResponseBody
	public String index() {
		logger.info("cache demo is startup !");
		return "cache demo is startup ! ";
	}

	@RequestMapping("/exception")
	@ResponseBody
	public String exception() throws Exception {
		logger.info("exception");
		throw new Exception("test exception");
	}

	@RequestMapping("/test")
	@ResponseBody
	public String testCache() throws InterruptedException {
		cacheService.testCache("1");
		cacheService.testCache("1");
		cacheService.testCache("2");
		cacheService.testCache("2");
		cacheService.testCache("3");
		cacheService.testCache("3");
		logger.info("sleepfor 5s");
		Thread.sleep(5*1000);
		cacheService.testCache("1");
		cacheService.testCache("1");
		cacheService.testCache("2");
		cacheService.testCache("2");
		cacheService.testCache("3");
		cacheService.testCache("3");
		logger.info("sleepfor 6s");
		Thread.sleep(6*1000);
		cacheService.testCache("1");
		cacheService.testCache("1");
		cacheService.testCache("2");
		cacheService.testCache("2");
		cacheService.testCache("3");
		cacheService.testCache("3");
		return "done";

	}

}
