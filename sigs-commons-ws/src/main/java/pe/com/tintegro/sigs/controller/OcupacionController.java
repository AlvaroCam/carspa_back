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
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import pe.com.tintegro.sigs.constants.ResponseEstado;
import pe.com.tintegro.sigs.dto.request.ObtieneOcupacionRequest;
import pe.com.tintegro.sigs.dto.response.ObtieneOcupacionResponse;
import pe.com.tintegro.sigs.helpers.RequestHelper;
import pe.com.tintegro.sigs.helpers.ResponseHelper;
import pe.com.tintegro.sigs.properties.APIProperties;
import pe.com.tintegro.sigs.service.OcupacionService;

/**
 * @author FReyes
 *
 */
@RestController
@RequestMapping("/ocupaciones")
@Api(value = "Ocupacion")
public class OcupacionController 
{
	private static final Logger LOG = Logger.getLogger(OcupacionController.class);
	@Autowired
	private HttpServletRequest servletRequest;

	@Autowired
	private APIProperties apiProperties;

	@Autowired
	private OcupacionService ocupacionService;
	
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	@ApiOperation(value = "Obtener Ocupacion", notes = "Obtiene ocupacion seleccionada", response = ObtieneOcupacionResponse.class)
	public ObtieneOcupacionResponse obtenerOcupacion(
			@RequestHeader("codUsuario") String codUsuario,
			@RequestHeader("idIPRESS") String idIPRESS, 
			@RequestHeader("token") String token)
	{
		ObtieneOcupacionResponse response = new ObtieneOcupacionResponse();
		ObtieneOcupacionRequest request = new ObtieneOcupacionRequest();
		try
		{
			response = ocupacionService.obtenerOcupacion(RequestHelper.agregarHeaders(servletRequest, request));
			response.setEstado(ResponseEstado.OK);
			response.setMensaje("Ocupacion obtenidas correctamente");
		}
		catch(Exception e)
		{
			String mensajeError = "Ocurrió un error al obtener Ocupacion.";
			String codigoError = ResponseHelper.obtenerCodigoErrorPorFecha(apiProperties.getNombre());
			response.setEstado(ResponseEstado.ERROR_APLICACION);
			response.setCodigoError(codigoError);
			response.setMensaje(mensajeError);
			LOG.error(codigoError, e);	
		}
		return response;
	}
	
	@RequestMapping(value = "/descripcion",  method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	@ApiOperation(value = "Obtener Ocupacion", notes = "Obtiene ocupacion seleccionada por descripcion", response = ObtieneOcupacionResponse.class)
	public ObtieneOcupacionResponse obtenerOcupacionForActoMedico(
			@RequestHeader("codUsuario") String codUsuario,
			@RequestHeader("idIPRESS") String idIPRESS,
			@RequestHeader("token") String token,
			@RequestParam (value = "descripcion" , required = false) String descripcion)
	{
		ObtieneOcupacionResponse response = new ObtieneOcupacionResponse();
		ObtieneOcupacionRequest request = new ObtieneOcupacionRequest();
		request.setDescripcion(descripcion);
		try
		{
			response = ocupacionService.obtenerOcupacionOfDescripcion(RequestHelper.agregarHeaders(servletRequest, request));
			response.setEstado(ResponseEstado.OK);
			response.setMensaje("Ocupacion obtenidas correctamente");
		}
		catch(Exception e)
		{
			String mensajeError = "Ocurrió un error al obtener Ocupacion.";
			String codigoError = ResponseHelper.obtenerCodigoErrorPorFecha(apiProperties.getNombre());
			response.setEstado(ResponseEstado.ERROR_APLICACION);
			response.setCodigoError(codigoError);
			response.setMensaje(mensajeError);
			LOG.error(codigoError, e);	
		}
		return response;
	}
	
}
