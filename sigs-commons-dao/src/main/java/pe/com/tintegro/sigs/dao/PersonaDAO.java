package pe.com.tintegro.sigs.dao;

import pe.com.tintegro.sigs.dto.request.ObtenerDatosPersonaPorDocumentoIdentidadRequest;
import pe.com.tintegro.sigs.dto.request.ObtieneIdPersonaRequest;
import pe.com.tintegro.sigs.dto.request.ObtienePersonaDatosPorActoMedicoRequest;
import pe.com.tintegro.sigs.dto.request.ObtienePersonaDatosPorCitaRequest;
import pe.com.tintegro.sigs.dto.request.ObtienePersonaPorIdPersonaRequest;
import pe.com.tintegro.sigs.dto.response.ObtenerDatosPersonaPorDocumentoIdentidadResponse;
import pe.com.tintegro.sigs.dto.response.ObtieneIdPersonaResponse;
import pe.com.tintegro.sigs.dto.response.ObtienePersonaDatosPorActoMedicoResponse;
import pe.com.tintegro.sigs.dto.response.ObtienePersonaDatosPorCitaResponse;
import pe.com.tintegro.sigs.dto.response.ObtienePersonaPorIdPersonaResponse;

/**
 * @author Aldo Huamán
 *
 *         10 ene. 2018
 */
public interface PersonaDAO
{
	public ObtienePersonaDatosPorActoMedicoResponse obtenerPersonaDatosPorActoMedico(
			ObtienePersonaDatosPorActoMedicoRequest request) throws Exception;

	public ObtienePersonaDatosPorCitaResponse obtenerPersonaDatosPorCita(ObtienePersonaDatosPorCitaRequest request)
			throws Exception;

	public ObtenerDatosPersonaPorDocumentoIdentidadResponse obtenerDatosPersonaDocumentoIdentidad(
			ObtenerDatosPersonaPorDocumentoIdentidadRequest request) throws Exception;
	
	public ObtieneIdPersonaResponse obtenerIdPersona(ObtieneIdPersonaRequest request) throws Exception;
	
	public ObtienePersonaPorIdPersonaResponse obtenerPersonaPorIdPersona(ObtienePersonaPorIdPersonaRequest request) throws Exception;
}
