package sopt.org.fourthSixSeminar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@EnableJpaAuditing
@SpringBootApplication
public class FourthSeminarApplication {

	public static void main(String[] args) {
		SpringApplication.run(FourthSeminarApplication.class, args);
	}

}
