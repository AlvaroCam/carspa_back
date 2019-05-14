package pe.com.tintegro.sigs.service;

import pe.com.tintegro.sigs.dto.request.ObtieneExamenAreasRequest;
import pe.com.tintegro.sigs.dto.response.ObtieneExamenAreasResponse;

public interface ExamenAreaService 
{
	public ObtieneExamenAreasResponse obtenerExamenAreas(ObtieneExamenAreasRequest request) throws Exception;
}
