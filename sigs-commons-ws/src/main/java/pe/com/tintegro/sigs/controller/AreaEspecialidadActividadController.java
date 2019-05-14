package pe.com.tintegro.sigs.controller;

import javax.servlet.http.HttpServletRequest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import pe.com.tintegro.sigs.constants.ResponseEstado;
import pe.com.tintegro.sigs.dto.request.ActualizarAreaEspecialidadActividadRequest;
import pe.com.tintegro.sigs.dto.request.EliminarAreaEspecialidadActividadRequest;
import pe.com.tintegro.sigs.dto.request.InsertarAreaEspecialidadActividadRequest;
import pe.com.tintegro.sigs.dto.request.ObtenerAreaEspecialidadActividadRequest;
import pe.com.tintegro.sigs.dto.response.ActualizarAreaEspecialidadActividadResponse;
import pe.com.tintegro.sigs.dto.response.EliminarAreaEspecialidadActividadResponse;
import pe.com.tintegro.sigs.dto.response.InsertarAreaEspecialidadActividadResponse;
import pe.com.tintegro.sigs.dto.response.ObtenerAreaEspecialidadActividadResponse;
import pe.com.tintegro.sigs.helpers.RequestHelper;
import pe.com.tintegro.sigs.helpers.ResponseHelper;
import pe.com.tintegro.sigs.properties.APIProperties;
import pe.com.tintegro.sigs.service.AreaEspecialidadActividadService;

@RequestMapping("/areaEspecialidadActividad")
@RestController
@Api("Ã?reaEspecialidadActividad")
public class AreaEspecialidadActividadController {
	
	private static final Logger LOG = Logger.getLogger(AreaEspecialidadActividadController.class);
	
	@Autowired
	private HttpServletRequest servletRequest;
	
	@Autowired
	private APIProperties apiProperties;
	
	@Autowired
	private AreaEspecialidadActividadService areaEspecialidadActividadService;
	
