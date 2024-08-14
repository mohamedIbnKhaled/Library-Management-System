package com.example.Library.Management.System;
import com.example.Library.Management.System.book.book;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

import org.springframework.boot.SpringApplication;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class LibraryManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryManagementSystemApplication.class, args);
	}


}
