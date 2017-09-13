package EnListame.enlistame_back.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;
import EnListame.enlistame_back.domain.Despensa;
import EnListame.enlistame_back.domain.Lista;

@Data
public class UsuarioDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String nomUsuario;

	private Despensa despensa;
	
	private Lista lista;
	
	private String passUs;

	private String emailUs;
}
