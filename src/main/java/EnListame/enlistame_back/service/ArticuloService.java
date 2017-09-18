package EnListame.enlistame_back.service;

import java.util.List;

import EnListame.enlistame_back.dto.ArticuloDTO;

public interface ArticuloService {

	
	List <ArticuloDTO> findAllItems();
	
	ArticuloDTO getItemByItemCode(String codigoArticulo);
	
	ArticuloDTO createOrUpdateItem(ArticuloDTO articulo);
	
	void deleteItem(ArticuloDTO articulo);
	
}
