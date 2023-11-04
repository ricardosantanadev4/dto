package br.com.teste.dto.dto;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

/* exemplo criando um DTO usando a record
   no DTO sao expostas apenas as propriedades necessarias
   id porque e necessario para busca um objeto especifico e atualizar um ojeto especifico e deletar um objeto especifico
   nome e categoria: necessario para para criar um objeto ou atulizar
   o status nao e necessario por que ele criado pelo sistema e vai mudar automaticamente de acordo com a acao feita na api
   as anotacoes de persistencia no banco de dados nao adicionadas
   sao adicionadas apenas a validadcoes */

public record DTORecord(@NotNull Long id,

		@NotNull @NotBlank @Length(min = 1, max = 100) String nome,

		@NotNull @NotBlank @Length(min = 8, max = 9) @Pattern(regexp = "Front-End|Back-End") String categoria) {

}