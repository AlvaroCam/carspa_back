package pe.com.tintegro.sigs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.tintegro.sigs.constants.ResponseEstado;
import pe.com.tintegro.sigs.dao.OrigenDAO;
import pe.com.tintegro.sigs.dto.request.ObtieneOrigenesRequest;
import pe.com.tintegro.sigs.dto.response.ObtieneOrigenesResponse;
import pe.com.tintegro.sigs.service.OrigenService;
import pe.com.tintegro.sigs.util.EncriptacionUtil;

@Service("origenService")
public class OrigenServiceImpl implements OrigenService 
{
	
	@Autowired
	private OrigenDAO origenDAO;
	
	@Override
	public ObtieneOrigenesResponse obtenerOrigenes(ObtieneOrigenesRequest request) throws Exception 
	{
		ObtieneOrigenesResponse response = new ObtieneOrigenesResponse();
		request.setIdIPRESS( EncriptacionUtil.desencriptar( request.getIdIPRESS() ) );
		response = origenDAO.obtenerOrigen(request);
		if(response.getOrigenList() == null)
		{
			response.setEstado(ResponseEstado.ERROR_NEGOCIO);
			response.setMensaje("No se existen origenes");
		}else
		{
			response.setEstado(ResponseEstado.OK);
			response.setMensaje("Origenes contenidos correctamente");
		}
		return response;
	}

}
