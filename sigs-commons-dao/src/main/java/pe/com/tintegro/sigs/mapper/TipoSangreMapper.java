package pe.com.tintegro.sigs.mapper;

import java.util.List;

import pe.com.tintegro.sigs.entidad.general.Item;


public interface TipoSangreMapper {
	
	public List<Item> obtenerTipoSangre() throws Exception; 

}
