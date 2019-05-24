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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import pe.com.tintegro.sigs.constants.ResponseEstado;
import pe.com.tintegro.sigs.dto.request.EliminarMaquinariaRequest;
import pe.com.tintegro.sigs.dto.request.InsertarActualizarMaquinariaRequest;
import pe.com.tintegro.sigs.dto.request.ListarMaquinariaRequest;
import pe.com.tintegro.sigs.dto.response.InsertarActualizarMaquinariaResponse;
import pe.com.tintegro.sigs.dto.response.ListarMaquinariaResponse;
import pe.com.tintegro.sigs.helpers.ResponseHelper;
import pe.com.tintegro.sigs.properties.APIProperties;
import pe.com.tintegro.sigs.service.MaquinariaService;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/maquinaria")
@Api("maquinaria")
public class MaquinariaController {
	@Autowired
	private MaquinariaService maquinariaService;

	private static final Logger LOG = Logger.getLogger(MaquinariaController.class);

	@Autowired
	private HttpServletRequest servletRequest;

	@Autowired
	private APIProperties apiProperties;
	@RequestMapping(value = "/listarMaquinarias", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	@ApiOperation(value = "obtiene Maquinarias", notes = "obtiene Maquinarias", response = ListarMaquinariaResponse.class)
	public ListarMaquinariaResponse listarMaquinariaes(
			String nombre,
			Integer estado,
			Integer nuPagina,
			Integer nuRegisMostrar) {
		ListarMaquinariaResponse response = new ListarMaquinariaResponse();
		ListarMaquinariaRequest request = new ListarMaquinariaRequest();
		
		request.setNombre(nombre);
		request.setEstado(estado);
		request.setNuPagina(nuPagina);
		request.setNuRegisMostrar(nuRegisMostrar);
		
		try {
			response = maquinariaService.listarMaquinaria(request);
			response.setEstado(1);
		} catch (Exception e) {
			String codigoError = ResponseHelper
					.obtenerCodigoErrorPorFecha(apiProperties.getNombre());
			response.setEstado(ResponseEstado.ERROR_APLICACION);
			response.setMensaje("Ocurrió un error al obtener");
			response.setCodigoError(codigoError);
			LOG.error(codigoError, e);
		}
		return response;
	}

	@RequestMapping(value = "/eliminarMaquinaria", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	@ApiOperation(value = "elimina Maquinaria", notes = "elimina Maquinaria", response = InsertarActualizarMaquinariaResponse.class)

	public InsertarActualizarMaquinariaResponse desactivarMaquinaria(
			@RequestBody	EliminarMaquinariaRequest request) {
		InsertarActualizarMaquinariaResponse response = new InsertarActualizarMaquinariaResponse();
		
		try {
			response = maquinariaService.desactivarMaquinaria(request);
			response.setEstado(1);
		} catch (Exception e) {
			String codigoError = ResponseHelper
					.obtenerCodigoErrorPorFecha(apiProperties.getNombre());
			response.setEstado(ResponseEstado.ERROR_APLICACION);
			response.setMensaje("Ocurrió un error al obtener las Ordenes de Compra");
			response.setCodigoError(codigoError);
			LOG.error(codigoError, e);
		}
		return response;
	}
	@RequestMapping(value = "/activarMaquinaria", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	@ApiOperation(value = "elimina Maquinaria", notes = "elimina Maquinaria", response = InsertarActualizarMaquinariaResponse.class)
	public InsertarActualizarMaquinariaResponse activarMaquinaria(
			@RequestBody	EliminarMaquinariaRequest request) {
		InsertarActualizarMaquinariaResponse response = new InsertarActualizarMaquinariaResponse();
		
		try {
			response = maquinariaService.activarMaquinaria(request);
			response.setEstado(1);
		} catch (Exception e) {
			String codigoError = ResponseHelper
					.obtenerCodigoErrorPorFecha(apiProperties.getNombre());
			response.setEstado(ResponseEstado.ERROR_APLICACION);
			response.setMensaje("Ocurrió un error al obtener las Ordenes de Compra");
			response.setCodigoError(codigoError);
			LOG.error(codigoError, e);
		}
		return response;
	}
	@RequestMapping(value = "/actualizarMaquinaria", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	@ApiOperation(value = "elimina Maquinaria", notes = "elimina Maquinaria", response = InsertarActualizarMaquinariaResponse.class)
	public InsertarActualizarMaquinariaResponse updateMaquinaria(
			@RequestBody	InsertarActualizarMaquinariaRequest request) {
		InsertarActualizarMaquinariaResponse response = new InsertarActualizarMaquinariaResponse();
	
		try {
			response = maquinariaService.updateMaquinaria(request);
			response.setEstado(1);
		} catch (Exception e) {
			String codigoError = ResponseHelper
					.obtenerCodigoErrorPorFecha(apiProperties.getNombre());
			response.setEstado(ResponseEstado.ERROR_APLICACION);
			response.setMensaje("Ocurrió un error al obtener las Ordenes de Compra");
			response.setCodigoError(codigoError);
			LOG.error(codigoError, e);
		}
		return response;
	}
	@RequestMapping(value = "/insertarMaquinaria", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	@ApiOperation(value = "elimina Maquinaria", notes = "elimina Maquinaria", response = InsertarActualizarMaquinariaResponse.class)
	public InsertarActualizarMaquinariaResponse insertMaquinaria(
			@RequestBody	InsertarActualizarMaquinariaRequest request) {
		InsertarActualizarMaquinariaResponse response = new InsertarActualizarMaquinariaResponse();
	
		try {
			response = maquinariaService.insertMaquinaria(request);
			response.setEstado(1);
		} catch (Exception e) {
			String codigoError = ResponseHelper
					.obtenerCodigoErrorPorFecha(apiProperties.getNombre());
			response.setEstado(ResponseEstado.ERROR_APLICACION);
			response.setMensaje("Ocurrió un error al obtener las Ordenes de Compra");
			response.setCodigoError(codigoError);
			LOG.error(codigoError, e);
		}
		return response;
	}

}
