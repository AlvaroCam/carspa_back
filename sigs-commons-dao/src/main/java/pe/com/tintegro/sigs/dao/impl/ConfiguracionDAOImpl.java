package pe.com.tintegro.sigs.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.com.tintegro.sigs.dao.ConfiguracionDAO;
import pe.com.tintegro.sigs.dto.request.ObtieneConfiguracionRequest;
import pe.com.tintegro.sigs.dto.response.ObtieneConfiguracionResponse;
import pe.com.tintegro.sigs.entidad.Configuracion;
import pe.com.tintegro.sigs.mapper.ConfiguracionMapper;

@Transactional
@Repository("configuracionDAO")
public class ConfiguracionDAOImpl implements ConfiguracionDAO
{
	@Autowired
	private ConfiguracionMapper configuracionMapper;

	@Override
	public ObtieneConfiguracionResponse obtenerConfiguracion(ObtieneConfiguracionRequest request) throws Exception
	{
		ObtieneConfiguracionResponse response = new ObtieneConfiguracionResponse();
		Configuracion configuracion = configuracionMapper.obtenerConfiguracion(request.getIdConfiguracion());  
		response.setConfiguracion(configuracion);
		return response;
	}
	
}
