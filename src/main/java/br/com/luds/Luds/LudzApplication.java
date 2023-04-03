package br.com.luds.Luds;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class LudzApplication {

	public static void main(String[] args) {
		SpringApplication.run(LudzApplication.class, args);
	}

}
