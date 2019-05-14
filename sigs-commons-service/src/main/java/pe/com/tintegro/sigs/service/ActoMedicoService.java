package pe.com.tintegro.sigs.service;

import pe.com.tintegro.sigs.dto.request.ObtieneActoMedicoPorCitaRequest;
import pe.com.tintegro.sigs.dto.response.ObtieneActoMedicoPorCitaResponse;

/**
 * @author Aldo Huamán
 *
 * 10 ene. 2018
 */
public interface ActoMedicoService
{
	public ObtieneActoMedicoPorCitaResponse obtenerActoMedicoPorCita(ObtieneActoMedicoPorCitaRequest request) throws Exception;
}
