/**
 * 
 */
package pe.com.tintegro.sigs.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import pe.com.tintegro.sigs.constants.ResponseEstado;
import pe.com.tintegro.sigs.dto.request.ActualizarActividadRequest;
import pe.com.tintegro.sigs.dto.request.EliminarActividadRequest;
import pe.com.tintegro.sigs.dto.request.EliminarSubActividadRequest;
import pe.com.tintegro.sigs.dto.request.InsertarActividadRequest;
import pe.com.tintegro.sigs.dto.request.InsertarSubActvidadesRequest;
import pe.com.tintegro.sigs.dto.request.ObtenerActividadDescripcionRequest;
import pe.com.tintegro.sigs.dto.request.ObtenerActividadesConsultaAmbulatoriaRequest;
import pe.com.tintegro.sigs.dto.request.ObtenerSubActividadesRequest;
import pe.com.tintegro.sigs.dto.request.ObtieneActividadRequest;
import pe.com.tintegro.sigs.dto.request.ObtieneActividadesRequest;
import pe.com.tintegro.sigs.dto.request.ObtieneSubActividadRequest;
import pe.com.tintegro.sigs.dto.request.ObtieneSubActividadesRequest;
import pe.com.tintegro.sigs.dto.response.ActualizarActividadResponse;
import pe.com.tintegro.sigs.dto.response.EliminarActividadResponse;
import pe.com.tintegro.sigs.dto.response.EliminarSubActividadResponse;
import pe.com.tintegro.sigs.dto.response.InsertarActividadResponse;
import pe.com.tintegro.sigs.dto.response.InsertarSubActividadesResponse;
import pe.com.tintegro.sigs.dto.response.ObtenerActividadDescripcionResponse;
import pe.com.tintegro.sigs.dto.response.ObtenerActividadesConsultaAmbulatoriaResponse;
import pe.com.tintegro.sigs.dto.response.ObtenerSubActividadResponse;
import pe.com.tintegro.sigs.dto.response.ObtieneActividadResponse;
import pe.com.tintegro.sigs.dto.response.ObtieneActividadesResponse;
import pe.com.tintegro.sigs.dto.response.ObtieneSubActividadResponse;
import pe.com.tintegro.sigs.dto.response.ObtieneSubActividadesResponse;
import pe.com.tintegro.sigs.helpers.RequestHelper;
import pe.com.tintegro.sigs.helpers.ResponseHelper;
import pe.com.tintegro.sigs.properties.APIProperties;
import pe.com.tintegro.sigs.service.ActividadService;

/**
 * @author daniel - 12 set. 2017
 *
 */
@RequestMapping("/areas")
@RestController
@Api("Ã�rea")
public class ActividadController {
	private static final Logger LOG = Logger
			.getLogger(ActividadController.class);

	@Autowired
	private HttpServletRequest servletRequest;

	@Autowired
	private APIProperties apiProperties;

	@Autowired
	private ActividadService actividadService;

