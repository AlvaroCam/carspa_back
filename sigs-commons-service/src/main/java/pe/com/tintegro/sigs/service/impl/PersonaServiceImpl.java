package pe.com.tintegro.sigs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.tintegro.sigs.constants.ResponseEstado;
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
import pe.com.tintegro.sigs.service.PersonaService;
import pe.com.tintegro.sigs.util.EncriptacionUtil;

/**
 * @author Aldo Huamán
 *
 *         10 ene. 2018
 */
@Service("personaService")
public class PersonaServiceImpl implements PersonaService
{

	@Autowired
	private PersonaDAO personaDAO;

	@Override
	public ObtienePersonaDatosPorActoMedicoResponse obtenerPersonaDatosPorActoMedico(
			ObtienePersonaDatosPorActoMedicoRequest request) throws Exception
	{
		request.setIdIPRESS(EncriptacionUtil.desencriptar(request.getIdIPRESS()));
		ObtienePersonaDatosPorActoMedicoResponse response = new ObtienePersonaDatosPorActoMedicoResponse();
		response = personaDAO.obtenerPersonaDatosPorActoMedico(request);
		if (response.getPersona() == null)
		{
			response.setEstado(ResponseEstado.ERROR_NEGOCIO);
			response.setMensaje("No se obtuvieron datos con los parametros ingresados");
		} else
		{
			response.setEstado(ResponseEstado.OK);
			response.setMensaje("Se obtuvieron los datos correctamente");
		}
		return response;
	}

	@Override
	public ObtienePersonaDatosPorCitaResponse obtenerPersonaDatosPorCita(ObtienePersonaDatosPorCitaRequest request)
			throws Exception
	{
		request.setIdIPRESS(EncriptacionUtil.desencriptar(request.getIdIPRESS()));
		request.setIdCita(EncriptacionUtil.desencriptar((request.getIdCita())));
		System.out.println("idCita del Implemnent "+request.getIdCita());
		ObtienePersonaDatosPorCitaResponse response = personaDAO.obtenerPersonaDatosPorCita(request);

		if(response.getPersona() == null)
		{
			response.setEstado(ResponseEstado.ERROR_NEGOCIO);
			response.setMensaje("No se obtuvieron datos con los parametros con el idPersona ingresado");
		} else
		{
			response.setEstado(ResponseEstado.OK);
			response.setMensaje("Se obtuvieron los datos correctamente");
		}
		return response;
	}

	@Override
	public ObtenerDatosPersonaPorDocumentoIdentidadResponse obtenerDatosPersonaPorDocumento(
			ObtenerDatosPersonaPorDocumentoIdentidadRequest request) throws Exception
	{
		request.setIdIPRESS(EncriptacionUtil.desencriptar(request.getIdIPRESS()));
		ObtenerDatosPersonaPorDocumentoIdentidadResponse response = personaDAO
				.obtenerDatosPersonaDocumentoIdentidad(request);
		if (response.getDatosPersona() == null)
		{
			response.setEstado(ResponseEstado.ERROR_NEGOCIO);
			response.setMensaje("No se obtuvieron datos con los parametros con el nro documento ingresado");
		} else
		{
			response.setEstado(ResponseEstado.OK);
			response.setMensaje("Se obtuvieron los datos correctamente");
		}
		return response;
	}

	@Override
	public ObtieneIdPersonaResponse obtenerIdPersona(ObtieneIdPersonaRequest request) throws Exception
	{
		request.setIdIPRESS(EncriptacionUtil.desencriptar(request.getIdIPRESS()));
		ObtieneIdPersonaResponse response = personaDAO.obtenerIdPersona(request);
		response.setEstado(ResponseEstado.OK);
		response.setMensaje("Id persona obtenido correctamente");
		return response;
	}

	@Override
	public ObtienePersonaPorIdPersonaResponse obtenerPersonaPorIdPersona(ObtienePersonaPorIdPersonaRequest request)
			throws Exception
	{
		request.setIdIPRESS(EncriptacionUtil.desencriptar(request.getIdIPRESS()));
		ObtienePersonaPorIdPersonaResponse response = personaDAO.obtenerPersonaPorIdPersona(request);
		response.setEstado(ResponseEstado.OK);
		response.setMensaje("Datos de persona obtenidos correctamente");
		return response;
	}

}
