/**
 * 
 */
package pe.com.tintegro.sigs.controller;

import javax.servlet.http.HttpServletRequest;

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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import pe.com.tintegro.sigs.constants.ResponseEstado;
import pe.com.tintegro.sigs.dto.request.ActualizarAmbienteRequest;
import pe.com.tintegro.sigs.dto.request.EliminarAmbienteRequest;
import pe.com.tintegro.sigs.dto.request.InsertarAmbienteRequest;
import pe.com.tintegro.sigs.dto.request.ObtieneActividadAmbienteRequest;
import pe.com.tintegro.sigs.dto.request.ObtieneAmbienteEspecialidadRequest;
import pe.com.tintegro.sigs.dto.request.ObtieneAmbientesRequest;
import pe.com.tintegro.sigs.dto.response.ActualizarAmbienteResponse;
import pe.com.tintegro.sigs.dto.response.EliminarAmbienteResponse;
import pe.com.tintegro.sigs.dto.response.InsertarAmbienteResponse;
import pe.com.tintegro.sigs.dto.response.ObtieneActividadAmbienteResponse;
import pe.com.tintegro.sigs.dto.response.ObtieneAmbienteEspecialidadResponse;
import pe.com.tintegro.sigs.dto.response.ObtieneAmbientesResponse;
import pe.com.tintegro.sigs.helpers.RequestHelper;
import pe.com.tintegro.sigs.helpers.ResponseHelper;
import pe.com.tintegro.sigs.properties.APIProperties;
import pe.com.tintegro.sigs.service.AmbienteService;

/**
 * @author daniel - 15 set. 2017
 *
 */
@RestController
@RequestMapping( "/ambientes" )
@Api( "Ambiente" )
public class AmbienteController
{
	private static final Logger LOG = Logger.getLogger(AmbienteController.class);

	@Autowired
	private HttpServletRequest servletRequest;

	@Autowired
	private APIProperties apiProperties;
	
	@Autowired
	private AmbienteService ambienteService;
	
	@RequestMapping( method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE ) 
	@ResponseStatus( value = HttpStatus.OK )
	@ApiOperation( value = "Obtener ambientes", notes = "Obtiene todos los ambientes del sistema.", response = ObtieneAmbientesResponse.class )
	public ObtieneAmbientesResponse obtenerAmbientes( 
								@RequestHeader( "codUsuario" ) String codUsuario, 
								@RequestHeader( "idIPRESS" ) String idIPRESS, 
								@RequestHeader( "token" ) String token,
								@RequestParam (  value = "idArea", required = false) Integer idArea,
								@RequestParam (  value = "idEspecialidad", required = false) Integer idEspecialidad,
								@RequestParam (  value = "idActividad", required = false) Integer idActividad)
	{
		ObtieneAmbientesRequest request = new ObtieneAmbientesRequest();
		ObtieneAmbientesResponse response = new ObtieneAmbientesResponse();
		
		request.setIdArea(idArea);
		request.setIdEspecialidad(idEspecialidad);
		request.setIdActividad(idActividad);
		
		try
		{
			response = ambienteService.obtenerAmbientes( RequestHelper.agregarHeaders( servletRequest, request ) );
			response.setEstado( ResponseEstado.OK );
			response.setMensaje( "Ambientes obtenidos correctamente." );
		}
		catch (Exception e)
		{
			String codigoError = ResponseHelper.obtenerCodigoErrorPorFecha( apiProperties.getNombre() );
			response.setEstado( ResponseEstado.ERROR_APLICACION );
			response.setMensaje( "Ocurrió un error al obtener ambientes." );
			response.setCodigoError( codigoError );
			LOG.error( codigoError, e );
		} 
		
		return response;
	}
	
	@RequestMapping(value = "/obtener-ambiente-especialidad", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE ) 
	@ResponseStatus( value = HttpStatus.OK )
	@ApiOperation( value = "Obtener ambientes", notes = "Obtiene todos los ambientes por especialidad.", response = ObtieneAmbienteEspecialidadResponse.class )
	public ObtieneAmbienteEspecialidadResponse obtenerAmbienteEspecialidad( 
								@RequestHeader( "codUsuario" ) String codUsuario, 
								@RequestHeader( "idIPRESS" ) String idIPRESS, 
								@RequestHeader( "token" ) String token,
								Integer idArea,
								String descripcionAmbiente,
								Integer idEspecialidad,
								Integer idActividad,
								Integer nuPagina,
								Integer nuRegisMostrar)
	{
		ObtieneAmbienteEspecialidadRequest request = new ObtieneAmbienteEspecialidadRequest();
		ObtieneAmbienteEspecialidadResponse response = new ObtieneAmbienteEspecialidadResponse();
		
		request.setIdArea(idArea);
		request.setDescripcionAmbiente(descripcionAmbiente);
		request.setIdEspecialidad(idEspecialidad);
		request.setIdActividad(idActividad);
		request.setNuPagina(nuPagina);
		request.setNuRegisMostrar(nuRegisMostrar);
		
		try
		{
			response = ambienteService.obtenerAmbienteEspecialidad( RequestHelper.agregarHeaders( servletRequest, request ) );
			response.setEstado( ResponseEstado.OK );
			response.setMensaje( "Ambientes obtenidos correctamente." );
		}
		catch (Exception e)
		{
			String codigoError = ResponseHelper.obtenerCodigoErrorPorFecha( apiProperties.getNombre() );
			response.setEstado( ResponseEstado.ERROR_APLICACION );
			response.setMensaje( "Ocurrió un error al obtener ambientes." );
			response.setCodigoError( codigoError );
			LOG.error( codigoError, e );
		} 
		
		return response;
	}
	
