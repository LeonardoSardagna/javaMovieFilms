package br.com.filmPlatform.filmplatform;

import br.com.filmPlatform.filmplatform.modal.DadosSerie;
import br.com.filmPlatform.filmplatform.service.ConverterDados;
import br.com.filmPlatform.filmplatform.service.RequestAddress;
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
		var address = new RequestAddress();
		var json = address.obterendereco("http://www.omdbapi.com/?t=gilmore girls&apikey=f6239180");
		ConverterDados dados = new ConverterDados();
		var dadosConvertidos = dados.obterDados(json, DadosSerie.class);
		System.out.println(dadosConvertidos);
	}
}
