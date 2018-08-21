package com.shinelon.cachedemo;

import java.util.concurrent.TimeUnit;

import org.junit.Test;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;

public class CacheDemoApplicationTests {

	@Test
	public void contextLoads() {
		
		Cache<String, Object> manualCache = Caffeine.newBuilder()
		        .expireAfterWrite(10, TimeUnit.MINUTES)
		        .maximumSize(10_000)
		        .build();
		manualCache.put("1", 1);
	}

}
