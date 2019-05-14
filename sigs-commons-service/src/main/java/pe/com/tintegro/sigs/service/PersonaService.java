package pe.com.tintegro.sigs.service;

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

public interface PersonaService
{
	public ObtienePersonaDatosPorActoMedicoResponse obtenerPersonaDatosPorActoMedico(
			ObtienePersonaDatosPorActoMedicoRequest request) throws Exception;

	public ObtienePersonaDatosPorCitaResponse obtenerPersonaDatosPorCita(ObtienePersonaDatosPorCitaRequest request)
			throws Exception;

	public ObtenerDatosPersonaPorDocumentoIdentidadResponse obtenerDatosPersonaPorDocumento(
			ObtenerDatosPersonaPorDocumentoIdentidadRequest request) throws Exception;
	
	public ObtieneIdPersonaResponse obtenerIdPersona(ObtieneIdPersonaRequest request) throws Exception;
	
	public ObtienePersonaPorIdPersonaResponse obtenerPersonaPorIdPersona(ObtienePersonaPorIdPersonaRequest request) throws Exception;
}
