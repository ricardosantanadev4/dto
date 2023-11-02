package br.com.teste.dto.service;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import br.com.teste.dto.model.Entidade;
import br.com.teste.dto.repository.Repository;

@org.springframework.stereotype.Service
public class Service {
	private final Repository repository;

	public Service(Repository repository) {
		this.repository = repository;
	}

	public List<Entidade> list() {
		return repository.findAll();
	}

	public Entidade findById(Long id) {
		return repository.findById(id).orElseThrow();
	}

	@PostMapping
	public Entidade create(Entidade record) {
		record.setId(record.getId());
		record.setNome(record.getNome());
		return repository.save(record);
	}

	@PutMapping
	public Entidade update(Entidade record) {
		return repository.findById(record.getId()).map(recordFound -> {
			recordFound.setId(record.getId());
			recordFound.setNome(record.getNome());
			return repository.save(recordFound);
		}).orElseThrow();
	}

	@DeleteMapping
	public void delete(Long id) {
		repository.delete(repository.findById(id).orElseThrow());
	}
}
