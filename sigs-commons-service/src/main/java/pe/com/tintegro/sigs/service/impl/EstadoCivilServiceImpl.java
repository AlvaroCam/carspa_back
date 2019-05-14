/**
 * 
 */
package pe.com.tintegro.sigs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.tintegro.sigs.dao.EstadoCivilDAO;
import pe.com.tintegro.sigs.dto.request.ObtieneEstadoCivilRequest;
import pe.com.tintegro.sigs.dto.response.ObtieneEstadoCivilResponse;
import pe.com.tintegro.sigs.service.EstadoCivilService;

/**
 * @author Carlos
 *
 */
@Service("estadoCivilService")
public class EstadoCivilServiceImpl implements EstadoCivilService
{
	@Autowired
	private EstadoCivilDAO estadoCivilDAO;

	@Override
	public ObtieneEstadoCivilResponse obtenerEstadoCivil(ObtieneEstadoCivilRequest request) throws Exception
	{
		// TODO Auto-generated method stub
		return estadoCivilDAO.obtenerEstadoCivil(request);
	}

}
