package pe.com.tintegro.sigs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.tintegro.sigs.constants.ResponseEstado;
import pe.com.tintegro.sigs.dao.ActoMedicoDAO;
import pe.com.tintegro.sigs.dto.request.ObtieneActoMedicoPorCitaRequest;
import pe.com.tintegro.sigs.dto.response.ObtieneActoMedicoPorCitaResponse;
import pe.com.tintegro.sigs.service.ActoMedicoService;
import pe.com.tintegro.sigs.util.EncriptacionUtil;

/**
 * @author Aldo Huamán
 *
 *         10 ene. 2018
 */
@Service("actoMedicoService")
public class ActoMedicoServiceImpl implements ActoMedicoService
{
	@Autowired
	private ActoMedicoDAO actoMedicoDAO;

	@Override
	public ObtieneActoMedicoPorCitaResponse obtenerActoMedicoPorCita(ObtieneActoMedicoPorCitaRequest request)
			throws Exception
	{
		request.setIdIPRESS(EncriptacionUtil.desencriptar(request.getIdIPRESS()));
		ObtieneActoMedicoPorCitaResponse response = new ObtieneActoMedicoPorCitaResponse();
		response = actoMedicoDAO.obtenerActoMedicoPorCita(request);
		if (response.getActoMedico() == null)
		{
			response.setEstado(ResponseEstado.ERROR_NEGOCIO);
			response.setMensaje("No se encontró acto medico con la cita ingresada");
		} else
		{
			response.setEstado(ResponseEstado.OK);
			response.setMensaje("Se obtuvo el acto medico correctamente");
		}
		return response;
	}

}
