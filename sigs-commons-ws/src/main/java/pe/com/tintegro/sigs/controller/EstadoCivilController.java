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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import pe.com.tintegro.sigs.constants.ResponseEstado;
import pe.com.tintegro.sigs.dto.request.ObtieneEstadoCivilRequest;
import pe.com.tintegro.sigs.dto.response.ObtieneEstadoCivilResponse;
import pe.com.tintegro.sigs.dto.response.ObtieneSexoResponse;
import pe.com.tintegro.sigs.helpers.RequestHelper;
import pe.com.tintegro.sigs.helpers.ResponseHelper;
import pe.com.tintegro.sigs.properties.APIProperties;
import pe.com.tintegro.sigs.service.EstadoCivilService;

/**
 * @author Carlos
 *
 */
@RestController
@RequestMapping("/estadosCiviles")
@Api(value = "EstadoCivil")
public class EstadoCivilController
{
	private static final Logger LOG = Logger.getLogger(EstadoCivilController.class);
	@Autowired
	private HttpServletRequest servletRequest;

	@Autowired
	private APIProperties apiProperties;

	@Autowired
	private EstadoCivilService estadoCivilService;
	
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	@ApiOperation(value = "Obtener Estado Civil", notes = "Obtiene Estado civil", response = ObtieneSexoResponse.class)
	public ObtieneEstadoCivilResponse obtenerEstadoCivil(@RequestHeader("codUsuario") String codUsuario, @RequestHeader("idIPRESS") String idIPRESS, @RequestHeader("token") String token)
	{
		ObtieneEstadoCivilResponse response = new ObtieneEstadoCivilResponse();
		ObtieneEstadoCivilRequest request = new ObtieneEstadoCivilRequest();
		try
		{
			response = estadoCivilService.obtenerEstadoCivil(RequestHelper.agregarHeaders(servletRequest, request));
			response.setEstado(ResponseEstado.OK);
			response.setMensaje("Estado civil obtenido correctamente");
		}
		catch (Exception e)
		{
			String mensajeError = "Ocurrió un error al obtener estado civil.";
			String codigoError = ResponseHelper.obtenerCodigoErrorPorFecha(apiProperties.getNombre());
			response.setEstado(ResponseEstado.ERROR_APLICACION);
			response.setCodigoError(codigoError);
			response.setMensaje(mensajeError);
			LOG.error(codigoError, e);
		}
		return response;
	}

}
