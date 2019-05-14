package pe.com.tintegro.sigs.service;

import pe.com.tintegro.sigs.dto.request.EliminarAreaRequest;
import pe.com.tintegro.sigs.dto.request.InsertarAreaRequest;
import pe.com.tintegro.sigs.dto.request.ObtenerAreaRequest;
import pe.com.tintegro.sigs.dto.request.ObtieneAreaConsultaAmbulatoriaRequest;
import pe.com.tintegro.sigs.dto.request.ObtieneAreaRequest;
import pe.com.tintegro.sigs.dto.request.ObtieneAreasRequest;
import pe.com.tintegro.sigs.dto.request.ObtieneAreasSinAlmacenRequest;
import pe.com.tintegro.sigs.dto.response.EliminarAreaResponse;
import pe.com.tintegro.sigs.dto.response.InsertarAreaResponse;
import pe.com.tintegro.sigs.dto.response.ObtenerAreaResponse;
import pe.com.tintegro.sigs.dto.response.ObtieneAreaConsultaAmbulatoriaResponse;
import pe.com.tintegro.sigs.dto.response.ObtieneAreaResponse;
import pe.com.tintegro.sigs.dto.response.ObtieneAreasResponse;
import pe.com.tintegro.sigs.dto.response.ObtieneAreasSinAlmacenResponse;

public interface AreaService
{
	public ObtieneAreaResponse obtenerArea(ObtieneAreaRequest request) throws Exception;
	
	public ObtieneAreaConsultaAmbulatoriaResponse obtenerAreasConsultaAmbulatoria(ObtieneAreaConsultaAmbulatoriaRequest request) throws Exception;

	public ObtieneAreasResponse obtenerAreas(ObtieneAreasRequest request) throws Exception;
	
	public ObtieneAreasSinAlmacenResponse obtenerAreasSinAlmacen(ObtieneAreasSinAlmacenRequest request) throws Exception;
	
	public ObtenerAreaResponse obtenerAreas(ObtenerAreaRequest request)throws Exception;
	
	public InsertarAreaResponse insertarArea(InsertarAreaRequest request)throws Exception;
	
	public EliminarAreaResponse eliminarArea (EliminarAreaRequest request)throws Exception;
}
