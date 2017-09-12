package EnListame.enlistame_back.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.Data;


@Entity
@Data
public class Lista implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "COD_LISTA")
	private String codLista;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "NOM_US")
	private Usuario usuario;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "COD_ARTICULO")
	private Articulo articulo;
	
}
