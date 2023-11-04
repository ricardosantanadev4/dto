package br.com.teste.dto;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.teste.dto.model.Entidade;
import br.com.teste.dto.repository.Repository;

@SpringBootApplication
public class ProjetoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoApplication.class, args);
	}

	@Bean
	CommandLineRunner initDataBase(Repository repository) {
		return args -> {
			repository.deleteAll();
			Entidade entidade = new Entidade();
			entidade.setNome("Angular");
			entidade.setCategoria("Front-End");
			repository.save(entidade);
		};
	}

}
