package pe.com.tintegro.sigs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.tintegro.sigs.constants.ResponseEstado;
import pe.com.tintegro.sigs.dao.ExamenTipoDAO;
import pe.com.tintegro.sigs.dto.request.ObtieneExamenTiposRequest;
import pe.com.tintegro.sigs.dto.response.ObtieneExamenTiposResponse;
import pe.com.tintegro.sigs.service.ExamenTipoService;
import pe.com.tintegro.sigs.util.EncriptacionUtil;

@Service("examenTipoService")
public class ExamenTiposServiceImpl implements ExamenTipoService
{
	@Autowired
	private ExamenTipoDAO examenTipoDAO;
	
	@Override
	public ObtieneExamenTiposResponse obtenerExamenTipos(ObtieneExamenTiposRequest request) throws Exception 
	{
		ObtieneExamenTiposResponse response = new ObtieneExamenTiposResponse();
		request.setIdIPRESS( EncriptacionUtil.desencriptar( request.getIdIPRESS() ) );
		response = examenTipoDAO.obtenerExamenTipos(request);
		if(response.getExamenTipoList() == null)
		{
			response.setEstado(ResponseEstado.ERROR_NEGOCIO);
			response.setMensaje("Error al obtener los tipos de examenes");
		}else
		{
			response.setEstado(ResponseEstado.OK);
			response.setMensaje("Tipo de examenes obtenidos correctamente");
		}
		return response;
	}
	
}
