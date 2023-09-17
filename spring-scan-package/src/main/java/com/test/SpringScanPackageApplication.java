package com.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.util.CousreNames;

@SpringBootApplication(
		scanBasePackages = {"com.*"},
		//scanBasePackageClasses = { CousreNames.class,}
		excludeName = {"test.asjah"}
		//exclude = {Abc.class}
		)
public class SpringScanPackageApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringScanPackageApplication.class, args);
	}

}
