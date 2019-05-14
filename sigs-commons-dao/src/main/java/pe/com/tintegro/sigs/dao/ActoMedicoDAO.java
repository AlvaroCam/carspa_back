package pe.com.tintegro.sigs.dao;

import pe.com.tintegro.sigs.dto.request.ObtieneActoMedicoPorCitaRequest;
import pe.com.tintegro.sigs.dto.response.ObtieneActoMedicoPorCitaResponse;

/**
 * @author Aldo Huamán
 *
 * 10 ene. 2018
 */
public interface ActoMedicoDAO
{
	public ObtieneActoMedicoPorCitaResponse obtenerActoMedicoPorCita(ObtieneActoMedicoPorCitaRequest request) throws Exception;
}
