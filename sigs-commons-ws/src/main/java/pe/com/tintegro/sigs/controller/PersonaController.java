package pe.com.tintegro.sigs.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import pe.com.tintegro.sigs.constants.ResponseEstado;
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
import pe.com.tintegro.sigs.helpers.RequestHelper;
import pe.com.tintegro.sigs.helpers.ResponseHelper;
import pe.com.tintegro.sigs.properties.APIProperties;
import pe.com.tintegro.sigs.service.PersonaService;

/**
 * @author Aldo Huamán
 *
 * 27 dic. 2017
 */
@RestController
@RequestMapping( "/personas" )
@Api( "Personas" )
public class PersonaController
{
	@Autowired
	private PersonaService personaService;

	private static final Logger LOG = Logger.getLogger(PersonaController.class);

	@Autowired
	private HttpServletRequest servletRequest;

	@Autowired
	private APIProperties apiProperties;

	@RequestMapping( value="/datos/actoMedico", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE ) 
	@ResponseStatus( value = HttpStatus.OK )
	@ApiOperation( value = "Obtener datos de persona por acto medico", notes = "Obtiene datos de persona para cabecera", response = ObtienePersonaDatosPorActoMedicoResponse.class )
	public ObtienePersonaDatosPorActoMedicoResponse obtenerPersonaDatosPorActoMedico(@RequestHeader("codUsuario") String codUsuario,
																					@RequestHeader("idIPRESS") String idIPRESS, 
																					@RequestHeader("token") String token, 
																					@RequestParam("idActoMedico") int idActoMedico)
	{
		ObtienePersonaDatosPorActoMedicoRequest request = new ObtienePersonaDatosPorActoMedicoRequest();
		ObtienePersonaDatosPorActoMedicoResponse response = new ObtienePersonaDatosPorActoMedicoResponse();
		request.setIdActoMedico(idActoMedico);
		try
		{
			response = personaService.obtenerPersonaDatosPorActoMedico(RequestHelper.agregarHeaders(servletRequest, request));
		} catch (Exception e)
		{
			String codigoError = ResponseHelper.obtenerCodigoErrorPorFecha(apiProperties.getNombre());
			response.setEstado(ResponseEstado.ERROR_APLICACION);
			response.setMensaje("Ocurrió un error al obtener los datos");
			response.setCodigoError(codigoError);
			LOG.error(codigoError, e);
		}
		return response;
	}
	
	@RequestMapping( value="/datos/cita", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE ) 
	@ResponseStatus( value = HttpStatus.OK )
	@ApiOperation( value = "Obtener datos de persona por cita", notes = "Obtiene datos de persona para cabecera", response = ObtienePersonaDatosPorCitaResponse.class )
	public ObtienePersonaDatosPorCitaResponse obtenerPersonaDatosPorCita(@RequestHeader("codUsuario") String codUsuario,
																		 @RequestHeader("idIPRESS") String idIPRESS, 
																		 @RequestHeader("token") String token, 
																		 @RequestParam("idCita") String idCita)
	{
		ObtienePersonaDatosPorCitaResponse response = new ObtienePersonaDatosPorCitaResponse();
		ObtienePersonaDatosPorCitaRequest request = new ObtienePersonaDatosPorCitaRequest();
		System.out.println("idCita de Controller"+idCita);
		request.setIdCita(idCita);
		try
		{
			response = personaService.obtenerPersonaDatosPorCita(RequestHelper.agregarHeaders(servletRequest, request));
		} catch (Exception e)
		{
			String codigoError = ResponseHelper.obtenerCodigoErrorPorFecha(apiProperties.getNombre());
			response.setEstado(ResponseEstado.ERROR_APLICACION);
			response.setMensaje("Ocurrió un error al obtener los datos de paciente");
			response.setCodigoError(codigoError);
			LOG.error(codigoError, e);
		}
		return response;
	}
	
