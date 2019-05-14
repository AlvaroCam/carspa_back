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
import pe.com.tintegro.sigs.dto.request.ObtieneUbigeoRequest;
import pe.com.tintegro.sigs.dto.response.ObtieneUbigeoResponse;
import pe.com.tintegro.sigs.helpers.RequestHelper;
import pe.com.tintegro.sigs.helpers.ResponseHelper;
import pe.com.tintegro.sigs.properties.APIProperties;
import pe.com.tintegro.sigs.service.UbigeoService;

/**
 * @author Carlos
 *
 */

@RestController
@RequestMapping("/ubigeos")
@Api(value = "Ubigeos")
public class UbigeoController
{
	private static final Logger LOG = Logger.getLogger(UbigeoController.class);

	@Autowired
	private HttpServletRequest servletRequest;

	@Autowired
	private APIProperties apiProperties;

	@Autowired
	private UbigeoService ubigeoService;

	@RequestMapping( method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	@ApiOperation(value = "Obtener ubigeo", notes = "Obtiene codigo departamento y cogigo provincia", response = ObtieneUbigeoResponse.class)
	public ObtieneUbigeoResponse obtenerUbigeo(@RequestParam(value = "codDepartamento", defaultValue = "0", required = false) String codDepartamento,
			@RequestParam(value = "codProvincia", defaultValue = "0", required = false) String codProvincia, @RequestHeader("codUsuario") String codUsuario, 
			@RequestHeader("idIPRESS") String idIPRESS,@RequestHeader("token")String token)
	{
		ObtieneUbigeoRequest request = new ObtieneUbigeoRequest();
		request.setCodDepartamento(codDepartamento);
		request.setCodProvincia(codProvincia);

		ObtieneUbigeoResponse response = new ObtieneUbigeoResponse();

		try
		{
			response = ubigeoService.obtenerUbigeo(RequestHelper.agregarHeaders(servletRequest, request));
			response.setEstado(ResponseEstado.OK);
			response.setMensaje("Ubigeos obtenidos correctamente");
		}
		catch (Exception e)
		{
			String mensajeError = "Ocurrió un error al obtener codigo ubigeo.";
			String codigoError = ResponseHelper.obtenerCodigoErrorPorFecha(apiProperties.getNombre());
			response.setEstado(ResponseEstado.ERROR_APLICACION);
			response.setCodigoError(codigoError);
			response.setMensaje(mensajeError);
			LOG.error(codigoError, e);
		}

		return response;
	}
}
