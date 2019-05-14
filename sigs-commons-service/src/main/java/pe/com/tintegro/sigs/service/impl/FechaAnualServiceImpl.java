package pe.com.tintegro.sigs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.tintegro.sigs.constants.ResponseEstado;
import pe.com.tintegro.sigs.dao.FechaAnualDAO;
import pe.com.tintegro.sigs.dto.request.ObtieneFechaRequest;
import pe.com.tintegro.sigs.dto.response.ObtieneFechaResponse;
import pe.com.tintegro.sigs.service.FechaAnualService;
import pe.com.tintegro.sigs.util.EncriptacionUtil;

@Service("fechaAnualService")
public class FechaAnualServiceImpl implements FechaAnualService
{
	@Autowired
	private FechaAnualDAO fechaAnualDAO;
	@Override
	public ObtieneFechaResponse obtieneFecha(ObtieneFechaRequest request) throws Exception
	{
		ObtieneFechaResponse response = new ObtieneFechaResponse();
		request.setIdIPRESS( EncriptacionUtil.desencriptar( request.getIdIPRESS() ) );
		response = fechaAnualDAO.obtieneFecha(request);
		if(response.getLsFechaGeneradas() == null)
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