	@RequestMapping( value="/datos-por-documento-identidad", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE ) 
	@ResponseStatus( value = HttpStatus.OK )
	@ApiOperation( value = "Obtener datos de persona por nro documento", notes = "Obtiene datos de persona por nro documento", response = ObtenerDatosPersonaPorDocumentoIdentidadResponse.class )
	public ObtenerDatosPersonaPorDocumentoIdentidadResponse obtenerDatosPersonaPorDcoumento(@RequestHeader("codUsuario") String codUsuario,
			@RequestHeader("idIPRESS") String idIPRESS, @RequestHeader("token") String token, @RequestParam("nuDocumento") String nuDocumento)
	{
		ObtenerDatosPersonaPorDocumentoIdentidadResponse response = new ObtenerDatosPersonaPorDocumentoIdentidadResponse();
		ObtenerDatosPersonaPorDocumentoIdentidadRequest request = new ObtenerDatosPersonaPorDocumentoIdentidadRequest();
		request.setNuDocumento(nuDocumento);
		try
		{
			response = personaService.obtenerDatosPersonaPorDocumento(RequestHelper.agregarHeaders(servletRequest, request));
		} catch (Exception e)
		{
			String codigoError = ResponseHelper.obtenerCodigoErrorPorFecha(apiProperties.getNombre());
			response.setEstado(ResponseEstado.ERROR_APLICACION);
			response.setMensaje("Ocurrió un error al obtener los datos de paciente");
			response.setCodigoError(codigoError);
			LOG.error(codigoError, e);
		}
		return response;
	}
	
	@RequestMapping( value="/id-persona", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE ) 
	@ResponseStatus( value = HttpStatus.OK )
	@ApiOperation( value = "Obtener id persona por nro documento", notes = "Obtiene numero documento e id persona de un adulto o niño", response = ObtieneIdPersonaResponse.class )
	public ObtieneIdPersonaResponse obtenerIdPersona(@RequestHeader("codUsuario") String codUsuario,
			@RequestHeader("idIPRESS") String idIPRESS, @RequestHeader("token") String token, @RequestParam("idTipoDocumentoIdentidad") int idTipoDocumentoIdentidad, @RequestParam("numeroDocumento") String numeroDocumento)
	{
		ObtieneIdPersonaResponse response  = new ObtieneIdPersonaResponse();
		ObtieneIdPersonaRequest request = new ObtieneIdPersonaRequest();
		request.setIdTipoDocumentoIdentidad(idTipoDocumentoIdentidad);
		request.setNumeroDocumento(numeroDocumento);
		try
		{
			response = personaService.obtenerIdPersona(RequestHelper.agregarHeaders(servletRequest, request));
		} catch (Exception e)
		{
			String codigoError = ResponseHelper.obtenerCodigoErrorPorFecha(apiProperties.getNombre());
			response.setEstado(ResponseEstado.ERROR_APLICACION);
			response.setMensaje("Ocurrió un error al obtener los id persona");
			response.setCodigoError(codigoError);
			LOG.error(codigoError, e);
		}
		return response;
	}
	
	@RequestMapping( value="/datos/id-persona", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE ) 
	@ResponseStatus( value = HttpStatus.OK )
	@ApiOperation( value = "Obtener datos persona", notes = "Obtiene datos de persona registrada y filiada por idPersona", response = ObtienePersonaPorIdPersonaResponse.class )
	public ObtienePersonaPorIdPersonaResponse obtenerPersonaPorIdPersona(@RequestHeader("codUsuario") String codUsuario,
			@RequestHeader("idIPRESS") String idIPRESS, @RequestHeader("token") String token, @RequestParam("idPersona") String idPersona)
	{
		ObtienePersonaPorIdPersonaResponse response = new ObtienePersonaPorIdPersonaResponse();
		ObtienePersonaPorIdPersonaRequest request = new ObtienePersonaPorIdPersonaRequest();
		request.setIdPersona(idPersona);
		try
		{
			response = personaService.obtenerPersonaPorIdPersona(RequestHelper.agregarHeaders(servletRequest, request));
		} catch (Exception e)
		{
			String codigoError = ResponseHelper.obtenerCodigoErrorPorFecha(apiProperties.getNombre());
			response.setEstado(ResponseEstado.ERROR_APLICACION);
			response.setMensaje("Ocurrió un error al obtener los datos de la persona");
			response.setCodigoError(codigoError);
			LOG.error(codigoError, e);
		}
		return response;
	}
}
