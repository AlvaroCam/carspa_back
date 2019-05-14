package pe.com.tintegro.sigs.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import pe.com.tintegro.sigs.constants.ResponseEstado;
import pe.com.tintegro.sigs.dto.request.ObtieneAreasRequest;
import pe.com.tintegro.sigs.dto.response.HealtResponse;
import pe.com.tintegro.sigs.dto.response.ObtieneAreasResponse;
import pe.com.tintegro.sigs.dto.response.ResponseBase;
import pe.com.tintegro.sigs.helpers.RequestHelper;
import pe.com.tintegro.sigs.helpers.ResponseHelper;
import pe.com.tintegro.sigs.properties.APIProperties;
import pe.com.tintegro.sigs.service.AreaService;

@RequestMapping( "/health" )
@RestController
@Api( "Healt" )



public class HealthController {
private static final Logger LOG = Logger.getLogger( AreaController.class );
	
	@Autowired
	private HttpServletRequest servletRequest;
	
	@Autowired
	private APIProperties apiProperties;
	
	
	
	
	@RequestMapping( method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE )
	@ResponseStatus( value = HttpStatus.OK )
	@ApiOperation( value = "heartBeat", notes = "Reconocimiento de Eureka.")
	public HealtResponse obtenerAreas( )
	{
		HealtResponse response = new HealtResponse();
		try
		{			
			response.setStatus("UP");
		}
		catch (Exception e)
		{
			response.setStatus("fail");
		}
		
		return response;
	}

}
