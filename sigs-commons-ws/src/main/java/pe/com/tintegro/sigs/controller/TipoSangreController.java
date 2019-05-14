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
import pe.com.tintegro.sigs.dto.request.ObtieneTipoSangreResquest;
import pe.com.tintegro.sigs.dto.response.ObtieneTipoSangreResponse;
import pe.com.tintegro.sigs.helpers.RequestHelper;
import pe.com.tintegro.sigs.helpers.ResponseHelper;
import pe.com.tintegro.sigs.properties.APIProperties;
import pe.com.tintegro.sigs.service.TipoSangreService;

@RestController
@RequestMapping("/tipoSangre")
@Api(value = "TipoSangre")
public class TipoSangreController {
	
	private static final Logger LOG = Logger.getLogger(OcupacionController.class);
	@Autowired
	private HttpServletRequest servletRequest;

	@Autowired
	private APIProperties apiProperties;

	
	@Autowired
	private TipoSangreService tipoSangreService;
	
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	@ApiOperation(value = "Obtener tipos de sangre", notes = "Obtiene tipos de sangre", response = ObtieneTipoSangreResponse.class)
	public ObtieneTipoSangreResponse obtenerTipoSangre(
			@RequestHeader("codUsuario") String codUsuario,
			@RequestHeader("idIPRESS") String idIPRESS,
			@RequestHeader("token") String token)
	{
		ObtieneTipoSangreResponse response = new ObtieneTipoSangreResponse();
		ObtieneTipoSangreResquest request = new ObtieneTipoSangreResquest();
		
		try
		{
			response = tipoSangreService.obtenerTipoSangre(RequestHelper.agregarHeaders(servletRequest, request));
			response.setEstado(ResponseEstado.OK);
			response.setMensaje("Tipos de sangre obtenidos correctamente");
		}
		catch(Exception e)
		{
			String mensajeError = "Ocurrió un error al obtener los tipos de sangre.";
			String codigoError = ResponseHelper.obtenerCodigoErrorPorFecha(apiProperties.getNombre());
			response.setEstado(ResponseEstado.ERROR_APLICACION);
			response.setCodigoError(codigoError);
			response.setMensaje(mensajeError);
			LOG.error(codigoError, e);	
		}
		return response;
	}
	

}
