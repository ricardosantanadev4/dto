package br.com.teste.dto.model;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Entity
@Data
public class Entidade {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NotNull
	@Column(nullable = false)
	private Long id;

	@NotNull
	@NotBlank
	@Column(nullable = false)
	@Length(min = 1, max = 100)
	private String nome;

	@NotNull
	@NotBlank
	@Column(nullable = false)
	@Length(min = 8, max = 9)
	@Pattern(regexp = "Front-End|Back-End")
	private String categoria;

	@NotNull
	@NotBlank
	@Column(nullable = false)
	@Length(min = 5, max = 7)
	@Pattern(regexp = "Ativo|Inativo")
	private String Status = "Ativo";

}