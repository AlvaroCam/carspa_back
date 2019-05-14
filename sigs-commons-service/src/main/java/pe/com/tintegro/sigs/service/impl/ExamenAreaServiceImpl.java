package pe.com.tintegro.sigs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.tintegro.sigs.constants.ResponseEstado;
import pe.com.tintegro.sigs.dao.ExamenAreaDAO;
import pe.com.tintegro.sigs.dto.request.ObtieneExamenAreasRequest;
import pe.com.tintegro.sigs.dto.response.ObtieneExamenAreasResponse;
import pe.com.tintegro.sigs.service.ExamenAreaService;
import pe.com.tintegro.sigs.util.EncriptacionUtil;

@Service("examenAreaService")
public class ExamenAreaServiceImpl implements ExamenAreaService
{
	@Autowired
	private ExamenAreaDAO examenAreaDAO;

	@Override
	public ObtieneExamenAreasResponse obtenerExamenAreas(ObtieneExamenAreasRequest request) throws Exception 
	{
		ObtieneExamenAreasResponse response = new ObtieneExamenAreasResponse();
		request.setIdIPRESS( EncriptacionUtil.desencriptar( request.getIdIPRESS() ) );
		response = examenAreaDAO.obtenerExamenAreas(request);
		if(response.getExamenAreaList() == null)
		{
			response.setEstado(ResponseEstado.ERROR_NEGOCIO);
			response.setMensaje("Error al obtener las areas de exámenes");
		}else
		{
			response.setEstado(ResponseEstado.OK);
			response.setMensaje("Areas obtenidas correctamente");
		}
		return response;
	}
}
