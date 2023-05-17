package dev.svg.contentcalendar;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.*;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Trips calendar API", version = "1.0", description = "Trips calendar API Information"))
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
/*
		String jdbcUrl = "jdbc:postgresql://localhost:5432/tripsDB";

		try (Connection conn = DriverManager.getConnection(jdbcUrl, "postgres", "password")) {

			if (!conn.isValid(0)) {
				System.out.println("Unable to connect!");
				System.exit(0);
			}

			PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM trips");
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				String title = resultSet.getString("description");
				int kilometers = resultSet.getInt("kilometers");
				System.out.printf("%s (%d km)\n", title, kilometers);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
*/
	}

}
