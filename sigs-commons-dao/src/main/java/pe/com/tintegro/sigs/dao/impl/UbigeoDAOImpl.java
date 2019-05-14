/**
 * 
 */
package pe.com.tintegro.sigs.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.com.tintegro.sigs.dao.UbigeoDAO;
import pe.com.tintegro.sigs.dto.request.ObtieneUbigeoRequest;
import pe.com.tintegro.sigs.dto.response.ObtieneUbigeoResponse;
import pe.com.tintegro.sigs.entidad.Ubigeo;
import pe.com.tintegro.sigs.mapper.UbigeoMapper;

/**
 * @author Carlos
 *
 */
@Repository("ubigeoDAO")
@Transactional
public class UbigeoDAOImpl implements UbigeoDAO
{

	@Autowired
	private UbigeoMapper ubigeoMapper;

	@Override
	public ObtieneUbigeoResponse obtenerUbigeo(ObtieneUbigeoRequest request) throws Exception
	{
		// TODO Auto-generated method stub
		ObtieneUbigeoResponse response = new ObtieneUbigeoResponse();
		List<Ubigeo> itemList = ubigeoMapper.obtenerUbigeo(request.getCodDepartamento(), request.getCodProvincia());
		 
		if (itemList.size() != 0)
		{
			response.setUbigeoList(itemList);
		}

		return response;
	}

}
