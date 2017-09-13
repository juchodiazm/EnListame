package EnListame.enlistame_back.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import EnListame.enlistame_back.domain.Despensa;

@Data
public class ArticuloDTO implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
    private String codArticulo;

	private Despensa despensa;
	
	private String nomArticulo;

	private String supermercado;

	private String precio;

	private Date fecCaducidadArticulo;

	private String cantidad;

}
