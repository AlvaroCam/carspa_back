package pe.com.tintegro.sigs.service;

import pe.com.tintegro.sigs.dto.request.ObtieneConfiguracionRequest;
import pe.com.tintegro.sigs.dto.response.ObtieneConfiguracionResponse;

public interface ConfiguracionService
{
	public ObtieneConfiguracionResponse obtenerConfiguracion (ObtieneConfiguracionRequest request) throws Exception;
}
