/**
 * 
 */
package pe.com.tintegro.sigs.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.com.tintegro.sigs.dao.SexoDAO;
import pe.com.tintegro.sigs.dto.request.ObtieneSexoRequest;
import pe.com.tintegro.sigs.dto.response.ObtieneSexoResponse;
import pe.com.tintegro.sigs.entidad.general.Item;
import pe.com.tintegro.sigs.mapper.SexoMapper;

/**
 * @author Carlos
 *
 */
@Repository("sexoDAO")
@Transactional
public class SexoDAOImpl implements SexoDAO
{
	@Autowired
	private SexoMapper sexoMapper;

	@Override
	public ObtieneSexoResponse obtenerSexo(ObtieneSexoRequest request) throws Exception
	{
		// TODO Auto-generated method stub
		ObtieneSexoResponse response = new ObtieneSexoResponse();
		List<Item> itemList = sexoMapper.obtenerSexo();
		if (itemList.size() != 0)
		{
			response.setSexoList(itemList);
		}

		return response;
	}

}
