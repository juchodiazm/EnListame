package EnListame.enlistame_back.service;

import java.util.List;

import ma.glasnost.orika.MapperFacade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import EnListame.enlistame_back.domain.Articulo;
import EnListame.enlistame_back.dto.ArticuloDTO;
import EnListame.enlistame_back.repository.ArticuloRepository;

@Component("articuloService")
@Transactional
public class ArticuloServiceImpl implements ArticuloService{
	
	
	@Autowired
	private MapperFacade articuloMapper;

	@Autowired
	private ArticuloRepository articuloRepository;
	
	@Override
	public List<ArticuloDTO> findAllItems() {
		
		List <Articulo> articulos = articuloRepository.getAllArticulos();
		
		Page<ArticuloDTO> paginaArticulos = mapEntityPageIntoDTOPage(articulos);
		
		return paginaArticulos.getContent();
	}

	@Override
	public ArticuloDTO getItemByItemCode(String codigoArticulo) {
		
		Articulo articulo = articuloRepository.getArticuloByCodArticulo(codigoArticulo);
		
		return articuloMapper.map(articulo, ArticuloDTO.class);
	}

	@Override
	public ArticuloDTO createOrUpdateItem(ArticuloDTO articuloDTO) {
		Articulo articuloNuevo = articuloMapper.map(articuloDTO , Articulo.class);
		return articuloMapper.map(articuloRepository.save(articuloNuevo), ArticuloDTO.class);
	}

	@Override
	public void deleteItem(String codigoArticulo) {
		articuloRepository.delete(codigoArticulo);
		
	}

	private Page<ArticuloDTO> mapEntityPageIntoDTOPage(List<Articulo> articuloEntityPage) {
		Page<Articulo> paginaArticulo = new PageImpl<>(articuloEntityPage);
        return paginaArticulo.map(new Converter<Articulo, ArticuloDTO>() {
            public ArticuloDTO convert(Articulo articuloEntity) {
                return articuloMapper.map(articuloEntity, ArticuloDTO.class);
            	
            }
        });
    }
	
}
