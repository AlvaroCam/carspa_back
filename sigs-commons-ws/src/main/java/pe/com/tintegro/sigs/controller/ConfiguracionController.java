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
import pe.com.tintegro.sigs.dto.request.ObtieneConfiguracionRequest;
import pe.com.tintegro.sigs.dto.response.ObtieneConfiguracionResponse;
import pe.com.tintegro.sigs.entidad.Configuracion;
import pe.com.tintegro.sigs.helpers.RequestHelper;
import pe.com.tintegro.sigs.helpers.ResponseHelper;
import pe.com.tintegro.sigs.properties.APIProperties;
import pe.com.tintegro.sigs.service.ConfiguracionService;

/**
 * @author Aldo Huamán
 *
 * 19 dic. 2017
 */

@RestController
@RequestMapping("/configuraciones")
@Api("configuraciones")
public class ConfiguracionController
{
private static final Logger LOG = Logger.getLogger( ConfiguracionController.class );
	
	@Autowired
	private HttpServletRequest servletRequest;
	
	@Autowired
	private APIProperties apiProperties;
	
	@Autowired
	private ConfiguracionService configuracionService;
	
	@RequestMapping( method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE )
	@ResponseStatus( value = HttpStatus.OK )
	@ApiOperation( value = "Obtener valor de configuración", notes = "Obtiene el valor de configuracion según su id", response = ObtieneConfiguracionResponse.class )
	public ObtieneConfiguracionResponse obtenerConfiguracion(@RequestHeader( "codUsuario" ) String codUsuario, 
																				@RequestHeader( "idIPRESS" ) String idIPRESS, 
																				@RequestHeader( "token" ) String token,
																				@RequestParam("idConfiguracion") int idConfiguracion)
	{
		ObtieneConfiguracionResponse response = new ObtieneConfiguracionResponse();
		ObtieneConfiguracionRequest request = new ObtieneConfiguracionRequest();
		request.setIdConfiguracion(idConfiguracion);
		try
		{
			response = configuracionService.obtenerConfiguracion(RequestHelper.agregarHeaders(servletRequest, request));
		} catch (Exception e)
		{
			String codigoError = ResponseHelper.obtenerCodigoErrorPorFecha( apiProperties.getNombre() );
			response.setMensaje( "Error al obtener el valor de configuración" );
			response.setCodigoError( codigoError );
			LOG.error( codigoError, e );
		}
		return response;
	}
}

