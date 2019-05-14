/**
 * 
 */
package pe.com.tintegro.sigs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.tintegro.sigs.dao.ParentescoDAO;
import pe.com.tintegro.sigs.dto.request.ObtieneParentescoRequest;
import pe.com.tintegro.sigs.dto.response.ObtieneParentescoResponse;
import pe.com.tintegro.sigs.service.ParentescoService;

/**
 * @author FReyes
 *
 */
@Service("parentescoService")
public class ParentescoServiceImpl implements ParentescoService{
	
	@Autowired
	private ParentescoDAO parentescoDAO;
	
	@Override
	public ObtieneParentescoResponse obtenerParentesco(
			ObtieneParentescoRequest request) throws Exception{
		ObtieneParentescoResponse response = parentescoDAO.obtenerParentesco(request);
		return response;
	}
	

}
