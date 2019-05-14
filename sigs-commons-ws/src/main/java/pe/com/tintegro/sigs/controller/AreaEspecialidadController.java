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
import pe.com.tintegro.sigs.dto.request.ActualizarAreaPorEspecialidadRequest;
import pe.com.tintegro.sigs.dto.request.EliminarAreaPorEspecialidadRequest;
import pe.com.tintegro.sigs.dto.request.InsertarAreaPorEspecialidadRequest;
import pe.com.tintegro.sigs.dto.request.ObtenerAreaPorEspecialidadRequest;
import pe.com.tintegro.sigs.dto.response.ActualizarAreaPorEspecialidadResponse;
import pe.com.tintegro.sigs.dto.response.EliminarAreaPorEspecialidadResponse;
import pe.com.tintegro.sigs.dto.response.InsertarAreaPorEspecialidadResponse;
import pe.com.tintegro.sigs.dto.response.ObtenerAreaPorEspecialidadResponse;
import pe.com.tintegro.sigs.helpers.RequestHelper;
import pe.com.tintegro.sigs.helpers.ResponseHelper;
import pe.com.tintegro.sigs.properties.APIProperties;
import pe.com.tintegro.sigs.service.AreaEspecialidadService;

@RequestMapping("/areaEspecialidad")
@RestController
@Api("Ã�reaEspecialidad")
public class AreaEspecialidadController {
	
	private static final Logger LOG = Logger.getLogger(ActividadController.class);

	@Autowired
	private HttpServletRequest servletRequest;

	@Autowired
	private APIProperties apiProperties;
	
	@Autowired
	private AreaEspecialidadService areaEspecialidadService;
	
	
	@RequestMapping( value = "/obtenerAreaXEspecialidad", 
	            method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE )
	@ResponseStatus( value = HttpStatus.OK )
	@ApiOperation(value = "Obtener Area por Especialidad", notes = "Obtiene las Areas por Especialidades.", response = ObtenerAreaPorEspecialidadResponse.class )
	public ObtenerAreaPorEspecialidadResponse obtenerAreaPorEspecialidad( 
			@RequestHeader( "codUsuario" ) String codUsuario, 
		    @RequestHeader( "idIPRESS" ) String idIPRESS, 
		    @RequestHeader( "token" ) String token,
		    @RequestParam( value = "idArea", required = false ) Integer idArea,
		    @RequestParam( value = "idEspecialidad", required = false ) Integer idEspecialidad,
		    @RequestParam( value = "nuPagina", required = false ) Integer nuPagina,
		    @RequestParam( value = "nuRegisMostrar", required = false ) Integer nuRegisMostrar )
	{
		ObtenerAreaPorEspecialidadResponse response = new ObtenerAreaPorEspecialidadResponse();
		ObtenerAreaPorEspecialidadRequest request = new ObtenerAreaPorEspecialidadRequest();
		
		request.setIdArea(idArea);
		request.setIdEspecialidad(idEspecialidad);
		request.setNuPagina(nuPagina);
		request.setNuRegisMostrar(nuRegisMostrar);
	
		try
		{
			response = areaEspecialidadService.obtenerAreaPorEspecialidad(RequestHelper
					.agregarHeaders(servletRequest, request));
		}
		catch (Exception e)
		{
			String codigoError = ResponseHelper
					.obtenerCodigoErrorPorFecha(apiProperties.getNombre());
			response.setEstado(ResponseEstado.ERROR_APLICACION);
			response.setMensaje("Error al obtener Areas por Especialidades");
			response.setCodigoError(codigoError);
			LOG.error(codigoError, e);
		}
		return response;
	}
	
