/**
 * 
 */
package pe.com.tintegro.sigs.controller;

import javax.servlet.http.HttpServletRequest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import pe.com.tintegro.sigs.constants.ResponseEstado;
import pe.com.tintegro.sigs.dto.request.ActualizarGrupoOcupacionalJRequest;
import pe.com.tintegro.sigs.dto.request.EliminarGrupoOcupacionalJRequest;
import pe.com.tintegro.sigs.dto.request.InsertarGrupoOcupacionalJRequest;
import pe.com.tintegro.sigs.dto.request.ObtenerGrupoOcupacionalJRequest;
import pe.com.tintegro.sigs.dto.request.ObtenerTipoProfesionalJRequest;
import pe.com.tintegro.sigs.dto.request.ObtieneGrupoOcupacionalRequest;
import pe.com.tintegro.sigs.dto.response.ActualizarGrupoOcupacionalJResponse;
import pe.com.tintegro.sigs.dto.response.EliminarGrupoOcupacionalJResponse;
import pe.com.tintegro.sigs.dto.response.InsertarGrupoOcupacionalJResponse;
import pe.com.tintegro.sigs.dto.response.ObtenerGrupoOcupacionalJResponse;
import pe.com.tintegro.sigs.dto.response.ObtenerTipoProfesionalJResponse;
import pe.com.tintegro.sigs.dto.response.ObtieneGrupoOcupacionalResponse;
import pe.com.tintegro.sigs.dto.response.ObtieneSexoResponse;
import pe.com.tintegro.sigs.helpers.RequestHelper;
import pe.com.tintegro.sigs.helpers.ResponseHelper;
import pe.com.tintegro.sigs.properties.APIProperties;
import pe.com.tintegro.sigs.service.GrupoOcupacionalService;

/**
 * @author Carlos
 *
 */
@RestController
@RequestMapping("/gruposOcupacionales")
@Api(value = "GrupoOcupacional")
public class GrupoOcupacionalController
{
	private static final Logger LOG = Logger.getLogger(EstadoCivilController.class);
	@Autowired
	private HttpServletRequest servletRequest;

	@Autowired
	private APIProperties apiProperties;

	@Autowired
	private GrupoOcupacionalService grupoOcupacionalService;

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	@ApiOperation(value = "Obtener Grupo Ocupacional", notes = "Obtiene obtiene grupo ocupacional", response = ObtieneSexoResponse.class)
	public ObtieneGrupoOcupacionalResponse obtenerGrupoOcupacional(@RequestHeader("codUsuario") String codUsuario, @RequestHeader("idIPRESS") String idIPRESS, @RequestHeader("token") String token,
			String codigoIeds	)
	{
		ObtieneGrupoOcupacionalResponse response = new ObtieneGrupoOcupacionalResponse();
		ObtieneGrupoOcupacionalRequest request = new ObtieneGrupoOcupacionalRequest();

		request.setCodigoIeds(codigoIeds); 
		try
		{
			response = grupoOcupacionalService.obtenerGrupoOcupacional(RequestHelper.agregarHeaders(servletRequest, request));
			response.setEstado(ResponseEstado.OK);
			response.setMensaje("Grupo Ocupacional obtenido correctamente");
		}
		catch (Exception e)
		{
			String mensajeError = "Ocurrió un error al obtener grupo ocupacional.";
			String codigoError = ResponseHelper.obtenerCodigoErrorPorFecha(apiProperties.getNombre());
			response.setEstado(ResponseEstado.ERROR_APLICACION);
			response.setCodigoError(codigoError);
			response.setMensaje(mensajeError);
			LOG.error(codigoError, e);
		}
		return response;
	}
	


