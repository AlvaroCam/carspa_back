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
import pe.com.tintegro.sigs.dto.request.InsertarTurnoRequest;
import pe.com.tintegro.sigs.dto.request.ObtieneTurnoRequest;
import pe.com.tintegro.sigs.dto.request.ObtieneTurnosRequest;
import pe.com.tintegro.sigs.dto.response.InsertarTurnoResponse;
import pe.com.tintegro.sigs.dto.response.ObtieneTurnoResponse;
import pe.com.tintegro.sigs.dto.response.ObtieneTurnosResponse;
import pe.com.tintegro.sigs.helpers.RequestHelper;
import pe.com.tintegro.sigs.helpers.ResponseHelper;
import pe.com.tintegro.sigs.properties.APIProperties;
import pe.com.tintegro.sigs.service.TurnoService;

/**
 * @author daniel - 15 set. 2017
 *
 */
@RestController
@RequestMapping("/turnos")
@Api("Turno")
public class TurnoController
{
	private static final Logger LOG = Logger.getLogger(TurnoController.class);

	@Autowired
	private HttpServletRequest servletRequest;

	@Autowired
	private APIProperties apiProperties;
	
	@Autowired
	private TurnoService turnoService;

	@RequestMapping( method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE )
	@ResponseStatus( value = HttpStatus.OK )
	@ApiOperation( value = "Obtener turnos", notes = "Obtiene todos los turnos del sistema.", response = ObtieneTurnoResponse.class )
	public ObtieneTurnoResponse obtenerTurnos( 
						@RequestHeader( "codUsuario" ) String codUsuario, 
						@RequestHeader( "idIPRESS" ) String idIPRESS, 
						@RequestHeader( "token" ) String token,
						@RequestParam (  value = "idActividad", required = false ) Integer idActividad)
	{
		ObtieneTurnoRequest request = new ObtieneTurnoRequest();
		ObtieneTurnoResponse response = new ObtieneTurnoResponse();
		request.setIdActividad(idActividad);
		
		try
		{
			response = turnoService.obtenerTurno( RequestHelper.agregarHeaders( servletRequest, request ) );
			response.setEstado( ResponseEstado.OK );
			response.setMensaje( "Turnos obtenidos correctamente." );
		}
		catch (Exception e)
		{
			String codigoError = ResponseHelper.obtenerCodigoErrorPorFecha( apiProperties.getNombre() );
			response.setEstado( ResponseEstado.ERROR_APLICACION );
			response.setMensaje( "Ocurrió un error al obtener turnos." );
			response.setCodigoError( codigoError );
			LOG.error( codigoError, e );
		} 
		
		return response;
	}
	
	@RequestMapping( method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE )
	@ResponseStatus( value = HttpStatus.OK )
	@ApiOperation( value = "Obtener turnos", notes = "inserta turnos.", response = InsertarTurnoResponse.class )
	public InsertarTurnoResponse insertarTurno( 
						@RequestHeader( "codUsuario" ) String codUsuario, 
						@RequestHeader( "idIPRESS" ) String idIPRESS, 
						@RequestHeader( "token" ) String token,
						@RequestBody InsertarTurnoRequest request)
	{
		InsertarTurnoResponse response = new InsertarTurnoResponse();
		
		try
		{
			response = turnoService.insertarTurno( RequestHelper.agregarHeaders( servletRequest, request ) );
			response.setEstado( ResponseEstado.OK );
			response.setMensaje( "Turnos obtenidos correctamente." );
		}
		catch (Exception e)
		{
			String codigoError = ResponseHelper.obtenerCodigoErrorPorFecha( apiProperties.getNombre() );
			response.setEstado( ResponseEstado.ERROR_APLICACION );
			response.setMensaje( "Ocurrió un error al obtener turnos." );
			response.setCodigoError( codigoError );
			LOG.error( codigoError, e );
		} 
		
		return response;
	}
}
