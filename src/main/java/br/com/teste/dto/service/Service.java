package br.com.teste.dto.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import br.com.teste.dto.dto.DTORecord;
import br.com.teste.dto.dto.mapper.Mapper;
import br.com.teste.dto.repository.Repository;

@org.springframework.stereotype.Service
public class Service {
	private final Repository repository;
	private final Mapper mapper;

	public Service(Repository repository, Mapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}

	public List<DTORecord> list() {
//		programacao reativa + lambda
//		transforma a lista de entidade em uma lista de dto
		return repository.findAll().stream().map(mapper::toDo).collect(Collectors.toList());
	}

	public DTORecord findById(Long id) {
		return repository.findById(id).map(mapper::toDo).orElseThrow();
	}

	@PostMapping
	public DTORecord create(DTORecord record) {
		/*
		 * transforma a instancia dto em uma entidade para salvar no banco, depois pega
		 * o retorno que e do tipo endidade e transforma em um dto para poder retornar
		 * um dto
		 */
		return mapper.toDo(repository.save(mapper.toEntity(record)));
	}

	@PutMapping
	public DTORecord update(Long id, DTORecord record) {
		return repository.findById(id).map(recordFound -> {
			recordFound.setNome(record.nome());
			recordFound.setCategoria(record.categoria());
			return mapper.toDo(repository.save(recordFound));
		}).orElseThrow();
	}

	@DeleteMapping
	public void delete(Long id) {
		repository.delete(repository.findById(id).orElseThrow());
	}
}