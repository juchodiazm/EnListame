package EnListame.enlistame_back.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;


@Entity
@Data
public class Articulo implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "COD_ARTICULO")
    private String codArticulo;
	
	@OneToOne
	@JoinColumn(name = "ID_DESPEN")
	private Despensa despensa;
	
	@Column(name = "NOM_ARTICULO", unique = true , nullable = false)
	private String nomArticulo;
	
	@Column(name = "SUPERMERCADO")
	private String supermercado;
	
	@Column(name = "PRECIO")
	private String precio;
	
	@Column(name = "FEC_CAD_ART")
	private Date fecCaducidadArticulo;
	
	@Column(name = "CANTIDAD")
	private String cantidad;
	
	
}
