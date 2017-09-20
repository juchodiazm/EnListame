package EnListame.enlistame_back.service;

import java.util.List;

import org.springframework.stereotype.Service;

import EnListame.enlistame_back.dto.ArticuloDTO;
@Service
public interface ArticuloService {

	
	List <ArticuloDTO> findAllItems();
	
	ArticuloDTO getItemByItemCode(String codigoArticulo);
	
	ArticuloDTO createOrUpdateItem(ArticuloDTO articulo);
	
	void deleteItem(String codigoArticulo);
	
}
