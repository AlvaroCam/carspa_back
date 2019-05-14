package pe.com.tintegro.sigs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.tintegro.sigs.dao.DestinosAtencionDAO;
import pe.com.tintegro.sigs.dto.request.ObtenerComboDestinosAtencionRequest;
import pe.com.tintegro.sigs.dto.response.ObtenerComboDestinosAtencionResponse;
import pe.com.tintegro.sigs.service.DestinosAtencionService;
import pe.com.tintegro.sigs.util.EncriptacionUtil;

@Service("destinosAtencionService")
public class DestinosAtencionServiceImpl implements DestinosAtencionService{

	@Autowired
	private DestinosAtencionDAO destinosAtencionDAO;
	
	@Override
	public ObtenerComboDestinosAtencionResponse obtenerDestinos(
			ObtenerComboDestinosAtencionRequest request) throws Exception {
		request.setIdIPRESS( EncriptacionUtil.desencriptar( request.getIdIPRESS() ) );
		ObtenerComboDestinosAtencionResponse response = destinosAtencionDAO.obtenerDestinos(request);
		return response;
	}

}
