/**
 * 
 */
package pe.com.tintegro.sigs.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.com.tintegro.sigs.dao.ParentescoDAO;
import pe.com.tintegro.sigs.dto.request.ObtieneParentescoRequest;
import pe.com.tintegro.sigs.dto.response.ObtieneParentescoResponse;
import pe.com.tintegro.sigs.entidad.general.Item;
import pe.com.tintegro.sigs.mapper.ParentescoMapper;

/**
 * @author FReyes
 *
 */
@Repository("parentescoDAO")
@Transactional
public class ParentescoDAOImpl implements ParentescoDAO
{
	@Autowired
	private ParentescoMapper parentescoMapper;
	
	@Override
	public ObtieneParentescoResponse obtenerParentesco(ObtieneParentescoRequest request) throws Exception
	{
		ObtieneParentescoResponse response = new ObtieneParentescoResponse();
		List<Item> itemList = parentescoMapper.obtenerParentesco();
		if(itemList.size() != 0)
		{
			response.setParentescoList(itemList);
		}
		return response;
	}
}
