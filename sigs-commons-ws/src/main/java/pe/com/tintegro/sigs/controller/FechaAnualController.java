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
import pe.com.tintegro.sigs.dto.request.ObtieneFechaRequest;
import pe.com.tintegro.sigs.dto.response.ObtieneFechaResponse;
import pe.com.tintegro.sigs.helpers.RequestHelper;
import pe.com.tintegro.sigs.helpers.ResponseHelper;
import pe.com.tintegro.sigs.properties.APIProperties;
import pe.com.tintegro.sigs.service.FechaAnualService;

@RestController
@RequestMapping("/fechaAnual")
@Api("fechaAnual")
public class FechaAnualController
{
	private static final Logger LOG = Logger.getLogger(ExamenTipoController.class);
	@Autowired
	private FechaAnualService fechaAnualService;
	@Autowired
	private HttpServletRequest servletRequest;
	@Autowired
	private APIProperties apiProperties;
	

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	@ApiOperation(value = "Obtener fechas", notes = "Obtener años para combos de fecha", response = ObtieneFechaResponse.class)
	public ObtieneFechaResponse obtenerFechas(@RequestHeader("codUsuario") String codUsuario, @RequestHeader("idIPRESS") String idIPRESS, @RequestHeader("token") String token,
			@RequestParam(value = "inferiorFecha", required = false) Integer inferiorFecha)
	{
		ObtieneFechaResponse response = new ObtieneFechaResponse();
		ObtieneFechaRequest request = new ObtieneFechaRequest();
		request.setInferiorFecha(inferiorFecha);
		try
		{
			response = fechaAnualService.obtieneFecha(RequestHelper.agregarHeaders(servletRequest, request));
		}
		catch (Exception e)
		{
			String codigoError = ResponseHelper.obtenerCodigoErrorPorFecha(apiProperties.getNombre());
			response.setEstado(ResponseEstado.ERROR_APLICACION);
			response.setMensaje("Hubo un error al obtener los tipos de examenes");
			response.setCodigoError(codigoError);
			LOG.error(codigoError, e);
		}
		return response;
	}

}