	@RequestMapping( value = "/insertarAreaXEspecialidad", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE )
	@ResponseStatus( value = HttpStatus.OK )
	@ApiOperation( value = "Insertar Area por Especialidad", notes = "Inserta Areas por Especialidades.", response = InsertarAreaPorEspecialidadResponse.class )
	public InsertarAreaPorEspecialidadResponse insertarAreaPorEspecialidad( 
						@RequestHeader( "codUsuario" ) String codUsuario, 
						@RequestHeader( "idIPRESS" ) String idIPRESS, 
						@RequestHeader( "token" ) String token,
						@RequestBody InsertarAreaPorEspecialidadRequest request)
	{
		InsertarAreaPorEspecialidadResponse response = new InsertarAreaPorEspecialidadResponse();
		
		try
		{
			response = areaEspecialidadService.insertarAreaPorEspecialidad( RequestHelper.agregarHeaders( servletRequest, request ) );
			response.setEstado( ResponseEstado.OK );
		}
		catch (Exception e)
		{
			String codigoError = ResponseHelper.obtenerCodigoErrorPorFecha( apiProperties.getNombre() );
			response.setEstado( ResponseEstado.ERROR_APLICACION );
			response.setMensaje( "OcurriÃ³ un error al insertar area por especialidad." );
			response.setCodigoError( codigoError );
			LOG.error( codigoError, e );
		} 
		return response;
	}
	
	@RequestMapping(value = "/actualizarAreaxEspecialidad", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	@ApiOperation(value = "Actualizar un Area por Especialidad", notes = "Actualiza un Area por Especialidad", response = ActualizarAreaPorEspecialidadResponse.class)
	public ActualizarAreaPorEspecialidadResponse actualizarAreaPorEspecialidad(
			@RequestHeader("codUsuario") String codUsuario,
			@RequestHeader("idIPRESS") String idIPRESS,
			@RequestHeader("token") String token,
			@RequestBody ActualizarAreaPorEspecialidadRequest request)
	{
		ActualizarAreaPorEspecialidadResponse response = new ActualizarAreaPorEspecialidadResponse();

		try
		{
			response = areaEspecialidadService.actualizarAreaPorEspecialidad(RequestHelper
					.agregarHeaders(servletRequest, request));
		}
		catch (Exception e)
		{
			String codigoError = ResponseHelper
					.obtenerCodigoErrorPorFecha(apiProperties.getNombre());
			response.setEstado(ResponseEstado.ERROR_APLICACION);
			response.setMensaje("Error al actualizar el Area por Especialidad");
			response.setCodigoError(codigoError);
			LOG.error(codigoError, e);
		}
		return response;
	}
	
	@RequestMapping(value = "/eliminarAreaxEspecialidad", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	@ApiOperation(value = "Eliminar un Area por Especialidad", notes = "Elimina una Area por Especialidad", response = EliminarAreaPorEspecialidadResponse.class)
	public EliminarAreaPorEspecialidadResponse eliminarAreaPorEspecialidad(
			@RequestHeader("codUsuario") String codUsuario,
			@RequestHeader("idIPRESS") String idIPRESS,
			@RequestHeader("token") String token,
			@RequestParam("idArea") Integer idArea,
			@RequestParam("idEspecialidad") Integer idEspecialidad)
	{
		EliminarAreaPorEspecialidadResponse response = new EliminarAreaPorEspecialidadResponse();
		EliminarAreaPorEspecialidadRequest request = new EliminarAreaPorEspecialidadRequest();
		request.setIdArea(idArea);
		request.setIdEspecialidad(idEspecialidad);
		try
		{
			response = areaEspecialidadService.eliminarAreaPorEspecialidad(RequestHelper
					.agregarHeaders(servletRequest, request));
		}
		catch (Exception e)
		{
			String codigoError = ResponseHelper
					.obtenerCodigoErrorPorFecha(apiProperties.getNombre());
			response.setEstado(ResponseEstado.ERROR_APLICACION);
			response.setMensaje("Error al eliminar el Area por Especialidad");
			response.setCodigoError(codigoError);
			LOG.error(codigoError, e);
		}
		return response;
	}

}
