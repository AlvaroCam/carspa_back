package pe.com.tintegro.sigs.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

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
import pe.com.tintegro.sigs.dto.request.EliminarMaterialRequest;
import pe.com.tintegro.sigs.dto.request.InsertarActualizarMaterialRequest;
import pe.com.tintegro.sigs.dto.request.ListarMaterialRequest;
import pe.com.tintegro.sigs.dto.request.ListarProveedorRequest;
import pe.com.tintegro.sigs.dto.response.InsertarActualizarMaterialResponse;
import pe.com.tintegro.sigs.dto.response.ListarMaterialResponse;
import pe.com.tintegro.sigs.dto.response.ListarProveedorResponse;
import pe.com.tintegro.sigs.helpers.ResponseHelper;
import pe.com.tintegro.sigs.properties.APIProperties;
import pe.com.tintegro.sigs.service.MaterialService;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/material")
@Api("material")
public class MaterialController {

	@Autowired
	private MaterialService materialService;

	private static final Logger LOG = Logger.getLogger(MaterialController.class);

	@Autowired
	private HttpServletRequest servletRequest;

	@Autowired
	private APIProperties apiProperties;
	

	@RequestMapping(value = "/listarMateriales", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	@ApiOperation(value = "obtiene materiales", notes = "obtiene materiales", response = ListarMaterialResponse.class)
	public ListarMaterialResponse listarMateriales(
			String nombre,
			Integer estado,
			Integer nuPagina,
			Integer nuRegisMostrar) {
		ListarMaterialResponse response = new ListarMaterialResponse();
		ListarMaterialRequest request = new ListarMaterialRequest();
		
		request.setNombre(nombre);
		request.setEstado(estado);
		request.setNuPagina(nuPagina);
		request.setNuRegisMostrar(nuRegisMostrar);
		
		try {
			response = materialService.listarMateriales(request);
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
	@RequestMapping(value = "/listarProveedores", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	@ApiOperation(value = "obtiene proveedores", notes = "obtiene proveedores", response = ListarProveedorResponse.class)
	public ListarProveedorResponse comboProveedor() {
		ListarProveedorResponse response = new ListarProveedorResponse();
		ListarProveedorRequest request = new ListarProveedorRequest();
		
		try {
			response = materialService.comboProveedor(request);
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
	@RequestMapping(value = "/eliminarMaterial", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	@ApiOperation(value = "elimina material", notes = "elimina material", response = InsertarActualizarMaterialResponse.class)

	public InsertarActualizarMaterialResponse desactivarMaterial(
			@RequestBody EliminarMaterialRequest request) {
		InsertarActualizarMaterialResponse response = new InsertarActualizarMaterialResponse();
		
		try {
			response = materialService.desactivarMaterial(request);
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
	@RequestMapping(value = "/activarMaterial", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	@ApiOperation(value = "elimina material", notes = "elimina material", response = InsertarActualizarMaterialResponse.class)
	public InsertarActualizarMaterialResponse activarMaterial(
			@RequestBody EliminarMaterialRequest request) {
		InsertarActualizarMaterialResponse response = new InsertarActualizarMaterialResponse();
		
		try {
			response = materialService.activarMaterial(request);
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
	@RequestMapping(value = "/actualizarMaterial", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	@ApiOperation(value = "elimina material", notes = "elimina material", response = InsertarActualizarMaterialResponse.class)
	public InsertarActualizarMaterialResponse updateMaterial(
			@RequestBody InsertarActualizarMaterialRequest request) {
		InsertarActualizarMaterialResponse response = new InsertarActualizarMaterialResponse();
	
		try {
			response = materialService.updateMaterial(request);
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
	@RequestMapping(value = "/insertarMaterial", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	@ApiOperation(value = "insertar material", notes = "insertar material", response = InsertarActualizarMaterialResponse.class)
	public InsertarActualizarMaterialResponse insertMaterial(
			@RequestBody InsertarActualizarMaterialRequest request) {
		InsertarActualizarMaterialResponse response = new InsertarActualizarMaterialResponse();
	
		try {
			response = materialService.insertMaterial(request);
			response.setEstado(1);
		} catch (Exception e) {
			String codigoError = ResponseHelper
					.obtenerCodigoErrorPorFecha(apiProperties.getNombre());
			response.setEstado(ResponseEstado.ERROR_APLICACION);
			response.setMensaje("Ocurrió un error al insertar");
			response.setCodigoError(codigoError);
			LOG.error(codigoError, e);
		}
		return response;
	}
	@RequestMapping(value = "/listarMaterialesAlertas", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	@ApiOperation(value = "obtiene materiales", notes = "obtiene materiales", response = ListarMaterialResponse.class)
	public ListarMaterialResponse listarMaterialesAlerta(
			String nombre,
			Integer estado,
			Integer nuPagina,
			Integer nuRegisMostrar) {
		ListarMaterialResponse response = new ListarMaterialResponse();
		ListarMaterialRequest request = new ListarMaterialRequest();
		
		request.setNombre(nombre);
		request.setEstado(estado);
		request.setNuPagina(nuPagina);
		request.setNuRegisMostrar(nuRegisMostrar);
		
		try {
			response = materialService.listarMaterialesAlerta(request);
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

}
