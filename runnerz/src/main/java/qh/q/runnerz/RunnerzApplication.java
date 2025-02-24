package qh.q.runnerz;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import qh.q.runnerz.Run.Location;
import qh.q.runnerz.Run.Run;
import qh.q.runnerz.Run.RunResporitory;

@SpringBootApplication
public class RunnerzApplication {

	private static final Logger log = LoggerFactory.getLogger(RunnerzApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(RunnerzApplication.class, args);
	}

	// @Bean
	// CommandLineRunner runner(RunResporitory runResporitory) {
	// 	return args -> {
	// 		Run run = new Run(4, "Morning Run", LocalDateTime.now(), LocalDateTime.now().plus(1, ChronoUnit.HOURS), 5, Location.OUTDOOR);
	// 		runResporitory.create(run);
	// 		// log.info("Run: {}", run);
	// 	};
	// }

}
