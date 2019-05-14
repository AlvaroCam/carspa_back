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
import pe.com.tintegro.sigs.dto.request.ListarCptEspecialidadRequest;
import pe.com.tintegro.sigs.dto.response.ListarCptEspecialidadResponse;
import pe.com.tintegro.sigs.helpers.RequestHelper;
import pe.com.tintegro.sigs.helpers.ResponseHelper;
import pe.com.tintegro.sigs.properties.APIProperties;
import pe.com.tintegro.sigs.service.CptEspecialidadService;

@RestController
@RequestMapping("/cptEspecialidades")
@Api(value = "cptEspecialidad")
public class CptEspecialidadController {
	private static final Logger LOG = Logger.getLogger(CptEspecialidadController.class);

	@Autowired
	private HttpServletRequest servletRequest;

	@Autowired
	private APIProperties apiProperties;

	@Autowired
	private CptEspecialidadService cptEspecialidadService;

	@RequestMapping(value = "/obtener",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	@ApiOperation(value = "Listar CPT Especialidad", notes = "Lista CPT - Especialidad.", response = ListarCptEspecialidadResponse.class)
	public ListarCptEspecialidadResponse listarCptEspecialidadResponse(
			@RequestHeader("codUsuario") String codUsuario,
			@RequestHeader("idIPRESS") String idIPRESS, 
			@RequestHeader("token") String token,
			@RequestParam(value = "idEspecialidad", required = false) Integer idEspecialidad,
			@RequestParam(value = "idCpt", required = false) Integer idCpt,
			@RequestParam(value = "nuPagina", required = false) Integer nuPagina,
			@RequestParam(value = "nuRegisMostrar", required = false) Integer nuRegisMostrar)
	{
		ListarCptEspecialidadRequest request = new ListarCptEspecialidadRequest();
		ListarCptEspecialidadResponse response = new ListarCptEspecialidadResponse();
		request.setIdEspecialidad(idEspecialidad);
		request.setIdCpt(idCpt);
		request.setIdIPRESS(idIPRESS);
		request.setNuPagina(nuPagina);
		request.setNuRegisMostrar(nuRegisMostrar);

		try
		{
			response = cptEspecialidadService.listarCptEspecialidadResponse(RequestHelper.agregarHeaders(servletRequest, request));
			response.setEstado( ResponseEstado.OK );
			response.setMensaje( "Obtenidos correctamente." );
		}
		catch (Exception e)
		{
			String mensajeError = "Ocurrio un error al listar cpt - especialidades.";
			String codigoError = ResponseHelper.obtenerCodigoErrorPorFecha(apiProperties.getNombre());
			response.setEstado(ResponseEstado.ERROR_APLICACION);
			response.setCodigoError(codigoError);
			response.setMensaje(mensajeError);
			LOG.error(codigoError, e);
		}
		return response;
	}
}
