package br.com.filmPlatform.filmplatform;

import br.com.filmPlatform.filmplatform.Principal.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FilmplatformApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(FilmplatformApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal();
		principal.menuPrincipal();
	}
}
