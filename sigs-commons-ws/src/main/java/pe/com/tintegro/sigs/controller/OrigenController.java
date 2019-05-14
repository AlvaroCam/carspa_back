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
import pe.com.tintegro.sigs.dto.request.ObtieneOrigenesRequest;
import pe.com.tintegro.sigs.dto.response.ObtieneOrigenesResponse;
import pe.com.tintegro.sigs.helpers.RequestHelper;
import pe.com.tintegro.sigs.helpers.ResponseHelper;
import pe.com.tintegro.sigs.properties.APIProperties;
import pe.com.tintegro.sigs.service.OrigenService;

@RequestMapping( "/origenes" )
@RestController
@Api( "origenes" )
public class OrigenController 
{
	private static final Logger LOG = Logger.getLogger( OrigenController.class );
	
	@Autowired
	private HttpServletRequest servletRequest;
	
	@Autowired
	private APIProperties apiProperties;
	
	@Autowired
	private OrigenService origenService;
	
	@RequestMapping(method = RequestMethod.GET , produces = MediaType.APPLICATION_JSON_UTF8_VALUE )
	@ResponseStatus(value = HttpStatus.OK)
	@ApiOperation(value = "Obtener origenes", notes = "Obtiene los origenes.", response = ObtieneOrigenesResponse.class)
	public ObtieneOrigenesResponse obtenerOrigenes(@RequestHeader("idIPRESS") String idIPRESS,
												   @RequestHeader("codUsuario") String codUsuario,
												   @RequestHeader("token") String token,
												   @RequestParam(value = "idOrigen", required = false) Integer idOrigen) 
	{
		ObtieneOrigenesResponse response = new ObtieneOrigenesResponse();
		ObtieneOrigenesRequest request = new ObtieneOrigenesRequest();
		request.setIdOrigen(idOrigen);
		try 
		{
			response = origenService.obtenerOrigenes(RequestHelper.agregarHeaders(servletRequest, request));
		} catch (Exception e) 
		{
			String codigoError = ResponseHelper.obtenerCodigoErrorPorFecha( apiProperties.getNombre() );
			response.setEstado( ResponseEstado.OK ); 
			response.setMensaje( "Error al obtner los origenes" );
			response.setCodigoError( codigoError );
			LOG.error( codigoError, e );
		}
		return response;
	}
}