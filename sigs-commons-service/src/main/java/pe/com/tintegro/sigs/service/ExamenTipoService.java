package pe.com.tintegro.sigs.service;

import pe.com.tintegro.sigs.dto.request.ObtieneExamenTiposRequest;
import pe.com.tintegro.sigs.dto.response.ObtieneExamenTiposResponse;

public interface ExamenTipoService 
{
	ObtieneExamenTiposResponse obtenerExamenTipos(ObtieneExamenTiposRequest request) throws Exception;
}
