package EnListame.enlistame_back.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import EnListame.enlistame_back.domain.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, String>{
	
	List<Usuario> getAllUsuario();
	
	public Usuario getUsuarioByName(String nomUsuario);

}
