/**
 * 
 */
package pe.com.tintegro.sigs.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.com.tintegro.sigs.dao.GradoInstruccionDAO;
import pe.com.tintegro.sigs.dto.request.ObtieneGradoInstruccionRequest;
import pe.com.tintegro.sigs.dto.response.ObtieneGradoInstruccionResponse;
import pe.com.tintegro.sigs.entidad.general.Item;
import pe.com.tintegro.sigs.mapper.GradoInstruccionMapper;

/**
 * @author FReyes
 *
 */
@Repository("gradoInstruccionDAO")
@Transactional
public class GradoInstruccionImpl implements GradoInstruccionDAO
{
	@Autowired
	private GradoInstruccionMapper gradoInstruccionMapper;
	
	public ObtieneGradoInstruccionResponse obtenerGradoInstruccion(ObtieneGradoInstruccionRequest request) throws Exception
	{
		ObtieneGradoInstruccionResponse response = new ObtieneGradoInstruccionResponse();
		List<Item> itemList = gradoInstruccionMapper.obtenerGradoInstruccion();
		if(itemList.size() != 0)
		{
			response.setGradoInstruccionList(itemList);
		}
		return response;
	}
}