	@RequestMapping(value = "/InsertarGrupoOcupacional", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	@ApiOperation(value = "Insertar nuevo Grupo Ocupacional", notes = "Inserta un grupo ocupacional", response = InsertarGrupoOcupacionalJResponse.class)
	public InsertarGrupoOcupacionalJResponse insertOcupacionalResponse (
			@RequestHeader("codUsuario") String codUsuario,
			@RequestHeader("token") String token,
			@RequestBody InsertarGrupoOcupacionalJRequest request)
	{
		InsertarGrupoOcupacionalJResponse response = new InsertarGrupoOcupacionalJResponse();

		try
		{
			response = grupoOcupacionalService.insertarGrupoOcupacionalJ(RequestHelper
					.agregarHeaders(servletRequest, request));
		}
		catch (Exception e)
		{
			String codigoError = ResponseHelper
					.obtenerCodigoErrorPorFecha(apiProperties.getNombre());
			response.setEstado(ResponseEstado.ERROR_APLICACION);
			response.setMensaje("Error al insertar Grupo Ocupacional");
			response.setCodigoError(codigoError);
			LOG.error(codigoError, e);
		}
		return response;
	}
	
	@RequestMapping(value = "/ObtenerGrupoOcupacional", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	@ApiOperation(value = "Obtener Grupo Ocupacional", notes = "Obtiene todos los Grupos Ocupacionales", response = ObtenerGrupoOcupacionalJResponse.class)
	public ObtenerGrupoOcupacionalJResponse obtenerGrupoOcupacional(
			@RequestHeader("codUsuario") String codUsuario,
			@RequestHeader("token") String token,
			String descripcionGrupoOcupacional,
			Integer idTipoProfesional,
			@RequestParam("nuPagina") Integer nuPagina,
			@RequestParam("nuRegisMostrar") Integer nuRegisMostrar)
	{
		ObtenerGrupoOcupacionalJResponse response = new ObtenerGrupoOcupacionalJResponse();
		ObtenerGrupoOcupacionalJRequest request = new ObtenerGrupoOcupacionalJRequest();
		
		request.setDescripcionGrupoOcupacional(descripcionGrupoOcupacional);
		request.setIdTipoProfesional(idTipoProfesional);
		request.setNuPagina(nuPagina);
		request.setNuRegisMostrar(nuRegisMostrar);

		try
		{
			response = grupoOcupacionalService.obtenerGrupoOcupacionalJ(RequestHelper
					.agregarHeaders(servletRequest, request));
		}
		catch (Exception e)
		{
			String codigoError = ResponseHelper
					.obtenerCodigoErrorPorFecha(apiProperties.getNombre());
			response.setEstado(ResponseEstado.ERROR_APLICACION);
			response.setMensaje("Error al obtener el Grupo Ocupacional");
			response.setCodigoError(codigoError);
			LOG.error(codigoError, e);
		}
		return response;
	}
	
	@RequestMapping(value = "/EliminarGrupoOcupacional", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	@ApiOperation(value = "Eliminar un Grupo Ocupacional", notes = "Elimina un Grupo Ocupacional", response = EliminarGrupoOcupacionalJResponse.class)
	public EliminarGrupoOcupacionalJResponse eliminarGrupoOcupacional(
			@RequestHeader("codUsuario") String codUsuario,
			@RequestHeader("token") String token,
			@RequestParam("idGrupoOcupacional") Integer idGrupoOcupacional)
	{
		EliminarGrupoOcupacionalJResponse response = new EliminarGrupoOcupacionalJResponse();
		EliminarGrupoOcupacionalJRequest request = new EliminarGrupoOcupacionalJRequest();	
		request.setIdGrupoOcupacional(idGrupoOcupacional);
		
		try
		{
			response = grupoOcupacionalService.eliminarGrupoOcupacionalJ(RequestHelper
					.agregarHeaders(servletRequest, request));
		}
		catch (Exception e)
		{
			String codigoError = ResponseHelper
					.obtenerCodigoErrorPorFecha(apiProperties.getNombre());
			response.setEstado(ResponseEstado.ERROR_APLICACION);
			response.setMensaje("Error al eliminar Grupo Ocupacional");
			response.setCodigoError(codigoError);
			LOG.error(codigoError, e);
		}
		return response;
	}
	
	@RequestMapping(value = "/ActualizarGrupoOcupacional", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	@ApiOperation(value = "Actualizar un Grupo Ocupacional", notes = "Actualiza un Grupo Ocupacional", response = ActualizarGrupoOcupacionalJResponse.class)
	public ActualizarGrupoOcupacionalJResponse actualizarGrupoOcupacional(
			@RequestHeader("codUsuario") String codUsuario,
			@RequestHeader("token") String token,
			@RequestBody ActualizarGrupoOcupacionalJRequest request)
	{
		ActualizarGrupoOcupacionalJResponse response = new ActualizarGrupoOcupacionalJResponse();

		try
		{
			response = grupoOcupacionalService.actualizarGrupoOcupacionalJ(RequestHelper
					.agregarHeaders(servletRequest, request));
		}
		catch (Exception e)
		{
			String codigoError = ResponseHelper
					.obtenerCodigoErrorPorFecha(apiProperties.getNombre());
			response.setEstado(ResponseEstado.ERROR_APLICACION);
			response.setMensaje("Error al actualizar el Grupo Ocupacional");
			response.setCodigoError(codigoError);
			LOG.error(codigoError, e);
		}
		return response;
	}
	
	@RequestMapping(value = "/ObtenerTipoProfesional", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	@ApiOperation(value = "Obtener Tipo Profesional", notes = "Obtiene Tipo Profesional", response = ObtenerTipoProfesionalJResponse.class)
	public ObtenerTipoProfesionalJResponse obtenerTipoProfesional(
			@RequestHeader("codUsuario") String codUsuario,
			@RequestHeader("token") String token,
			Integer codigo,
			String descripcionTipoProfesional)

	{
		ObtenerTipoProfesionalJResponse response = new ObtenerTipoProfesionalJResponse();
		ObtenerTipoProfesionalJRequest request = new ObtenerTipoProfesionalJRequest();


		try
		{
			response = grupoOcupacionalService.obtenerTipoProfesionalJ(RequestHelper
					.agregarHeaders(servletRequest, request));
		}
		catch (Exception e)
		{
			String codigoError = ResponseHelper
					.obtenerCodigoErrorPorFecha(apiProperties.getNombre());
			response.setEstado(ResponseEstado.ERROR_APLICACION);
			response.setMensaje("Error al obtener Tipo Profesional");
			response.setCodigoError(codigoError);
			LOG.error(codigoError, e);
		}
		return response;
	}
}
