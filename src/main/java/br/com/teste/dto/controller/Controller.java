package br.com.teste.dto.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.teste.dto.dto.DTORecord;
import br.com.teste.dto.service.Service;

@RestController
@RequestMapping("/api/exemplo")
public class Controller {

	private final Service service;

	public Controller(Service service) {
		this.service = service;
	}

	@GetMapping
	public List<DTORecord> list() {
		return service.list();
	}

	@GetMapping("/{id}")
	public DTORecord findById(@PathVariable Long id) {
		return service.findById(id);
	}

	@PostMapping
	public DTORecord create(@RequestBody DTORecord record) {
		return service.create(record);
	}

	@PutMapping("/{id}")
	public DTORecord updadte(@PathVariable Long id, @RequestBody DTORecord record) {
		return service.update(id, record);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}
}