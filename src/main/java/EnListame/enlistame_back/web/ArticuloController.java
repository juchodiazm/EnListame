package EnListame.enlistame_back.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import EnListame.enlistame_back.dto.ArticuloDTO;
import EnListame.enlistame_back.service.ArticuloService;

@RestController
@RequestMapping("/articulo")
public class ArticuloController {

	@Autowired
	private ArticuloService articuloService;
	
	@RequestMapping(value = "/findAllArticulos" , method = RequestMethod.GET)
	public ResponseEntity <List<ArticuloDTO>> findAllArticulos(){
		List <ArticuloDTO> articulos = articuloService.findAllItems();
		
		return new ResponseEntity<List<ArticuloDTO>>(articulos,HttpStatus.OK);
	}
	@RequestMapping(value = "/findArticuloByCodArticulo" , method = RequestMethod.GET)
	public ResponseEntity <ArticuloDTO> findArticuloByCodArticulo(String codArticulo){
		ArticuloDTO articulo = articuloService.getItemByItemCode(codArticulo);
		if(articulo == null){
			return new ResponseEntity<ArticuloDTO>(HttpStatus.NOT_FOUND);
		}else{
			return new ResponseEntity<ArticuloDTO>(articulo , HttpStatus.OK);
		}
	}
	
	@RequestMapping(value = "/createArticulo/" , method = RequestMethod.POST)
	public ResponseEntity<Void> createArticulo(@RequestBody ArticuloDTO articuloDTO , UriComponentsBuilder uc){
		if(null == articuloService.getItemByItemCode(articuloDTO.getCodArticulo())){
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		ArticuloDTO articuloNew = articuloService.createOrUpdateItem(articuloDTO);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uc.path("/articulo/{codArticulo}").buildAndExpand(articuloNew.getCodArticulo()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.OK);
	}
	
	
}
