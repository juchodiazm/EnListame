package EnListame.enlistame_back.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

import lombok.Data;


@Entity
@Data
public class ListaArticulo implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_LISTA_ARTICULO" , nullable = false , unique = true)
	private String idListaArticulo;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "COD_LISTA")
	private List<Lista> lista;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "COD_ARTICULO")
	private List<Articulo> articulo;
}
