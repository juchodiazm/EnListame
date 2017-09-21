package EnListame.enlistame_back.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import EnListame.enlistame_back.domain.Articulo;

public interface ArticuloRepository extends CrudRepository<Articulo,String>{
 
	List<Articulo> getAllArticulos();
	
	public Articulo getArticuloByCodArticulo(String codArticulo);
	
}
