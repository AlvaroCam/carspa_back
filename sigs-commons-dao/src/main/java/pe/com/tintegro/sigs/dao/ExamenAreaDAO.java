package pe.com.tintegro.sigs.dao;

import pe.com.tintegro.sigs.dto.request.ObtieneExamenAreasRequest;
import pe.com.tintegro.sigs.dto.response.ObtieneExamenAreasResponse;

public interface ExamenAreaDAO 
{
	public ObtieneExamenAreasResponse obtenerExamenAreas(ObtieneExamenAreasRequest request) throws Exception;
}