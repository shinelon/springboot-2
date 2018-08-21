package com.shinelon.webflux.apache;

import org.apache.commons.lang.RandomStringUtils;

/***
 * 
 * ApacheCode.java
 *
 * @author syq
 *
 */
public class ApacheCode {
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			System.out.println(RandomStringUtils.randomAlphanumeric(8));
		}
	}
}
