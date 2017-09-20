package EnListame.enlistame_back.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import EnListame.enlistame_back.domain.Articulo;
import EnListame.enlistame_back.dto.ArticuloDTO;
import EnListame.enlistame_back.mapper.classmap.ArticuloMapper;
import EnListame.enlistame_back.repository.ArticuloRepository;

@Component("articuloService")
@Transactional
public class ArticuloServiceImpl implements ArticuloService{
	
	
	@Autowired
	ArticuloMapper articuloMapper;

	@Autowired
	ArticuloRepository articuloRepository;
	
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
		Articulo articuloNuevo = articuloMapper.mapArticuloToArticulo(articulo);
		articuloDTO = articuloMapper.mapArticuloToDTO(articuloRepository.save(articuloNuevo));
		return articuloDTO;
	}

	@Override
	public void deleteItem(String codigoArticulo) {
		articuloRepository.delete(codigoArticulo);
		
	}

}
