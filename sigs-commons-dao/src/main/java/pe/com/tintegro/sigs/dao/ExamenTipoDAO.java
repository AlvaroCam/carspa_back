package pe.com.tintegro.sigs.dao;

import pe.com.tintegro.sigs.dto.request.ObtieneExamenTiposRequest;
import pe.com.tintegro.sigs.dto.response.ObtieneExamenTiposResponse;

public interface ExamenTipoDAO 
{
	ObtieneExamenTiposResponse obtenerExamenTipos(ObtieneExamenTiposRequest request) throws Exception;
}
