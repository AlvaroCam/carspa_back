package pe.com.tintegro.sigs.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import pe.com.tintegro.sigs.constants.ResponseEstado;
import pe.com.tintegro.sigs.dto.request.EliminarAreaEspecialidadActividadGrupoOcupacionalJRequest;
import pe.com.tintegro.sigs.dto.request.InsertarAreaEspecialidadActividadGrupoOcupacionalJRequest;
import pe.com.tintegro.sigs.dto.request.ObtenerAreaEspecialidadActividadGrupoOcupacionalJRequest;
import pe.com.tintegro.sigs.dto.response.EliminarAreaEspecialidadActividadGrupoOcupacionalJResponse;
import pe.com.tintegro.sigs.dto.response.InsertarAreaEspecialidadActividadGrupoOcupacionalJResponse;
import pe.com.tintegro.sigs.dto.response.ObtenerAreaEspecialidadActividadGrupoOcupacionalJResponse;
import pe.com.tintegro.sigs.helpers.RequestHelper;
import pe.com.tintegro.sigs.helpers.ResponseHelper;
import pe.com.tintegro.sigs.properties.APIProperties;
import pe.com.tintegro.sigs.service.AreaEspecialidadActividadGrupoOcupacionalService;

@RequestMapping("/areaEspecialidadActividadGrupoOcupacional")
@RestController
@Api("AreaEspecialidadActividadGrupoOcupacional")
public class AreaEspecialidadActividadGrupoOcupacionalController {

	private static final Logger LOG = Logger
			.getLogger(EstadoCivilController.class);

	@Autowired
	private HttpServletRequest servletRequest;

	@Autowired
	private APIProperties apiProperties;

	@Autowired
	private AreaEspecialidadActividadGrupoOcupacionalService areaEspecialidadActividadGrupoOcupacionalService;

	@RequestMapping(value = "/insertar_Area_Actividad_Especialidad_GrupoOcupacional", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	@ApiOperation(value = "Registrar area especialidad actividad grupo ocupacional", notes = "Registrar area especialidad actividad grupo ocupacional", response = InsertarAreaEspecialidadActividadGrupoOcupacionalJResponse.class)
	public InsertarAreaEspecialidadActividadGrupoOcupacionalJResponse insertarArea(
			@RequestHeader("codUsuario") String codUsuario,
			@RequestHeader("idIPRESS") String idIPRESS,
			@RequestHeader("token") String token,
			@RequestBody InsertarAreaEspecialidadActividadGrupoOcupacionalJRequest request) {
		InsertarAreaEspecialidadActividadGrupoOcupacionalJResponse response = new InsertarAreaEspecialidadActividadGrupoOcupacionalJResponse();
		try {
			response = areaEspecialidadActividadGrupoOcupacionalService
					.insertarAreaEspecialidadActividadGrupoOcupacionalJ(RequestHelper
							.agregarHeaders(servletRequest, request));
		} catch (Exception e) {
			String codigoError = ResponseHelper
					.obtenerCodigoErrorPorFecha(apiProperties.getNombre());
			response.setEstado(ResponseEstado.ERROR_APLICACION);
			response.setMensaje("Ocurrio un error al registrar");
			response.setCodigoError(codigoError);
			LOG.error(codigoError, e);
		}
		return response;
	}

	@RequestMapping(value = "/eliminar_Area_Actividad_Especialidad_GrupoOcupacional", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	@ApiOperation(value = "Eliminar area especialidad actividad grupo ocupacional", notes = "Elimina Eliminar area especialidad actividad grupo ocupacional", response = EliminarAreaEspecialidadActividadGrupoOcupacionalJResponse.class)
	public EliminarAreaEspecialidadActividadGrupoOcupacionalJResponse eliminarArea(
			@RequestHeader("idIPRESS") String idIPRESS,
			@RequestHeader("token") String token, Integer idArea,
			Integer idEspecialidad, Integer idActividad,
			Integer idGrupoOcupacional,
			EliminarAreaEspecialidadActividadGrupoOcupacionalJRequest request) {
		EliminarAreaEspecialidadActividadGrupoOcupacionalJResponse response = new EliminarAreaEspecialidadActividadGrupoOcupacionalJResponse();
		try {
			request.setIdArea(idArea);
			request.setIdEspecialidad(idEspecialidad);
			request.setIdActividad(idActividad);
			request.setIdGrupoOcupacional(idGrupoOcupacional);
			response = areaEspecialidadActividadGrupoOcupacionalService
					.eliminarAreaEspecialidadActividadaGrupoOcupacionalJ(RequestHelper
							.agregarHeaders(servletRequest, request));
			response.setEstado(ResponseEstado.OK);
			response.setMensaje("Eliminacion completado");
		} catch (Exception e) {
			String codigoError = ResponseHelper
					.obtenerCodigoErrorPorFecha(apiProperties.getNombre());
			response.setEstado(ResponseEstado.ERROR_APLICACION);
			response.setMensaje("Ocurrio un error al eliminar");
			response.setCodigoError(codigoError);
			LOG.error(codigoError, e);
		}
		return response;
	}

	@RequestMapping(value = "/obtenerAreaXEspecialidadXActividadXGrupoOcupacional", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	@ApiOperation(value = "Obtener Areas por Especialidad por Actividad por Grupo Ocupacional", notes = "Obtiene todas las Areas por Especialidad por Actividad por Grupo Ocupacional", response = ObtenerAreaEspecialidadActividadGrupoOcupacionalJResponse.class)
	public ObtenerAreaEspecialidadActividadGrupoOcupacionalJResponse obtenerAreaEspecialidadActividadGrupoOcupacional(
			@RequestHeader("codUsuario") String codUsuario,
			@RequestHeader("token") String token,
			@RequestHeader("idIPRESS") String idIPRESS, Integer idArea,
			Integer idEspecialidad, Integer idActividad,
			Integer idGrupoOcupacional,
			@RequestParam("nuPagina") Integer nuPagina,
			@RequestParam("nuRegisMostrar") Integer nuRegisMostrar) {
		ObtenerAreaEspecialidadActividadGrupoOcupacionalJResponse response = new ObtenerAreaEspecialidadActividadGrupoOcupacionalJResponse();
		ObtenerAreaEspecialidadActividadGrupoOcupacionalJRequest request = new ObtenerAreaEspecialidadActividadGrupoOcupacionalJRequest();

		request.setIdArea(idArea);
		request.setIdEspecialidad(idEspecialidad);
		request.setIdActividad(idActividad);
		request.setIdGrupoOcupacional(idGrupoOcupacional);
		request.setNuPagina(nuPagina);
		request.setNuRegisMostrar(nuRegisMostrar);

		try {
			response = areaEspecialidadActividadGrupoOcupacionalService
					.obtenerAreaEspecialidadActividadGrupoOcupacionalJ(RequestHelper
							.agregarHeaders(servletRequest, request));
		} catch (Exception e) {
			String codigoError = ResponseHelper
					.obtenerCodigoErrorPorFecha(apiProperties.getNombre());
			response.setEstado(ResponseEstado.ERROR_APLICACION);
			response.setMensaje("Error al obtener el Area por Especialidad por Actividad por Grupo Ocupacional");
			response.setCodigoError(codigoError);
			LOG.error(codigoError, e);
		}
		return response;
	}

}
