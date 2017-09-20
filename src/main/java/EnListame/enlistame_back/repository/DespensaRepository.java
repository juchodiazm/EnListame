package EnListame.enlistame_back.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import EnListame.enlistame_back.domain.Despensa;
@Repository
public interface DespensaRepository extends CrudRepository<Despensa,String>{

	List<Despensa> getAllDespensa();
	
	public Despensa getDespensaByIdDespensa(String idDespensa);
	
}
