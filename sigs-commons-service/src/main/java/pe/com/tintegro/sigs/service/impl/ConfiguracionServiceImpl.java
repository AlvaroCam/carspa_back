package pe.com.tintegro.sigs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.tintegro.sigs.constants.ResponseEstado;
import pe.com.tintegro.sigs.dao.ConfiguracionDAO;
import pe.com.tintegro.sigs.dto.request.ObtieneConfiguracionRequest;
import pe.com.tintegro.sigs.dto.response.ObtieneConfiguracionResponse;
import pe.com.tintegro.sigs.service.ConfiguracionService;
import pe.com.tintegro.sigs.util.EncriptacionUtil;

@Service("configuracionService")
public class ConfiguracionServiceImpl implements ConfiguracionService
{
	@Autowired
	private ConfiguracionDAO configuracionDAO;

	@Override
	public ObtieneConfiguracionResponse obtenerConfiguracion(ObtieneConfiguracionRequest request) throws Exception
	{
		request.setIdIPRESS(EncriptacionUtil.desencriptar(request.getIdIPRESS()));
		ObtieneConfiguracionResponse response = new ObtieneConfiguracionResponse();
		response = configuracionDAO.obtenerConfiguracion(request);
		response.setEstado(ResponseEstado.OK);
		response.setMensaje("Configuración obtenida correctamente");
		return response;
	}
	
	
}
