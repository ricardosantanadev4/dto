package br.com.teste.dto.dto;

import java.util.Objects;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

// exemplo criando um DTO usando uma classe
public class DTOClass {
	@NotNull
	private final Long id;

	@NotNull
	@NotBlank
	@Length(min = 1, max = 100)
	private final String nome;

	@NotNull
	@NotBlank
	@Length(min = 8, max = 9)
	@Pattern(regexp = "Front-End | Back-End")
	private final String categoria;

	@NotNull
	@NotBlank
	@Length(min = 5, max = 7)
	@Pattern(regexp = "Ativo|Inativo")

	public DTOClass(Long id, String nome, String categoria, String status) {
		super();
		this.id = id;
		this.nome = nome;
		this.categoria = categoria;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getCategoria() {
		return categoria;
	}

	@Override
	public int hashCode() {
		return Objects.hash(categoria, id, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DTOClass other = (DTOClass) obj;
		return Objects.equals(categoria, other.categoria) && Objects.equals(id, other.id)
				&& Objects.equals(nome, other.nome);
	}

}