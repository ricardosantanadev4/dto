package br.com.teste.dto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.teste.dto.model.Entidade;

public interface Repository extends JpaRepository<Entidade, Long> {

}
