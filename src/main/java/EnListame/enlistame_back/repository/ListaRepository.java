package EnListame.enlistame_back.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import EnListame.enlistame_back.domain.Lista;

public interface ListaRepository extends CrudRepository<Lista, String>{

	
	List<Lista> getAllLista();
	
	Lista getListaByCodLista();
	
}
