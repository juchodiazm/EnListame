package EnListame.enlistame_back.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import EnListame.enlistame_back.domain.Articulo;
import EnListame.enlistame_back.dto.ArticuloDTO;
import EnListame.enlistame_back.mapper.classmap.ArticuloMapper;
import EnListame.enlistame_back.repository.ArticuloRepository;

public class ArticuloServiceImpl implements ArticuloService{
	
	@Autowired
	ArticuloRepository articuloRepository;
	
	@Autowired
	ArticuloMapper articuloMapper;

	@Override
	public List<ArticuloDTO> findAllItems() {
		
		List <Articulo> articulos = articuloRepository.getAllArticulos();
		List <ArticuloDTO> articulosDTO = articuloMapper.mapToArticuloDTO(articulos);
		
		return articulosDTO;
	}

	@Override
	public ArticuloDTO getItemByItemCode(String codigoArticulo) {
		
		Articulo articulo = articuloRepository.getArticuloByCodArticulo(codigoArticulo);
		ArticuloDTO articuloDTO = articuloMapper.mapArticuloToDTO(articulo);
		
		return articuloDTO;
	}

	@Override
	public ArticuloDTO createOrUpdateItem(ArticuloDTO articuloDTO) {
		Articulo articulo = articuloRepository.getArticuloByCodArticulo(articuloDTO.getCodArticulo());
		Articulo articuloNuevo;
		if(null != articulo){
			articuloNuevo = articuloMapper.mapArticuloToArticulo(articulo);
		}
		articuloNuevo = articuloRepository.save(null);
		ArticuloDTO articuloDTO = 
		
		return null;
	}

	@Override
	public void deleteItem(ArticuloDTO articulo) {
		// TODO Auto-generated method stub
		
	}

}
