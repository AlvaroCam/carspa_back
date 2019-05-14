/**
 * 
 */
package pe.com.tintegro.sigs.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
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
import pe.com.tintegro.sigs.dto.request.EliminarEspecialidadJRequest;
import pe.com.tintegro.sigs.dto.request.InsertarEspecialidadJRequest;
import pe.com.tintegro.sigs.dto.request.ObtenerEspecialidadJRequest;
import pe.com.tintegro.sigs.dto.request.ObtieneEspecialidadRequest;
import pe.com.tintegro.sigs.dto.request.ObtieneEspecialidadesConsultaAmbulatoriaRequest;
import pe.com.tintegro.sigs.dto.request.ObtieneEspecialidadesRequest;
import pe.com.tintegro.sigs.dto.response.EliminarEspecialidadJResponse;
import pe.com.tintegro.sigs.dto.response.InsertarEspecialidadJResponse;
import pe.com.tintegro.sigs.dto.response.ObtenerEspecialidadJResponse;
import pe.com.tintegro.sigs.dto.response.ObtieneEspecialidadResponse;
import pe.com.tintegro.sigs.dto.response.ObtieneEspecialidadesConsultaAmbulatoriaResponse;
import pe.com.tintegro.sigs.dto.response.ObtieneEspecialidadesResponse;
import pe.com.tintegro.sigs.helpers.RequestHelper;
import pe.com.tintegro.sigs.helpers.ResponseHelper;
import pe.com.tintegro.sigs.properties.APIProperties;
import pe.com.tintegro.sigs.service.EspecialidadService;

/**
 * @author daniel - 12 set. 2017
 *
 */
@RequestMapping("/areas")
@RestController
@Api("Ã�rea")
public class EspecialidadController
{
	private static final Logger LOG = Logger.getLogger(EspecialidadController.class);
    
	@Autowired
	private HttpServletRequest servletRequest;
    
	@Autowired
	private APIProperties apiProperties;
    
	@Autowired
	private EspecialidadService especialidadService;
    
