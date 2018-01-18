package chow.ChowAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ChowApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(ChowApiApplication.class, args);
	}
}
