/**
 * 
 */
package pe.com.tintegro.sigs.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
import pe.com.tintegro.sigs.dto.request.EliminarAreaRequest;
import pe.com.tintegro.sigs.dto.request.InsertarAreaRequest;
import pe.com.tintegro.sigs.dto.request.ObtenerAreaRequest;
import pe.com.tintegro.sigs.dto.request.ObtieneAreaConsultaAmbulatoriaRequest;
import pe.com.tintegro.sigs.dto.request.ObtieneAreaRequest;
import pe.com.tintegro.sigs.dto.request.ObtieneAreasRequest;
import pe.com.tintegro.sigs.dto.request.ObtieneAreasSinAlmacenRequest;
import pe.com.tintegro.sigs.dto.response.EliminarAreaResponse;
import pe.com.tintegro.sigs.dto.response.InsertarAreaResponse;
import pe.com.tintegro.sigs.dto.response.ObtenerAreaResponse;
import pe.com.tintegro.sigs.dto.response.ObtieneAreaConsultaAmbulatoriaResponse;
import pe.com.tintegro.sigs.dto.response.ObtieneAreaResponse;
import pe.com.tintegro.sigs.dto.response.ObtieneAreasResponse;
import pe.com.tintegro.sigs.dto.response.ObtieneAreasSinAlmacenResponse;
import pe.com.tintegro.sigs.helpers.RequestHelper;
import pe.com.tintegro.sigs.helpers.ResponseHelper;
import pe.com.tintegro.sigs.properties.APIProperties;
import pe.com.tintegro.sigs.service.AreaService;

/**
 * @author daniel - 11 set. 2017
 *
 */
@RequestMapping("/areas")
@RestController
@Api("Area")
public class AreaController {
	private static final Logger LOG = Logger.getLogger(AreaController.class);

	@Autowired
	private HttpServletRequest servletRequest;

	@Autowired
	private APIProperties apiProperties;

	@Autowired
	private AreaService areaService;

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	@ApiOperation(value = "Obtener Áreas", notes = "Obtiene las Áreas generales del sistema.", response = ObtieneAreasResponse.class)
	public ObtieneAreasResponse obtenerAreas(
			@RequestHeader("codUsuario") String codUsuario,
			@RequestHeader("idIPRESS") String idIPRESS,
			@RequestHeader("token") String token) {
		ObtieneAreasRequest request = new ObtieneAreasRequest();
		ObtieneAreasResponse response = new ObtieneAreasResponse();

		try {
			response = areaService.obtenerAreas(RequestHelper.agregarHeaders(
					servletRequest, request));
			response.setEstado(ResponseEstado.OK);
			response.setMensaje("Áreas obtenidas correctamente.");
		} catch (Exception e) {
			String codigoError = ResponseHelper
					.obtenerCodigoErrorPorFecha(apiProperties.getNombre());
			response.setEstado(ResponseEstado.ERROR_APLICACION);
			response.setMensaje("Ocurrió un error al obtener las Áreas.");
			response.setCodigoError(codigoError);
			LOG.error(codigoError, e);
		}

		return response;
	}

