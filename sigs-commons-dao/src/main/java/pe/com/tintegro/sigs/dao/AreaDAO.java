/**
 * 
 */
package pe.com.tintegro.sigs.dao;

import java.util.List;

import pe.com.tintegro.sigs.dto.request.EliminarAreaRequest;
import pe.com.tintegro.sigs.dto.request.InsertarAreaRequest;
import pe.com.tintegro.sigs.dto.request.ObtenerAreaRequest;
import pe.com.tintegro.sigs.dto.request.ObtieneAreasSinAlmacenRequest;
import pe.com.tintegro.sigs.dto.response.EliminarAreaResponse;
import pe.com.tintegro.sigs.dto.response.InsertarAreaResponse;
import pe.com.tintegro.sigs.dto.response.ObtenerAreaResponse;
import pe.com.tintegro.sigs.dto.response.ObtieneAreasSinAlmacenResponse;
import pe.com.tintegro.sigs.entidad.general.Item;

public interface AreaDAO
{
	public List<Item> obtenerAreas( String idIPRESS, Integer idArea, String codUsuario ) throws Exception;
	
	public List<Item> obtenerAreasConsultaAmbulatoria( String idIPRESS, Integer idArea, String codUsuario ) throws Exception;
	
	public ObtieneAreasSinAlmacenResponse obtenerAreasSinAlmacen(ObtieneAreasSinAlmacenRequest request) throws Exception;
	
	public ObtenerAreaResponse obtenerAreas(ObtenerAreaRequest request) throws Exception;
	
	public InsertarAreaResponse insertarArea( InsertarAreaRequest request) throws Exception;
	
	public EliminarAreaResponse eliminarArea (EliminarAreaRequest request) throws Exception;
}
