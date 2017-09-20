package EnListame.enlistame_back.mapper.classmap;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import EnListame.enlistame_back.domain.Articulo;
import EnListame.enlistame_back.dto.ArticuloDTO;
@Component
public class ArticuloMapper {

	
	public List<ArticuloDTO> mapToArticuloDTO(List <Articulo> articulos){
		
		List<ArticuloDTO> articulosDTO = new ArrayList<>();
		ArticuloDTO articuloDTO;
		for(Articulo articulo : articulos){
			articuloDTO = mapArticuloToDTO(articulo);
			articulosDTO.add(articuloDTO);
		}
		
		return articulosDTO;
	}
	public ArticuloDTO mapArticuloToDTO(Articulo articulo){
		
		ArticuloDTO articuloSalidaDTO = new ArticuloDTO();
		articuloSalidaDTO.setCodArticulo(articulo.getCodArticulo());
		articuloSalidaDTO.setCantidad(articulo.getCantidad());
		articuloSalidaDTO.setDespensa(articulo.getDespensa());
		articuloSalidaDTO.setFecCaducidadArticulo(articulo.getFecCaducidadArticulo());
		articuloSalidaDTO.setNomArticulo(articulo.getNomArticulo());
		articuloSalidaDTO.setPrecio(articulo.getPrecio());
		articuloSalidaDTO.setSupermercado(articulo.getSupermercado());
		
		return articuloSalidaDTO;
	}
	
	public Articulo mapArticuloToArticulo(Articulo articuloEntrada){
		
		Articulo articuloSalida = new Articulo(articuloEntrada.getCodArticulo(),articuloEntrada.getDespensa(),articuloEntrada.getNomArticulo());
		articuloSalida.setCodArticulo(articuloEntrada.getCodArticulo());
		articuloSalida.setCantidad(articuloEntrada.getCantidad());
		articuloSalida.setDespensa(articuloEntrada.getDespensa());
		articuloSalida.setFecCaducidadArticulo(articuloEntrada.getFecCaducidadArticulo());
		articuloSalida.setNomArticulo(articuloEntrada.getNomArticulo());
		articuloSalida.setPrecio(articuloEntrada.getPrecio());
		articuloSalida.setSupermercado(articuloEntrada.getSupermercado());
		
		return articuloSalida;
	}
}
