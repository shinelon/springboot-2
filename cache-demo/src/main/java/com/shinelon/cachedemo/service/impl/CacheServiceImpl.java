package com.shinelon.cachedemo.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.shinelon.cachedemo.service.CacheService;
/***
 * 
 * CacheServiceImpl.java
 *
 * @author syq
 *
 */
@Service
public class CacheServiceImpl implements CacheService{
	
	public static final Logger logger = LoggerFactory.getLogger(CacheServiceImpl.class);
	
	@Cacheable(value="default",key="#parms")
	public String testCache(String parms) {
		logger.info("parm:{}",parms);
		return "parm:"+parms;
	}
	
}
