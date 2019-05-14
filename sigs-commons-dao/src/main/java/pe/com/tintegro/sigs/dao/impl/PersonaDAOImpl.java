package pe.com.tintegro.sigs.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.com.tintegro.sigs.dao.PersonaDAO;
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
import pe.com.tintegro.sigs.entidad.Persona;
import pe.com.tintegro.sigs.mapper.PersonaMapper;

@Transactional
@Repository("personaDAO")
public class PersonaDAOImpl implements PersonaDAO
{

	@Autowired
	private PersonaMapper personaMapper;
	
	@Override
	public ObtienePersonaDatosPorActoMedicoResponse obtenerPersonaDatosPorActoMedico(ObtienePersonaDatosPorActoMedicoRequest request) throws Exception
	{
		ObtienePersonaDatosPorActoMedicoResponse response = new ObtienePersonaDatosPorActoMedicoResponse();
		Persona persona = personaMapper.obtenerPersonaDatosPorActoMedico(request.getIdActoMedico());
		response.setPersona(persona);
		return response;
	}

	@Override
	public ObtienePersonaDatosPorCitaResponse obtenerPersonaDatosPorCita(ObtienePersonaDatosPorCitaRequest request) throws Exception
	{
		ObtienePersonaDatosPorCitaResponse response = new ObtienePersonaDatosPorCitaResponse();
		System.out.println("idCita del dao: "+Integer.valueOf(request.getIdCita()));
		Persona persona = personaMapper.obtenerPersonaDatosPorCita(Integer.valueOf(request.getIdCita()));
		response.setPersona(persona);
		return response;
	}

	@Override
	public ObtenerDatosPersonaPorDocumentoIdentidadResponse obtenerDatosPersonaDocumentoIdentidad(ObtenerDatosPersonaPorDocumentoIdentidadRequest request) throws Exception {
		ObtenerDatosPersonaPorDocumentoIdentidadResponse response = new ObtenerDatosPersonaPorDocumentoIdentidadResponse();
		Persona persona = personaMapper.obtenerDatosPersonaPorDocumento(request.getNuDocumento(), request.getIdIPRESS());
		response.setDatosPersona(persona);
		return response;
	}

	@Override
	public ObtieneIdPersonaResponse obtenerIdPersona(ObtieneIdPersonaRequest request) throws Exception
	{
		ObtieneIdPersonaResponse response = new ObtieneIdPersonaResponse();
		List<Persona> personaList = personaMapper.obtenerIdPersona(request.getIdTipoDocumentoIdentidad(), request.getNumeroDocumento());
		response.setPersonaList(personaList);
		return response;
	}

	@Override
	public ObtienePersonaPorIdPersonaResponse obtenerPersonaPorIdPersona(ObtienePersonaPorIdPersonaRequest request)
			throws Exception
	{
		ObtienePersonaPorIdPersonaResponse response = new ObtienePersonaPorIdPersonaResponse();
		List<Persona> personaList = personaMapper.obtenerPersonaPorIdPersona(request.getIdPersona(), request.getIdIPRESS());
		response.setPersonaList(personaList);
		return response;
	}
}
