package dev.svg.contentcalendar;

import dev.svg.contentcalendar.model.Status;
import dev.svg.contentcalendar.model.Trip;
import dev.svg.contentcalendar.model.TripType;
import dev.svg.contentcalendar.repository.TripsSDJdbcRepository;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Trips calendar API", version = "1.0", description = "Trips calendar API Information"))
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(TripsSDJdbcRepository repository) {
		System.out.println("CommandLineRunner------------------------");
		return args -> {
			// insert some data into the database
			Trip trip = new Trip(
					null,
					"Trip from command line runner1",
					Status.IDEA,
					TripType.WORK,
					50,
					50,
					null,
					null);

			repository.save(trip);
		};

	}

}
