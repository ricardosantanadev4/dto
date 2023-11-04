package br.com.teste.dto.dto.mapper;

import org.springframework.stereotype.Component;

import br.com.teste.dto.dto.DTORecord;
import br.com.teste.dto.model.Entidade;

/* @Component faz com que o Spring crie instancias dessa classe permitindo instaciar essa classe em outras classes
    caso a anotacao nao seja adiciona vaia apresentar erro */
@Component
public class Mapper {
// necessario quando muda o retorno dos metodos do controller para DTO
	public DTORecord toDo(Entidade entidade) {
		if (entidade == null) {
			return null;
		}

		return new DTORecord(entidade.getId(), entidade.getNome(), entidade.getCategoria());
	}

//	necessario quando muda o body dos metodos para DTO
	public Entidade toEntity(DTORecord dto) {
		if (dto == null) {
			return null;
		}

		Entidade entidade = new Entidade();
//		em alguns momentos o id pode ser passado o nao por isso essa verificao
		if (dto.id() != null) {
			entidade.setId(dto.id());
		}

		entidade.setNome(dto.nome());
		entidade.setCategoria((dto.categoria()));
		return entidade;
	}
}
