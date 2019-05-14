/**
 * 
 */
package pe.com.tintegro.sigs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.tintegro.sigs.dao.GradoInstruccionDAO;
import pe.com.tintegro.sigs.dto.request.ObtieneGradoInstruccionRequest;
import pe.com.tintegro.sigs.dto.response.ObtieneGradoInstruccionResponse;
import pe.com.tintegro.sigs.service.GradoInstruccionService;

/**
 * @author FReyes
 *
 */
@Service("gradoInstruccionService")
public class GradoInstruccionServiceImpl implements GradoInstruccionService
{
	@Autowired
	private GradoInstruccionDAO gradoInstruccionDAO;
	
	@Override
	public ObtieneGradoInstruccionResponse obtenerGradoInstruccion(ObtieneGradoInstruccionRequest request) throws Exception
	{
		return gradoInstruccionDAO.obtenerGradoInstruccion(request);
	}
}
