/**
 * 
 */
package pe.com.tintegro.sigs.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.com.tintegro.sigs.dao.OcupacionDAO;
import pe.com.tintegro.sigs.dto.request.ObtieneOcupacionRequest;
import pe.com.tintegro.sigs.dto.response.ObtieneOcupacionResponse;
import pe.com.tintegro.sigs.entidad.general.Item;
import pe.com.tintegro.sigs.mapper.OcupacionMapper;

/**
 * @author FReyes
 *
 */
@Repository("ocupacionDAO")
@Transactional
public class OcupacionDAOImpl implements OcupacionDAO
{
	@Autowired
	private OcupacionMapper ocupacionMapper;
	
	@Override
	public ObtieneOcupacionResponse obtenerOcupacion(ObtieneOcupacionRequest request) throws Exception
	{
		ObtieneOcupacionResponse response = new ObtieneOcupacionResponse();
		List<Item> itemList = ocupacionMapper.obtenerOcupacion();
		if(itemList.size() != 0)
		{
			response.setOcupacionList(itemList);
		}
		return response;
	}

	@Override
	public ObtieneOcupacionResponse obtenerOcupacionOfDescripcion(
			ObtieneOcupacionRequest request) throws Exception {
		ObtieneOcupacionResponse response = new ObtieneOcupacionResponse();
		List<Item> listOcupacion = ocupacionMapper.obtenerOcupacionForActoMedico(request.getDescripcion());
		response.setOcupacionList(listOcupacion);
		return response;
	}
}