	@RequestMapping(value = "/{idArea}/especialidades/{idEspecialidad}/actividades", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	@ApiOperation(value = "Obtener actividades", notes = "Obtiene las actividades de una especialidad.", response = ObtieneActividadesResponse.class)
	public ObtieneActividadesResponse obtenerActividades(
			@RequestHeader("codUsuario") String codUsuario,
			@RequestHeader("idIPRESS") String idIPRESS,
			@RequestHeader("token") String token,
			@PathVariable("idArea") Integer idArea,
			@PathVariable("idEspecialidad") Integer idEspecialidad) {
		ObtieneActividadesRequest request = new ObtieneActividadesRequest();
		request.setIdArea(idArea);
		request.setIdEspecialidad(idEspecialidad);

		ObtieneActividadesResponse response = new ObtieneActividadesResponse();

		try {
			response = actividadService.obtenerActividades(RequestHelper
					.agregarHeaders(servletRequest, request));
			response.setEstado(ResponseEstado.OK);
			response.setMensaje("Actividades obtenidas correctamente.");
		} catch (Exception e) {
			String codigoError = ResponseHelper
					.obtenerCodigoErrorPorFecha(apiProperties.getNombre());
			response.setEstado(ResponseEstado.ERROR_APLICACION);
			response.setMensaje("OcurriÃ³ un error al obtener actividades.");
			response.setCodigoError(codigoError);
			LOG.error(codigoError, e);
		}

		return response;
	}

	@RequestMapping(value = "/{idArea}/especialidades/{idEspecialidad}/actividades/{idActividad}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	@ApiOperation(value = "Obtener actividad", notes = "Obtiene la actividad de una especialidad que pertenece a un Ã¡rea, por su ID.", response = ObtieneActividadResponse.class)
	public ObtieneActividadResponse obtenerActividad(
			@RequestHeader("codUsuario") String codUsuario,
			@RequestHeader("idIPRESS") String idIPRESS,
			@RequestHeader("token") String token,
			@PathVariable("idArea") Integer idArea,
			@PathVariable("idEspecialidad") Integer idEspecialidad,
			@PathVariable("idActividad") Integer idActividad) {
		ObtieneActividadRequest request = new ObtieneActividadRequest();
		request.setIdArea(idArea);
		request.setIdEspecialidad(idEspecialidad);
		request.setIdActividad(idActividad);

		ObtieneActividadResponse response = new ObtieneActividadResponse();

		try {
			response = actividadService.obtenerActividad(RequestHelper
					.agregarHeaders(servletRequest, request));
		} catch (Exception e) {
			String codigoError = ResponseHelper
					.obtenerCodigoErrorPorFecha(apiProperties.getNombre());
			response.setEstado(ResponseEstado.ERROR_APLICACION);
			response.setMensaje("OcurriÃ³ un error al obtener la actividad");
			response.setCodigoError(codigoError);
			LOG.error(codigoError, e);
		}

		return response;
	}

	@RequestMapping(value = "/{idArea}/especialidades/{idEspecialidad}/actividades/{idActividad}/subActividades", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	@ApiOperation(value = "Obtener subactividades", notes = "Obtiene las subactividades de una actividad", response = ObtieneSubActividadesResponse.class)
	public ObtieneSubActividadesResponse obtenerSubActividades(
			@RequestHeader("codUsuario") String codUsuario,
			@RequestHeader("idIPRESS") String idIPRESS,
			@RequestHeader("token") String token,
			@PathVariable("idArea") Integer idArea,
			@PathVariable("idEspecialidad") Integer idEspecialidad,
			@PathVariable("idActividad") Integer idActividad) {
		ObtieneSubActividadesRequest request = new ObtieneSubActividadesRequest();
		request.setIdArea(idArea);
		request.setIdEspecialidad(idEspecialidad);
		request.setIdActividad(idActividad);

		ObtieneSubActividadesResponse response = new ObtieneSubActividadesResponse();

		try {
			response = actividadService.obtenerSubActividades(RequestHelper
					.agregarHeaders(servletRequest, request));
			response.setEstado(ResponseEstado.OK);
			response.setMensaje("Subactividades obtenidades correctamente.");
		} catch (Exception e) {
			String codigoError = ResponseHelper
					.obtenerCodigoErrorPorFecha(apiProperties.getNombre());
			response.setEstado(ResponseEstado.ERROR_APLICACION);
			response.setMensaje("OcurriÃ³ un error al obtener subactividades.");
			response.setCodigoError(codigoError);
			LOG.error(codigoError, e);
		}

		return response;
	}

	@RequestMapping(value = "/{idArea}/especialidades/{idEspecialidad}/actividades/{idActividad}/subActividades/{idSubActividad}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	@ApiOperation(value = "Obtener subactividad", notes = "Obtiene la subactividad de una actividad.", response = ObtieneSubActividadResponse.class)
	public ObtieneSubActividadResponse obtenerSubActividad(
			@RequestHeader("codUsuario") String codUsuario,
			@RequestHeader("idIPRESS") String idIPRESS,
			@RequestHeader("token") String token,
			@PathVariable("idArea") Integer idArea,
			@PathVariable("idEspecialidad") Integer idEspecialidad,
			@PathVariable("idActividad") Integer idActividad,
			@PathVariable("idSubActividad") Integer idSubActividad) {
		ObtieneSubActividadRequest request = new ObtieneSubActividadRequest();
		request.setIdArea(idArea);
		request.setIdEspecialidad(idEspecialidad);
		request.setIdActividad(idActividad);
		request.setIdSubActividad(idSubActividad);

		ObtieneSubActividadResponse response = new ObtieneSubActividadResponse();

		try {
			response = actividadService.obtenerSubActividad(RequestHelper
					.agregarHeaders(servletRequest, request));
		} catch (Exception e) {
			String codigoError = ResponseHelper
					.obtenerCodigoErrorPorFecha(apiProperties.getNombre());
			response.setEstado(ResponseEstado.ERROR_APLICACION);
			response.setMensaje("OcurriÃ³ un error al obtener la subactividad.");
			response.setCodigoError(codigoError);
			LOG.error(codigoError, e);
		}

		return response;
	}

	// Agregado Barreto
	@RequestMapping(value = "/insertar-actividad", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	@ApiOperation(value = "Insertar Nueva Actividad", notes = "Insertar Nueva Actividad", response = InsertarActividadResponse.class)
	public InsertarActividadResponse insertarActividad(
			@RequestHeader("codUsuario") String codUsuario,
			@RequestHeader("idIPRESS") String idIPRESS,
			@RequestHeader("token") String token,
			@RequestBody InsertarActividadRequest request) {

		InsertarActividadResponse response = new InsertarActividadResponse();
		try {
			response = actividadService.insertarActividad(RequestHelper
					.agregarHeaders(servletRequest, request));
		} catch (Exception e) {
			String codigoError = ResponseHelper
					.obtenerCodigoErrorPorFecha(apiProperties.getNombre());
			response.setEstado(ResponseEstado.ERROR_APLICACION);
			response.setMensaje("Error al insertar la Actividad.");
			response.setCodigoError(codigoError);
			LOG.error(codigoError, e);
		}
		return response;
	}

	@RequestMapping(value = "/obtenerActividad-descripcion", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	@ApiOperation(value = "Obtener Actividad por DescripciÃ³n", notes = "Obtener Actividad por DescripciÃ³n", response = ObtenerActividadDescripcionResponse.class)
	public ObtenerActividadDescripcionResponse obtenerActividadDescripcion(
			@RequestHeader("codUsuario") String codUsuario,
			@RequestHeader("token") String token, String descripcionActividad,
			Integer nuPagina, Integer nuRegisMostrar) {
		// @RequestHeader("nuPagina") Integer nuPagina
		// @RequestHeader("nuRegisMostrar") Integer nuRegisMostrar)

		ObtenerActividadDescripcionResponse response = new ObtenerActividadDescripcionResponse();
		ObtenerActividadDescripcionRequest request = new ObtenerActividadDescripcionRequest();

		request.setDescripcionActividad(descripcionActividad);
		request.setNuPagina(nuPagina);
		request.setNuRegisMostrar(nuRegisMostrar);

		try {
			response = actividadService
					.obtenerActividadDescripcion(RequestHelper.agregarHeaders(
							servletRequest, request));
			response.setEstado(ResponseEstado.OK);
			response.setMensaje("Actividad obtenida correctamente.");
		} catch (Exception e) {
			String codigoError = ResponseHelper
					.obtenerCodigoErrorPorFecha(apiProperties.getNombre());
			response.setEstado(ResponseEstado.ERROR_APLICACION);
			response.setMensaje("Error al obtener la Actividad.");
			response.setCodigoError(codigoError);
			LOG.error(codigoError, e);
		}
		return response;
	}

	@RequestMapping(value = "/eliminar-actividad", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	@ApiOperation(value = "Eliminar Actividad", notes = "Eliminar Actividad", response = EliminarActividadResponse.class)
	public EliminarActividadResponse eliminarActividad(
			@RequestParam("idActividad") Integer idActividad) {
		EliminarActividadResponse response = new EliminarActividadResponse();
		EliminarActividadRequest request = new EliminarActividadRequest();

		request.setIdActividad(idActividad);

		try {
			response = actividadService.eliminarActividad(RequestHelper
					.agregarHeaders(servletRequest, request));
		} catch (Exception e) {
			String codigoError = ResponseHelper
					.obtenerCodigoErrorPorFecha(apiProperties.getNombre());
			response.setEstado(ResponseEstado.ERROR_APLICACION);
			response.setMensaje("Hubo un error al eliminar la Actividad.");
			response.setCodigoError(codigoError);
			LOG.error(codigoError, e);
		}
		return response;
	}

	// -----Agregado Barreto
	// WSObtenerSubActividadBARRETO;
	@RequestMapping(value = "/subactividad", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	@ApiOperation(value = "Obtiene todas las subactividades", notes = "Obtiene las subactividades .", response = ObtenerSubActividadResponse.class)
	public ObtenerSubActividadResponse obtenerSubActividad(

	String descripcionSubActividad, Integer numPagina, Integer numRegisMostrar,
			@RequestHeader("token") String token,
			@RequestHeader("codUsuario") String codUsuario) {
		ObtenerSubActividadResponse response = new ObtenerSubActividadResponse();
		ObtenerSubActividadesRequest request = new ObtenerSubActividadesRequest();
		request.setDescripcionSubActividad(descripcionSubActividad);
		request.setNumPagina(numPagina);
		request.setNumRegisMostrar(numRegisMostrar);

		try {
			// response =
			// actividadService.obtenerSubActividad(RequestHelper.agregarHeaders(
			// servletRequest, request));
			// response = actividadService.obtenerSubActividad(
			// RequestHelper.agregarHeaders( servletRequest, request ) );
			response = actividadService.obtenerSubActividadd(RequestHelper
					.agregarHeaders(servletRequest, request));

			response.setEstado(ResponseEstado.OK);
			response.setMensaje("SubActividades obtenidas correctamente.");

		}

		catch (Exception e) {
			String codigoerror = ResponseHelper
					.obtenerCodigoErrorPorFecha(apiProperties.getNombre());
			response.setEstado(ResponseEstado.ERROR_APLICACION);
			response.setMensaje("Error");
			response.setCodigoError(codigoerror);
			LOG.error(codigoerror, e);
		}
		return response;
	}

	// WSInsertarSubActividadBARRETO;
	@RequestMapping(value = "/insertar-subactividad", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	@ApiOperation(value = "Insertar nueva subactividad", notes = "Insertar nueva subactividad", response = InsertarSubActividadesResponse.class)
	public InsertarSubActividadesResponse insertarSubActividad(
			@RequestHeader("codUsuario") String codUsuario,
			@RequestHeader("idIPRESS") String idIPRESS,
			@RequestHeader("token") String token,
			@RequestBody InsertarSubActvidadesRequest request) {
		InsertarSubActividadesResponse response = new InsertarSubActividadesResponse();
		try {
			response = actividadService.insertarSubActividad(RequestHelper
					.agregarHeaders(servletRequest, request));
		} catch (Exception e) {
			String codigoError = ResponseHelper
					.obtenerCodigoErrorPorFecha(apiProperties.getNombre());
			response.setEstado(ResponseEstado.ERROR_APLICACION);
			response.setMensaje("Error al insertar la Actividad.");
			response.setCodigoError(codigoError);
			LOG.error(codigoError, e);
		}
		return response;
	}

	// WSEliminarSubActividadBARRETO;
	@RequestMapping(value = "/eliminar-subactividad", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	@ApiOperation(value = "Sub Actividad eliminada", notes = "Eliminar Sub Actividad", response = EliminarSubActividadResponse.class)
	public EliminarSubActividadResponse eliminarSubActividad(
			@RequestHeader("codUsuario") String codUsuario,
			@RequestParam("idSubActividad") Integer idSubActividad,
			@RequestHeader("token") String token) {
		EliminarSubActividadResponse response = new EliminarSubActividadResponse();
		EliminarSubActividadRequest request = new EliminarSubActividadRequest();
		request.setIdSubActividad(idSubActividad);
		try {
			response = actividadService.eliminarSubActividad(RequestHelper
					.agregarHeaders(servletRequest, request));
		} catch (Exception e) {
			String codigoError = ResponseHelper
					.obtenerCodigoErrorPorFecha(apiProperties.getNombre());
			response.setEstado(ResponseEstado.ERROR_APLICACION);
			response.setMensaje("Error al eliminar la Sub Actividad.");
			response.setCodigoError(codigoError);
			LOG.error(codigoError, e);
		}
		return response;
	}

	// WSActualizarActividad

	@RequestMapping(value = "/actualizar-actividad", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	@ApiOperation(value = "Actualiza actividad", notes = "Edita actividad", response = ActualizarActividadResponse.class)
	public ActualizarActividadResponse actualizarActividad(
			@RequestHeader("codUsuario") String codUsuario,
			@RequestHeader("idIPRESS") String idIPRESS,
			@RequestHeader("token") String token,
			@RequestBody ActualizarActividadRequest request) {
		ActualizarActividadResponse response = new ActualizarActividadResponse();
		try {
			response = actividadService.actualizarActividad(RequestHelper
					.agregarHeaders(servletRequest, request));
		} catch (Exception e) {

			String codigoError = ResponseHelper
					.obtenerCodigoErrorPorFecha(apiProperties.getNombre());
			response.setEstado(ResponseEstado.ERROR_APLICACION);
			response.setMensaje("Error al actualizar Actividad.");
			response.setCodigoError(codigoError);
			LOG.error(codigoError, e);
		}
		return response;
	}
	
	@RequestMapping(value = "/obtenerAreasCitaAmbulatoria", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	@ApiOperation(value = "Insertar Nueva Actividad", notes = "Insertar Nueva Actividad", response = ObtenerActividadesConsultaAmbulatoriaResponse.class)
	public ObtenerActividadesConsultaAmbulatoriaResponse obtenerActividadesConsultaAmbulatoria (
			@RequestHeader("codUsuario") String codUsuario,
			@RequestHeader("idIPRESS") String idIPRESS,
			@RequestHeader("token") String token,
			@RequestParam( value = "idArea", required = false) Integer idArea,
			@RequestParam( value = "idEspecialidad", required = false) Integer idEspecialidad) {
		 
		ObtenerActividadesConsultaAmbulatoriaResponse response = new ObtenerActividadesConsultaAmbulatoriaResponse();
		ObtenerActividadesConsultaAmbulatoriaRequest request = new ObtenerActividadesConsultaAmbulatoriaRequest();
		request.setIdArea(idArea);
		request.setIdEspecialidad(idEspecialidad);
		try {
			response = actividadService.obtenerActividadesConsultaAmbulatoria(RequestHelper.agregarHeaders(servletRequest, request));
			response.setEstado(ResponseEstado.OK);
			response.setMensaje("Actividades obtenidas correctamente.");
		} catch (Exception e) {
			String codigoError = ResponseHelper.obtenerCodigoErrorPorFecha(apiProperties.getNombre());
			response.setEstado(ResponseEstado.ERROR_APLICACION);
			response.setMensaje("Error al insertar la Actividad.");
			response.setCodigoError(codigoError);
			LOG.error(codigoError, e);
		}
		return response;
	}

}
