package de.db.betriebsstellen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
public class BetriebsstellenApplication {

	@RequestMapping("/")
	public String greet() {
		return "welcome!";
	}

	public static void main(String[] args) {
		SpringApplication.run(BetriebsstellenApplication.class, args);
	}

}
