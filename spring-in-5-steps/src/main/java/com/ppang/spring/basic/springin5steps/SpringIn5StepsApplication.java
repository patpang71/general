package com.ppang.spring.basic.springin5steps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringIn5StepsApplication {

	// What are the beans
	// What are the dependency of a bean
	// Where to search for beans => same package no need 
	
	public static void main(String[] args) {
		//SpringApplication.run(SpringIn5StepsApplication.class, args);
		//BinarySearchImpl binarySearch = new BinarySearchImpl(new QuickSortAlgorithm());
		
		// Application Context
		ApplicationContext context = SpringApplication.run(SpringIn5StepsApplication.class, args);
		BinarySearchImpl binarySearch = context.getBean(BinarySearchImpl.class);
		
		int result = binarySearch.binarySearch(new int[] {12,  4, 6}, 3);
		System.out.println(result);
		//omeSearchImpl searchImpl = context.getBean(SomeSearchImpl.class);
		
		//saerchImpl.binarySearch(new int[] {1, 3, 2}, 5);
		
	}
}
