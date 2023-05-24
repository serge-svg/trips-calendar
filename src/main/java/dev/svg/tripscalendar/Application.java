package dev.svg.tripscalendar;

import dev.svg.tripscalendar.config.TripsProperties;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties(TripsProperties.class)
@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Trips calendar API", version = "1.0", description = "Trips calendar API Information"))
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