	@RequestMapping(value = "/inserta-ambiente", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	@ApiOperation(value = "Insertar Ambiente", notes = "Inserta Ambiente", response = InsertarAmbienteResponse.class)
	public InsertarAmbienteResponse insertaAmbiente(
			@RequestHeader("codUsuario") String codUsuario,
			@RequestHeader("idIPRESS") String idIPRESS,
			@RequestHeader("token") String token,
			@RequestBody InsertarAmbienteRequest request)
	{
		InsertarAmbienteResponse response = new InsertarAmbienteResponse();

		try
		{
			response = ambienteService.insertaAmbiente(RequestHelper.agregarHeaders(servletRequest, request));
		}
		catch (Exception e)
		{
			String codigoError = ResponseHelper
					.obtenerCodigoErrorPorFecha(apiProperties.getNombre());

			response.setEstado(ResponseEstado.ERROR_APLICACION);
			response.setMensaje("Error al insertar ambientes");
			response.setCodigoError(codigoError);

			LOG.error(codigoError, e);
		}
		return response;
	}
	
	@RequestMapping(value = "/obtener-actividad-ambiente", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE ) 
	@ResponseStatus( value = HttpStatus.OK )
	@ApiOperation( value = "Obtener actividades", notes = "Obtiene todas las actividades.", response = ObtieneActividadAmbienteResponse.class )
	public ObtieneActividadAmbienteResponse obtenerActividadAmbiente( 
								@RequestHeader( "codUsuario" ) String codUsuario, 
								@RequestHeader( "idIPRESS" ) String idIPRESS, 
								@RequestHeader( "token" ) String token,
								@RequestParam ( "idArea" ) Integer idArea,
								@RequestParam("idEspecialidad")Integer idEspecialidad)
	{
		ObtieneActividadAmbienteRequest request = new ObtieneActividadAmbienteRequest();
		ObtieneActividadAmbienteResponse response = new ObtieneActividadAmbienteResponse();

		request.setIdArea(idArea);
		request.setIdEspecialidad(idEspecialidad);
		request.setIdIPRESS(idIPRESS);
		
		try
		{
			response = ambienteService.obtenerActividadAmbiente( RequestHelper.agregarHeaders( servletRequest, request ) );
			response.setEstado( ResponseEstado.OK );
			response.setMensaje( "Actividades obtenidos correctamente." );
		}
		catch (Exception e)
		{
			String codigoError = ResponseHelper.obtenerCodigoErrorPorFecha( apiProperties.getNombre() );
			response.setEstado( ResponseEstado.ERROR_APLICACION );
			response.setMensaje( "Ocurrió un error al obtener actividades." );
			response.setCodigoError( codigoError );
			LOG.error( codigoError, e );
		} 
		
		return response;
	}
	
	@RequestMapping(value = "/elimina-ambiente", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	@ApiOperation(value = "Elimina Ambiente", notes = "Elimina Ambiente", response = EliminarAmbienteResponse.class)
	public EliminarAmbienteResponse eliminaAmbiente(
			@RequestHeader("codUsuario") String codUsuario,
			@RequestHeader("idIPRESS") String idIPRESS,
			@RequestHeader("token") String token,
			@RequestParam("idAmbiente")Integer idAmbiente)
	{
		EliminarAmbienteResponse response = new EliminarAmbienteResponse();
		EliminarAmbienteRequest request =  new EliminarAmbienteRequest();
		
		request.setIdAmbiente(idAmbiente);

		try
		{
			response = ambienteService.eliminaAmbiente(RequestHelper.agregarHeaders(servletRequest, request));
		}
		catch (Exception e)
		{
			String codigoError = ResponseHelper
					.obtenerCodigoErrorPorFecha(apiProperties.getNombre());

			response.setEstado(ResponseEstado.ERROR_APLICACION);
			response.setMensaje("Error al eliminar ambientes");
			response.setCodigoError(codigoError);

			LOG.error(codigoError, e);
		}
		return response;
	}
	
	@RequestMapping(value = "/actualizar-ambiente", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	@ApiOperation(value = "Actualizar Ambiente", notes = "Actualizar Ambiente", response = ActualizarAmbienteResponse.class)
	public ActualizarAmbienteResponse actualizarAmbiente(
			@RequestHeader("codUsuario") String codUsuario,
			@RequestHeader("idIPRESS") String idIPRESS,
			@RequestHeader("token") String token,
			@RequestBody ActualizarAmbienteRequest request)
	{
		ActualizarAmbienteResponse response = new ActualizarAmbienteResponse();

		try
		{
			response = ambienteService.actualizarAmbiente(RequestHelper.agregarHeaders(servletRequest, request));
		}
		catch (Exception e)
		{
			String codigoError = ResponseHelper
					.obtenerCodigoErrorPorFecha(apiProperties.getNombre());

			response.setEstado(ResponseEstado.ERROR_APLICACION);
			response.setMensaje("Error al actualizar ambientes");
			response.setCodigoError(codigoError);

			LOG.error(codigoError, e);
		}
		return response;
	}
}
