/**
 * 
 */
package pe.com.tintegro.sigs.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import pe.com.tintegro.sigs.constants.ResponseEstado;
import pe.com.tintegro.sigs.dto.request.ObtieneSexoRequest;
import pe.com.tintegro.sigs.dto.response.ObtieneSexoResponse;
import pe.com.tintegro.sigs.helpers.RequestHelper;
import pe.com.tintegro.sigs.helpers.ResponseHelper;
import pe.com.tintegro.sigs.properties.APIProperties;
import pe.com.tintegro.sigs.service.SexoService;

/**
 * @author Carlos
 *
 */
@RestController
@RequestMapping("/sexos")
@Api(value = "Sexo")
public class SexoController
{
	private static final Logger LOG = Logger.getLogger(SexoController.class);
	@Autowired
	private HttpServletRequest servletRequest;

	@Autowired
	private APIProperties apiProperties;

	@Autowired
	private SexoService sexoService;

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	@ApiOperation(value = "Obtener Sexo", notes = "Obtiene sexo seleccionado", response = ObtieneSexoResponse.class)
	public ObtieneSexoResponse obtenerSexo(@RequestHeader("codUsuario") String codUsuario,
			@RequestHeader("idIPRESS") String idIPRESS, @RequestHeader("token") String token)
	{
		ObtieneSexoResponse response = new ObtieneSexoResponse();
		ObtieneSexoRequest request = new ObtieneSexoRequest();
		try
		{
			response = sexoService.obtenerSexo(RequestHelper.agregarHeaders(servletRequest, request));
			response.setEstado(ResponseEstado.OK);
			response.setMensaje("Sexo obtenidos correctamente");
		}
		catch (Exception e)
		{
			String mensajeError = "Ocurrió un error al obtener Sexo.";
			String codigoError = ResponseHelper.obtenerCodigoErrorPorFecha(apiProperties.getNombre());
			response.setEstado(ResponseEstado.ERROR_APLICACION);
			response.setCodigoError(codigoError);
			response.setMensaje(mensajeError);
			LOG.error(codigoError, e);
		}
		return response;
	}
}
