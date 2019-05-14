/**
 * 
 */
package pe.com.tintegro.sigs.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.com.tintegro.sigs.dao.EstadoCivilDAO;
import pe.com.tintegro.sigs.dto.request.ObtieneEstadoCivilRequest;
import pe.com.tintegro.sigs.dto.response.ObtieneEstadoCivilResponse;
import pe.com.tintegro.sigs.entidad.general.Item;
import pe.com.tintegro.sigs.mapper.EstadoCivilMapper;

/**
 * @author Carlos
 *
 */
@Repository("estadoCivil")
@Transactional
public class EstadoCivilDAOImpl implements EstadoCivilDAO
{
	@Autowired
	private EstadoCivilMapper estadoCivilMapper;

	@Override
	public ObtieneEstadoCivilResponse obtenerEstadoCivil(ObtieneEstadoCivilRequest request) throws Exception
	{
		// TODO Auto-generated method stub
		ObtieneEstadoCivilResponse response = new ObtieneEstadoCivilResponse();

		List<Item> estadoCivilList = estadoCivilMapper.obtenerEstadoCivil();
		if (estadoCivilList.size() != 0)
		{
			response.setEstadoCivilList(estadoCivilList);
		}

		return response;
	}

}
