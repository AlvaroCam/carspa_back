package pe.com.tintegro.sigs.dao;

import pe.com.tintegro.sigs.dto.request.ObtieneOrigenesRequest;
import pe.com.tintegro.sigs.dto.response.ObtieneOrigenesResponse;

public interface OrigenDAO 
{
	public ObtieneOrigenesResponse obtenerOrigen(ObtieneOrigenesRequest request) throws Exception;
}
