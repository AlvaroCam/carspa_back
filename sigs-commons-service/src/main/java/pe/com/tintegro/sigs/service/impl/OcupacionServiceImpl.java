/**
 * 
 */
package pe.com.tintegro.sigs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.tintegro.sigs.dao.OcupacionDAO;
import pe.com.tintegro.sigs.dto.request.ObtieneOcupacionRequest;
import pe.com.tintegro.sigs.dto.response.ObtieneOcupacionResponse;
import pe.com.tintegro.sigs.service.OcupacionService;

/**
 * @author FReyes
 *
 */
@Service("ocupacionService")
public class OcupacionServiceImpl implements OcupacionService
{
	@Autowired
	private OcupacionDAO ocupacionDAO;
	
	@Override
	public ObtieneOcupacionResponse obtenerOcupacion(ObtieneOcupacionRequest request) throws Exception
	{
		return ocupacionDAO.obtenerOcupacion(request);
	}

	@Override
	public ObtieneOcupacionResponse obtenerOcupacionOfDescripcion(
			ObtieneOcupacionRequest request) throws Exception {
		return ocupacionDAO.obtenerOcupacionOfDescripcion(request);
	}

}
