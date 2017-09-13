package EnListame.enlistame_back.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

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
