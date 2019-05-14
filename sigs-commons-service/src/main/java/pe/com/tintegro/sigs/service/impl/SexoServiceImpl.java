/**
 * 
 */
package pe.com.tintegro.sigs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.tintegro.sigs.dao.SexoDAO;
import pe.com.tintegro.sigs.dto.request.ObtieneSexoRequest;
import pe.com.tintegro.sigs.dto.response.ObtieneSexoResponse;
import pe.com.tintegro.sigs.service.SexoService;

/**
 * @author Carlos
 *
 */
@Service("sexoService")
public class SexoServiceImpl implements SexoService
{
	@Autowired
	private SexoDAO sexoDAO;

	@Override
	public ObtieneSexoResponse obtenerSexo(ObtieneSexoRequest request) throws Exception
	{
		// TODO Auto-generated method stub
		return sexoDAO.obtenerSexo(request);
	}

}
