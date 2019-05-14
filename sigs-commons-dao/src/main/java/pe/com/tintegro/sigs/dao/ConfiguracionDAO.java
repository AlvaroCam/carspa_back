package pe.com.tintegro.sigs.dao;

import pe.com.tintegro.sigs.dto.request.ObtieneConfiguracionRequest;
import pe.com.tintegro.sigs.dto.response.ObtieneConfiguracionResponse;

public interface ConfiguracionDAO
{
	public ObtieneConfiguracionResponse obtenerConfiguracion(ObtieneConfiguracionRequest request) throws Exception;
}
