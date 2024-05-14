package br.com.filmPlatform.filmplatform;

import br.com.filmPlatform.filmplatform.Principal.Principal;
import br.com.filmPlatform.filmplatform.repository.SerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FilmplatformApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(FilmplatformApplication.class, args);
	}

	@Autowired
	private SerieRepository repository;

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal(repository);
		principal.menuPrincipal();
	}
}
