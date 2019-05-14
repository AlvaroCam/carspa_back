package pe.com.tintegro.sigs.service;

import pe.com.tintegro.sigs.dto.request.ObtieneOrigenesRequest;
import pe.com.tintegro.sigs.dto.response.ObtieneOrigenesResponse;

public interface OrigenService 
{
	public ObtieneOrigenesResponse obtenerOrigenes(ObtieneOrigenesRequest request) throws Exception;
}
