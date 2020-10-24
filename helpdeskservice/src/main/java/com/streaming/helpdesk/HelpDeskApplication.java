package com.streaming.helpdesk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class HelpDeskApplication {
	
	public static void main(String[] args)
	{
		SpringApplication.run(HelpDeskApplication.class, args);


	}
	

}