	@RequestMapping(value = "/{idArea}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	@ApiOperation(value = "Obtener Área", notes = "Obtiene un Área por su ID.", response = ObtieneAreaResponse.class)
	public ObtieneAreaResponse obtenerArea(
			@RequestHeader("codUsuario") String codUsuario,
			@RequestHeader("idIPRESS") String idIPRESS,
			@RequestHeader("token") String token,
			@PathVariable("idArea") int idArea) {
		ObtieneAreaRequest request = new ObtieneAreaRequest();
		ObtieneAreaResponse response = new ObtieneAreaResponse();

		request.setIdArea(idArea);

		try {
			response = areaService.obtenerArea(RequestHelper.agregarHeaders(
					servletRequest, request));
		} catch (Exception e) {
			String codigoError = ResponseHelper
					.obtenerCodigoErrorPorFecha(apiProperties.getNombre());
			response.setEstado(ResponseEstado.ERROR_APLICACION);
			response.setMensaje("Ocurrió un error al obtener un Área.");
			response.setCodigoError(codigoError);
			LOG.error(codigoError, e);
		}

		return response;
	}

	@RequestMapping(value = "/sinAlmacen", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	@ApiOperation(value = "Obtener Área", notes = "Obtiene un Área por su ID. indistintamente del ipress", response = ObtieneAreasSinAlmacenResponse.class)
	public ObtieneAreasSinAlmacenResponse obtenerAreasSinAlmacen(
			@RequestHeader("codUsuario") String codUsuario,
			@RequestHeader("idIPRESS") String idIPRESS,
			@RequestHeader("token") String token,
			@RequestParam(value = "idArea", required = false) Integer idArea) {
		ObtieneAreasSinAlmacenResponse response = new ObtieneAreasSinAlmacenResponse();
		ObtieneAreasSinAlmacenRequest request = new ObtieneAreasSinAlmacenRequest();
		request.setIdArea(idArea);
		try {
			response = areaService.obtenerAreasSinAlmacen(RequestHelper
					.agregarHeaders(servletRequest, request));
		} catch (Exception e) {
			String codigoError = ResponseHelper
					.obtenerCodigoErrorPorFecha(apiProperties.getNombre());
			response.setEstado(ResponseEstado.ERROR_APLICACION);
			response.setMensaje("Ocurrió un error al obtener un Área.");
			response.setCodigoError(codigoError);
			LOG.error(codigoError, e);
		}
		return response;
	}

	@RequestMapping(value = "/obtenerAreas", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	@ApiOperation(value = "Obtener areas", notes = "Obtiene todas las areas o area.", response = ObtenerAreaResponse.class)
	public ObtenerAreaResponse obtenerAreas(String descripcionArea,
			Integer numPagina, Integer numRegisMostrar,
			@RequestHeader("token") String token,
			@RequestHeader("codUsuario") String codUsuario) {

		ObtenerAreaResponse response = new ObtenerAreaResponse();
		ObtenerAreaRequest request = new ObtenerAreaRequest();
		request.setDescripcionArea(descripcionArea);
		request.setNumPagina(numPagina);
		request.setNumRegisMostrar(numRegisMostrar);
		try {
			response = areaService.obtenerAreas(RequestHelper.agregarHeaders(
					servletRequest, request));

			response.setEstado(ResponseEstado.OK);
			response.setMensaje("Area obtenidas correctamente.");
		} catch (Exception e) {
			String codigoerror = ResponseHelper
					.obtenerCodigoErrorPorFecha(apiProperties.getNombre());
			response.setEstado(ResponseEstado.ERROR_APLICACION);
			response.setMensaje("Error");
			response.setCodigoError(codigoerror);
			LOG.error(codigoerror, e);
		}
		return response;
	}
	
	@RequestMapping( value = "/insertarArea", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE )
	@ResponseStatus( value = HttpStatus.OK )
	@ApiOperation( value = "Insertar Área", notes = "Inserta un Área por su descripcion y abreviatura", response = InsertarAreaResponse.class )

	public  InsertarAreaResponse insertarArea (
			@RequestHeader("codUsuario") String codUsuario,
			@RequestHeader("idIPRESS") String idIPRESS,
			@RequestHeader("token") String token,
			@RequestBody InsertarAreaRequest request){
			InsertarAreaResponse response = new InsertarAreaResponse ();
			try {
				response = areaService.insertarArea(RequestHelper.agregarHeaders(servletRequest, request));
				} 
			catch (Exception e)
				{
				String codigoError = ResponseHelper.obtenerCodigoErrorPorFecha(apiProperties.getNombre());
				response.setEstado(ResponseEstado.ERROR_APLICACION);
				response.setMensaje("Ya existe un area con ese nombre");
				response.setCodigoError(codigoError);
				LOG.error(codigoError, e);
				}
				return response;	
	}
	
	@RequestMapping( value = "/eliminarArea", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE )
	@ResponseStatus( value = HttpStatus.OK )
	@ApiOperation( value = "Eliminar Área", notes = "Elimina un Área por su id", response = EliminarAreaResponse.class )
	public  EliminarAreaResponse eliminarArea (
			@RequestHeader("codUsuario") String codUsuario,			
			@RequestHeader("token") String token,
			Integer idArea){
		EliminarAreaRequest request = new EliminarAreaRequest();
		EliminarAreaResponse response = new EliminarAreaResponse();
		request.setIdArea(idArea);
			
		try{
			response = areaService.eliminarArea(RequestHelper.agregarHeaders(servletRequest, request));
		}catch (Exception e) {
			String codigoError = ResponseHelper.obtenerCodigoErrorPorFecha(apiProperties.getNombre());
			response.setEstado(ResponseEstado.OK);
			response.setMensaje("Se Elimino Correctamente.");
			response.setCodigoError(codigoError);
			LOG.error(codigoError, e);
		}
		return response;
	}
	
	@RequestMapping(value="obtieneAreaConsultaAmbulatoria", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	@ApiOperation(value = "Obtener Áreas", notes = "Obtiene las Áreas generales del sistema.", response = ObtieneAreaConsultaAmbulatoriaResponse.class)
	public ObtieneAreaConsultaAmbulatoriaResponse obtenerAreasConsultaAmbulatoria(
			@RequestHeader("codUsuario") String codUsuario,
			@RequestHeader("idIPRESS") String idIPRESS,
			@RequestHeader("token") String token) {
		ObtieneAreaConsultaAmbulatoriaRequest request = new ObtieneAreaConsultaAmbulatoriaRequest();
		ObtieneAreaConsultaAmbulatoriaResponse response = new ObtieneAreaConsultaAmbulatoriaResponse();
		
		try {
			response = areaService.obtenerAreasConsultaAmbulatoria(RequestHelper.agregarHeaders(
					servletRequest, request));
			response.setEstado(ResponseEstado.OK);
			response.setMensaje("Áreas obtenidas correctamente.");
		} catch (Exception e) {
			String codigoError = ResponseHelper
					.obtenerCodigoErrorPorFecha(apiProperties.getNombre());
			response.setEstado(ResponseEstado.ERROR_APLICACION);
			response.setMensaje("Ocurrió un error al obtener las Áreas.");
			response.setCodigoError(codigoError);
			LOG.error(codigoError, e);
		}

		return response;
	}
}
