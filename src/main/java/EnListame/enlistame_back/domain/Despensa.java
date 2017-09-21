package EnListame.enlistame_back.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.Data;


@Entity
@Data
public class Despensa implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "ID_DESPEN")
	private String idDespensa;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "NOM_US")
	private List<Usuario> usuario;

}
