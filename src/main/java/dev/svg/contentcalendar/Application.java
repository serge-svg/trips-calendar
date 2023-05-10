package dev.svg.contentcalendar;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Content API", version = "1.0", description = "Content API Information"))
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		/*
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		Object restTemplate = context.getBean("restTemplate");
		System.out.println(restTemplate);
		*/
	}

}
