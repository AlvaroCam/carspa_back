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
import pe.com.tintegro.sigs.dto.request.ObtenerComboDestinosAtencionRequest;
import pe.com.tintegro.sigs.dto.request.ObtieneSexoRequest;
import pe.com.tintegro.sigs.dto.response.ObtenerComboDestinosAtencionResponse;
import pe.com.tintegro.sigs.dto.response.ObtieneSexoResponse;
import pe.com.tintegro.sigs.helpers.RequestHelper;
import pe.com.tintegro.sigs.helpers.ResponseHelper;
import pe.com.tintegro.sigs.properties.APIProperties;
import pe.com.tintegro.sigs.service.DestinosAtencionService;
import pe.com.tintegro.sigs.service.SexoService;

@RestController
@RequestMapping("/destinosAtencion")
@Api(value = "DestinosAtencion")
public class DestinosAtencionController {

	private static final Logger LOG = Logger.getLogger(SexoController.class);
	@Autowired
	private HttpServletRequest servletRequest;

	@Autowired
	private APIProperties apiProperties;

	@Autowired
	private DestinosAtencionService destinosAtencionService;
	
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	@ApiOperation(value = "Obtener Destinos Atencion", notes = "Obtiene destinos Atencion", response = ObtenerComboDestinosAtencionResponse.class)
	public ObtenerComboDestinosAtencionResponse obtenerDestinos(
							@RequestHeader("codUsuario") String codUsuario,
							@RequestHeader("idIPRESS") String idIPRESS, 
							@RequestHeader("token") String token)
	{
		ObtenerComboDestinosAtencionResponse response = new ObtenerComboDestinosAtencionResponse();
		ObtenerComboDestinosAtencionRequest request = new ObtenerComboDestinosAtencionRequest();
		try
		{
			response = destinosAtencionService.obtenerDestinos(RequestHelper.agregarHeaders(servletRequest, request));
			response.setEstado(ResponseEstado.OK);
			response.setMensaje("Destinos Atencion obtenidos correctamente");
		}
		catch (Exception e)
		{
			String mensajeError = "Ocurri� un error al obtener Destinos Atencion.";
			String codigoError = ResponseHelper.obtenerCodigoErrorPorFecha(apiProperties.getNombre());
			response.setEstado(ResponseEstado.ERROR_APLICACION);
			response.setCodigoError(codigoError);
			response.setMensaje(mensajeError);
			LOG.error(codigoError, e);
		}
		return response;
	}
	
	
}
