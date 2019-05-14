/**
 * 
 */
package pe.com.tintegro.sigs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.tintegro.sigs.dao.PersonalDAO;
import pe.com.tintegro.sigs.dto.request.ObtienePersonalesRequest;
import pe.com.tintegro.sigs.dto.response.ObtienePersonalesResponse;
import pe.com.tintegro.sigs.entidad.Personal;
import pe.com.tintegro.sigs.service.PersonalService;
import pe.com.tintegro.sigs.util.EncriptacionUtil;

@Service( "personalService" )
public class PersonalServiceImpl implements PersonalService
{
	@Autowired
	private PersonalDAO personalDAO;
	
	@Override
	public ObtienePersonalesResponse obtenerPersonales(ObtienePersonalesRequest request) throws Exception
	{
		ObtienePersonalesResponse response = new ObtienePersonalesResponse();
		
		request.setIdIPRESS( EncriptacionUtil.desencriptar( request.getIdIPRESS() ) );
		
		List<Personal> personalList = personalDAO.obtenerPersonales( request.getIdIPRESS(), request.getIdArea(), request.getIdEspecialidad(), request.getIdActividad(), request.getIdSubActividad(), request.getIdPersonal() );
		response.setPersonalList( personalList );		
		
		return response;
	}
}