	@RequestMapping(value = "/obtenerAreaEspecialidadActividad", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	@ApiOperation(value = "Obtener AreaxEspxAct", notes = "Obtiene las Areas por Especialidad por Actividad", response = ObtenerAreaEspecialidadActividadResponse.class)
	public ObtenerAreaEspecialidadActividadResponse obtenerAreaEspecialidadActividad(
			@RequestHeader("codUsuario") String codUsuario,
			@RequestHeader("idIPRESS") String idIPRESS,
			@RequestHeader("token") String token,
			Integer idArea,
			Integer idEspecialidad,
			Integer idActividad,
			Integer nuPagina,
			Integer nuRegiMostrar) {
		ObtenerAreaEspecialidadActividadResponse response = new ObtenerAreaEspecialidadActividadResponse();
		ObtenerAreaEspecialidadActividadRequest request = new ObtenerAreaEspecialidadActividadRequest();
		request.setIdArea(idArea);
		request.setIdEspecialidad(idEspecialidad);
		request.setIdActividad(idActividad);
		request.setNuPagina(nuPagina);
		request.setNuRegiMostrar(nuRegiMostrar);
		try {
			response = areaEspecialidadActividadService.obtenerAreaEspecialidadActividadResponse(RequestHelper
					.agregarHeaders(servletRequest, request));
		} catch (Exception e) {
			String codigoError = ResponseHelper
					.obtenerCodigoErrorPorFecha(apiProperties.getNombre());

			response.setEstado(ResponseEstado.ERROR_APLICACION);
			response.setMensaje("Error al obtener la lista de Actividad de Especialidad de Area");
			response.setCodigoError(codigoError);
			LOG.error(codigoError, e);
		}
		return response;
	}
	
	@RequestMapping(value = "/insertarAreaEspecialidadActividad", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	@ApiOperation(value = "Insertar Nuevo Area Especialidad Actividad", notes = "Inserta una nueva relacion de Area Especialidad y Actividad", response = InsertarAreaEspecialidadActividadResponse.class)
	public InsertarAreaEspecialidadActividadResponse insertarAreaEspecialidadActividad(
			@RequestHeader("codUsuario") String codUsuario,
			@RequestHeader("idIPRESS") String idIPRESS,
			@RequestHeader("token") String token,
			@RequestBody InsertarAreaEspecialidadActividadRequest request) {
		InsertarAreaEspecialidadActividadResponse response = new InsertarAreaEspecialidadActividadResponse();
		try {
			response = areaEspecialidadActividadService.insertarAreaEspecialidadActividadResponse(RequestHelper
					.agregarHeaders(servletRequest, request));
		} catch (Exception e) {
			String codigoError = ResponseHelper
					.obtenerCodigoErrorPorFecha(apiProperties.getNombre());

			response.setEstado(ResponseEstado.ERROR_APLICACION);
			response.setMensaje("Error al insertar el Actividad de Especialidad de Area");
			response.setCodigoError(codigoError);
			LOG.error(codigoError, e);
		}
		return response;
	}
	
	@RequestMapping(value = "/actualizarAreaEspecialidadActividad", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	@ApiOperation(value = "Actualizar una Area Especialidad Actividad", notes = "Actualiza una nueva relacion de Area Especialidad y Actividad", response = ActualizarAreaEspecialidadActividadResponse.class)
	public ActualizarAreaEspecialidadActividadResponse actualizarAreaEspecialidadActividad(
			@RequestHeader("codUsuario") String codUsuario,
			@RequestHeader("idIPRESS") String idIPRESS,
			@RequestHeader("token") String token,
			@RequestBody ActualizarAreaEspecialidadActividadRequest request) {
		ActualizarAreaEspecialidadActividadResponse response = new ActualizarAreaEspecialidadActividadResponse();
		try {
			response = areaEspecialidadActividadService.actualizarAreaEspecialidadActividadResponse(RequestHelper.agregarHeaders(servletRequest, request));
		} 
		catch (Exception e) {
			String codigoError = ResponseHelper.obtenerCodigoErrorPorFecha(apiProperties.getNombre());
			response.setEstado(ResponseEstado.ERROR_APLICACION);
			response.setMensaje("Error al editar el Actividad de Especialidad de Area");
			response.setCodigoError(codigoError);
			LOG.error(codigoError, e);
		}
		return response;
	}
	
	@RequestMapping(value = "/eliminarAreaEspecialidadActividad", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	@ApiOperation(value = "Eliminar una Area Especialidad Actividad", notes = "Elimina una nueva relacion de Area Especialidad y Actividad", response = EliminarAreaEspecialidadActividadResponse.class)
	public EliminarAreaEspecialidadActividadResponse eliminarAreaEspecialidadActividad(
			@RequestHeader("codUsuario") String codUsuario,
			@RequestHeader("idIPRESS") String idIPRESS,
			@RequestHeader("token") String token,
			@RequestParam("idArea")Integer idArea,
			@RequestParam("idEspecialidad")Integer idEspecialidad,
			@RequestParam("idActividad")Integer idActividad) {
		EliminarAreaEspecialidadActividadResponse response = new EliminarAreaEspecialidadActividadResponse();
		EliminarAreaEspecialidadActividadRequest request = new EliminarAreaEspecialidadActividadRequest();
		request.setIdArea(idArea);
		request.setIdEspecialidad(idEspecialidad);
		request.setIdActividad(idActividad);
		try {
			response = areaEspecialidadActividadService.eliminarAreaEspecialidadActividadResponse(RequestHelper
					.agregarHeaders(servletRequest, request));
		} catch (Exception e) {
			String codigoError = ResponseHelper
					.obtenerCodigoErrorPorFecha(apiProperties.getNombre());

			response.setEstado(ResponseEstado.ERROR_APLICACION);
			response.setMensaje("Error al eliminar el Actividad de Especialidad de Area");
			response.setCodigoError(codigoError);
			LOG.error(codigoError, e);
		}
		return response;
	}

}
