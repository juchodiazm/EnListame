package EnListame.enlistame_back.dto;

import java.io.Serializable;

import lombok.Data;
import EnListame.enlistame_back.domain.Usuario;

@Data
public class DespensaDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private String idDespensa;
	
	private Usuario usuario;

}