	@RequestMapping(value = "/{idArea}/especialidades", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	@ApiOperation(value = "Obtener especialidades", notes = "Obtiene las especialidades de un Ã¡rea.", response = ObtieneEspecialidadesResponse.class)
	public ObtieneEspecialidadesResponse obtenerEspecialidades( @RequestHeader("codUsuario") String codUsuario, 
																				   @RequestHeader("idIPRESS") String idIPRESS, 
																				   @RequestHeader("token") String token, 
																				   @PathVariable("idArea") Integer idArea )
	{
		ObtieneEspecialidadesRequest request = new ObtieneEspecialidadesRequest();
		request.setIdArea( idArea );
		
		ObtieneEspecialidadesResponse response = new ObtieneEspecialidadesResponse();

		try
		{
			response = especialidadService.obtenerEspecialidades(RequestHelper.agregarHeaders(servletRequest, request));
			response.setEstado(ResponseEstado.OK);
			response.setMensaje("Especialidades obtenidas correctamente.");
		}
		catch (Exception e)
		{
			String codigoError = ResponseHelper.obtenerCodigoErrorPorFecha(apiProperties.getNombre());
			response.setEstado(ResponseEstado.ERROR_APLICACION);
			response.setMensaje("OcurriÃ³ un error al obtener las especialidades.");
			response.setCodigoError(codigoError);
			LOG.error(codigoError, e);
		}

		return response;
	}
	
	@RequestMapping(value = "/{idArea}/especialidades/{idEspecialidad}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	@ApiOperation(value = "Obtener especialidad", notes = "Obtiene el detalle de la especialidad de un Ã¡rea, por su ID.", response = ObtieneEspecialidadResponse.class)
	public ObtieneEspecialidadResponse obtenerEspecialidad( @RequestHeader( "codUsuario" ) String codUsuario, 
																			  @RequestHeader( "idIPRESS" ) String idIPRESS, 
																			  @RequestHeader( "token" ) String token, 
																			  @PathVariable( "idArea" ) Integer idArea,
																			  @PathVariable( "idEspecialidad" ) Integer idEspecialidad )
	{
		ObtieneEspecialidadRequest request = new ObtieneEspecialidadRequest();
		ObtieneEspecialidadResponse response = new ObtieneEspecialidadResponse();
		
		request.setIdArea( idArea );
		request.setIdEspecialidad( idEspecialidad );
		
		try
		{
			response = especialidadService.obtenerEspecialidad( RequestHelper.agregarHeaders( servletRequest, request ) ) ;
		}
		catch ( Exception e )
		{
			String codigoError = ResponseHelper.obtenerCodigoErrorPorFecha(apiProperties.getNombre());
			response.setEstado( ResponseEstado.ERROR_APLICACION );
			response.setMensaje( "OcurriÃ³ un error al obtener la especialidad." );
			response.setCodigoError( codigoError );
			LOG.error( codigoError, e );
		}
		
		return response;
	}
	
	// INSERTAR
	@RequestMapping(value = "/insertarEspecialidad", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	@ApiOperation(value = "Registrar especialidad", notes = "Registra la especialidad.", response = InsertarEspecialidadJResponse.class)
	public InsertarEspecialidadJResponse insertaEspecialidad(
			@RequestHeader("codUsuario") String codUsuario,
			@RequestHeader("token") String token,
			@RequestBody InsertarEspecialidadJRequest request)
	{
		InsertarEspecialidadJResponse response = new InsertarEspecialidadJResponse();
		try {
			response = especialidadService.insertarEspecialidadJ(RequestHelper
					.agregarHeaders(servletRequest, request));
		} catch (Exception e) {
			String codigoError = ResponseHelper
					.obtenerCodigoErrorPorFecha(apiProperties.getNombre());
			response.setEstado(ResponseEstado.OK);
			response.setMensaje("Ocurrio un error al registrar la especialidad.");
			response.setCodigoError(codigoError);
			LOG.error(codigoError, e);
		}
		return response;
	}
	
	// Obtener
	@RequestMapping(value = "/obtenerEspecialidades", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	@ApiOperation(value = "Obtener especialidad", notes = "Obtiene las especialidades", response = ObtenerEspecialidadJResponse.class)
	public ObtenerEspecialidadJResponse obtenerEspecialidad2(
			@RequestHeader("codUsuario") String codUsuario,
			@RequestHeader("token") String token,
			String descripcion_especialidad,
			Integer numPagina,
			Integer numMostrarPagina
			) {
		ObtenerEspecialidadJRequest request = new ObtenerEspecialidadJRequest();
		ObtenerEspecialidadJResponse response = new ObtenerEspecialidadJResponse();
		
		 request.setDescripcion_especialidad(descripcion_especialidad);
		 request.setNumPagina(numPagina);
		 request.setNumMostrarPagina(numMostrarPagina);
		
		try {
			response = especialidadService.obtenerEspecialidadJ(RequestHelper.agregarHeaders(servletRequest, request));
		} catch (Exception e) {
			String codigoError = ResponseHelper.obtenerCodigoErrorPorFecha(apiProperties.getNombre());
			response.setEstado(ResponseEstado.OK);
			response.setMensaje("Ocurrio un error al obtener la especialidad.");
			response.setCodigoError(codigoError);
			LOG.error(codigoError, e);
		}

		return response;
	}
	
	//Eliminar
	@RequestMapping(value = "/eliminarEspecialidad", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	@ApiOperation(value = "Obtener especialidad", notes = "Elimina las especialidades", response = EliminarEspecialidadJResponse.class)
	public EliminarEspecialidadJResponse eliminarEspecialidad(
			@RequestHeader("codUsuario") String codUsuario,
			@RequestHeader("token") String token,
			Integer idEspecialidad){

		EliminarEspecialidadJRequest request = new EliminarEspecialidadJRequest();
		EliminarEspecialidadJResponse response = new EliminarEspecialidadJResponse();
		
			request.setIdEspecialidad(idEspecialidad);
			
		try{
			response = especialidadService.eliminarEspecialidadJ(RequestHelper.agregarHeaders(servletRequest, request));
				
		}catch (Exception e) {
			String codigoError = ResponseHelper.obtenerCodigoErrorPorFecha(apiProperties.getNombre());
			response.setEstado(ResponseEstado.OK);
			response.setMensaje("Ocurrio un error al obtener la especialidad.");
			response.setCodigoError(codigoError);
			LOG.error(codigoError, e);
		}
	
	return response;
	}	
	
	@RequestMapping(value = "/obtenerEspecialidadesConsultaAmbulatoria", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	@ApiOperation(value = "Registrar especialidad", notes = "Registra la especialidad.", response = ObtieneEspecialidadesConsultaAmbulatoriaResponse.class)
	public ObtieneEspecialidadesConsultaAmbulatoriaResponse obtenerEspecialidadesConsultaAmbulatoria(
			@RequestHeader("idIPRESS") String idIPRESS,
			@RequestHeader("codUsuario") String codUsuario,
			@RequestHeader("token") String token,
			@RequestParam( value = "idArea", required = false) Integer idArea)
	{
		ObtieneEspecialidadesConsultaAmbulatoriaResponse response = new ObtieneEspecialidadesConsultaAmbulatoriaResponse();
		ObtieneEspecialidadesConsultaAmbulatoriaRequest request = new ObtieneEspecialidadesConsultaAmbulatoriaRequest();
		
		request.setIdArea(idArea);
		
		try {
			response = especialidadService.obtenerEspecialidadesConsultaAmbulatoria(RequestHelper
					.agregarHeaders(servletRequest, request));
			response.setEstado(ResponseEstado.OK);
			response.setMensaje("Especialidades obtenidas correctamente.");
		} catch (Exception e) {
			String codigoError = ResponseHelper
					.obtenerCodigoErrorPorFecha(apiProperties.getNombre());
			response.setEstado(ResponseEstado.OK);
			response.setMensaje("Ocurrio un error al registrar la especialidad.");
			response.setCodigoError(codigoError);
			LOG.error(codigoError, e);
		}
		return response;
	}
}
