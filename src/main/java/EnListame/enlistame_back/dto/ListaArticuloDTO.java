package EnListame.enlistame_back.dto;

import java.io.Serializable;

import lombok.Data;
import EnListame.enlistame_back.domain.Articulo;
import EnListame.enlistame_back.domain.Lista;

@Data
public class ListaArticuloDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private String idListaArticulo;

	private Lista lista;

	private Articulo articulo;
}
