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
import pe.com.tintegro.sigs.dto.request.ObtenerComboIpressByUsuarioRequest;
import pe.com.tintegro.sigs.dto.response.ObtenerComboIpressByUsuarioResponse;
import pe.com.tintegro.sigs.helpers.RequestHelper;
import pe.com.tintegro.sigs.helpers.ResponseHelper;
import pe.com.tintegro.sigs.properties.APIProperties;
import pe.com.tintegro.sigs.service.IpressService;

@RestController
@RequestMapping("/ipress")
@Api("ipress")
public class IpressController {
	private static final Logger LOG = Logger.getLogger(IpressController.class);

	@Autowired
	private IpressService ipressService;

	@Autowired
	private HttpServletRequest servletRequest;

	@Autowired
	private APIProperties apiProperties;
	
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	@ApiOperation(value = "Obtener ipress", notes = "Obtiene todos las ipress existentes por usuario.", response = ObtenerComboIpressByUsuarioResponse.class)
	public ObtenerComboIpressByUsuarioResponse obtenerUsuario(
			@RequestHeader("codUsuario") String codUsuario) {

		ObtenerComboIpressByUsuarioRequest request = new ObtenerComboIpressByUsuarioRequest();
		ObtenerComboIpressByUsuarioResponse response = new ObtenerComboIpressByUsuarioResponse();
		
		try {
			response = ipressService.obtenerIpress(RequestHelper
					.agregarHeaders(servletRequest, request));
			response.setEstado(ResponseEstado.OK);
			response.setMensaje("Lista de ipress obtenida correctamente.");
		} catch (Exception e) {
			String codigoError = ResponseHelper
					.obtenerCodigoErrorPorFecha(apiProperties.getNombre());
			response.setEstado(ResponseEstado.ERROR_APLICACION);
			response.setMensaje("Ocurrió un error al obtener las ipress.");
			response.setCodigoError(codigoError);
			LOG.error(codigoError, e);
		}

		return response;

	}
}
