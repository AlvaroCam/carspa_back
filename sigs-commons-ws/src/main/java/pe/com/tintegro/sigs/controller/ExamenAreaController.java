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
import pe.com.tintegro.sigs.dto.request.ObtieneExamenAreasRequest;
import pe.com.tintegro.sigs.dto.response.ObtieneExamenAreasResponse;
import pe.com.tintegro.sigs.helpers.RequestHelper;
import pe.com.tintegro.sigs.helpers.ResponseHelper;
import pe.com.tintegro.sigs.properties.APIProperties;
import pe.com.tintegro.sigs.service.ExamenAreaService;

@RestController
@RequestMapping("/examenAreas")
@Api("examenArea")
public class ExamenAreaController 
{
	private static final Logger LOG = Logger.getLogger(ExamenAreaController.class); 
	@Autowired
	private ExamenAreaService examenAreaService;
	
	@Autowired
	private HttpServletRequest servletRequest;
	
	@Autowired
	private APIProperties apiProperties;
	
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	@ApiOperation(value = "Obtener areas examenes", notes = "Obtener areas de examenes", response = ObtieneExamenAreasResponse.class)
	public ObtieneExamenAreasResponse obtenerExamenTipos(@RequestHeader("codUsuario") String codUsuario,
													     @RequestHeader("idIPRESS") String idIPRESS, 
													     @RequestHeader("token") String token,
													     @RequestParam(value = "idExamenArea", required = false) Integer idExamenArea,
													     @RequestParam(value = "idExamenTipo", required = false) Integer idExamenTipo)
	{
		ObtieneExamenAreasResponse response = new ObtieneExamenAreasResponse();
		ObtieneExamenAreasRequest request = new ObtieneExamenAreasRequest();
		request.setIdExamenArea(idExamenArea);
		request.setIdExamenTipo(idExamenTipo);
		try {
			response = examenAreaService.obtenerExamenAreas(RequestHelper.agregarHeaders(servletRequest, request));
		} catch (Exception e) {
			String codigoError = ResponseHelper.obtenerCodigoErrorPorFecha(apiProperties.getNombre());
			response.setEstado(ResponseEstado.ERROR_APLICACION);
			response.setMensaje("Hubo un error al obtener las areas de examenes");
			response.setCodigoError(codigoError);
			LOG.error(codigoError, e);
		}	
		return response;
	}
	
}
