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

import br.com.teste.dto.model.Entidade;
import br.com.teste.dto.service.Service;

@RestController
@RequestMapping("/api/exemplo")
public class Controller {

	private final Service service;

	public Controller(Service service) {
		this.service = service;
	}

	@GetMapping
	public List<Entidade> list() {
		return service.list();
	}

	@GetMapping("/{id}")
	public Entidade findById(@PathVariable Long id) {
		System.out.println("findById()");
		return service.findById(id);
	}

	@PostMapping
	public Entidade create(@RequestBody Entidade record) {
		System.out.println("create()");
		return service.create(record);
	}

	@PutMapping("/{id}")
	public Entidade updadte(@RequestBody Entidade record) {
		System.out.println("update()");
		return service.update(record);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}
}