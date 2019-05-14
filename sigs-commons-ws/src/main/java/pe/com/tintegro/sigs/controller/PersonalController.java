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
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import pe.com.tintegro.sigs.constants.ResponseEstado;
import pe.com.tintegro.sigs.dto.request.ObtienePersonalesRequest;
import pe.com.tintegro.sigs.dto.response.ObtienePersonalesResponse;
import pe.com.tintegro.sigs.helpers.RequestHelper;
import pe.com.tintegro.sigs.helpers.ResponseHelper;
import pe.com.tintegro.sigs.properties.APIProperties;
import pe.com.tintegro.sigs.service.PersonalService;

/**
 * @author daniel - 18 set. 2017
 *
 */
@RequestMapping("/areas")
@RestController
@Api( "Personal" )
public class PersonalController
{
	private static final Logger LOG = Logger.getLogger(PersonalController.class);

	@Autowired
	private HttpServletRequest servletRequest;

	@Autowired
	private APIProperties apiProperties;

	@Autowired
	private PersonalService personalService;
	
	@RequestMapping( value = "/{idArea}/especialidades/{idEspecialidad}/actividades/{idActividad}/subActividades/{idSubActividad}/personales", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE )
	@ResponseStatus( value = HttpStatus.OK )
	@ApiOperation( value = "Obtener personales.", notes = "Obtiene los personales de una IPRESS, dada su área, especialidad, actividad y subactividad.", response = ObtienePersonalesResponse.class )
	public ObtienePersonalesResponse obtenerPersonales( 
						@RequestHeader( "codUsuario" ) String codUsuario, 
						@RequestHeader( "idIPRESS" ) String idIPRESS, 
						@RequestHeader( "token" ) String token, 
						@PathVariable( "idArea" ) int idArea, 
						@PathVariable( "idEspecialidad" ) int idEspecialidad, 
						@PathVariable( "idActividad" ) int idActividad, 
						@PathVariable( "idSubActividad" ) int idSubActividad, 
						@RequestParam( value = "idPersonal", required = false ) String idPersonal )
	{
		ObtienePersonalesRequest request = new ObtienePersonalesRequest();
		request.setIdArea( idArea );
		request.setIdEspecialidad( idEspecialidad );
		request.setIdActividad( idActividad );
		request.setIdSubActividad( idSubActividad );
		request.setIdPersonal( idPersonal );
		
		ObtienePersonalesResponse response = new ObtienePersonalesResponse();
		
		try
		{
			response = personalService.obtenerPersonales( RequestHelper.agregarHeaders( servletRequest, request ) );
			response.setEstado( ResponseEstado.OK );
			response.setMensaje( "Personales obtenidos correctamente." );
		}
		catch (Exception e)
		{
			String codigoError = ResponseHelper.obtenerCodigoErrorPorFecha( apiProperties.getNombre() );
			response.setEstado( ResponseEstado.ERROR_APLICACION );
			response.setMensaje( "Ocurrió un error al obtener los profesionales." );
			response.setCodigoError( codigoError );
			LOG.error( codigoError, e );
		} 
		
		return response;
	}
}
