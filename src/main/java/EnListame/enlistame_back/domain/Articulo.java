package EnListame.enlistame_back.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;


@Entity
@Data
@Table(name = "ARTICULO")
public class Articulo implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "COD_ARTICULO")
    private String codArticulo;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "",
	joinColumns = @JoinColumn(name = "ID_DESPEN"),
	inverseJoinColumns = @JoinColumn(name = "COD_ARTICULO")
	)
	private Set<Despensa> despensa;
	
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
	
	protected Articulo (){}
	
	public Articulo(String codArticulo, String nomArticulo){
		this.codArticulo = codArticulo;
		this.nomArticulo = nomArticulo;
	}
	
}
