package EnListame.enlistame_back.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Usuario implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "NOM_US" , unique = true, nullable = false)
	private String nomUsuario;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_DESPEN")
	private Despensa despensa;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "COD_LISTA")
	private Lista lista;
	
	@Column(name = "PASS_US" , unique = true, nullable = false)
	private String passUs;
	
	@Column(name = "EMAIL_US")
	private String emailUs;
	
	public Usuario(){}
	
	public Usuario(String nomUsuario,String passUs){
		
		this.nomUsuario = nomUsuario;
		this.passUs = passUs;		
	}
}
