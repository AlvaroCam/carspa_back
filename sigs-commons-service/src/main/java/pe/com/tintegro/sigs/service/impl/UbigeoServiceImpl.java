/**
 * 
 */
package pe.com.tintegro.sigs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.tintegro.sigs.dao.UbigeoDAO;
import pe.com.tintegro.sigs.dto.request.ObtieneUbigeoRequest;
import pe.com.tintegro.sigs.dto.response.ObtieneUbigeoResponse;
import pe.com.tintegro.sigs.service.UbigeoService;

/**
 * @author Carlos
 *
 */
@Service("ubigeoService")
public class UbigeoServiceImpl implements UbigeoService
{
	@Autowired
	private UbigeoDAO ubigeoDAO;

	@Override
	public ObtieneUbigeoResponse obtenerUbigeo(ObtieneUbigeoRequest request) throws Exception
	{
		// TODO Auto-generated method stub
		return ubigeoDAO.obtenerUbigeo(request);
	}

}
