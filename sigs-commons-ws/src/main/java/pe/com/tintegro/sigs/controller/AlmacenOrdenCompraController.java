package pe.com.tintegro.sigs.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import pe.com.tintegro.sigs.constants.ResponseEstado;
import pe.com.tintegro.sigs.dto.request.ActualizarCantidadFisicaRequest;
import pe.com.tintegro.sigs.dto.request.ActualizarEstadoAlmacenOrdenCompraRequest;
import pe.com.tintegro.sigs.dto.request.ListarAlmacenOrdenCompraMaterialRequest;
import pe.com.tintegro.sigs.dto.request.ListarAlmacenOrdenCompraRequest;
import pe.com.tintegro.sigs.dto.response.ActualizarCantidadFisicaResponse;
import pe.com.tintegro.sigs.dto.response.ActualizarEstadoAlmacenOrdenCompraResponse;
import pe.com.tintegro.sigs.dto.response.ListarAlmacenOrdenCompraMaterialResponse;
import pe.com.tintegro.sigs.dto.response.ListarAlmacenOrdenCompraResponse;
import pe.com.tintegro.sigs.helpers.ResponseHelper;
import pe.com.tintegro.sigs.properties.APIProperties;
import pe.com.tintegro.sigs.service.AlmacenOrdenCompraService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/almacenOrdenCompra")
public class AlmacenOrdenCompraController {

	@Autowired
	private AlmacenOrdenCompraService almacenOrdenCompraService;

	private static final Logger LOG = Logger.getLogger(AlmacenOrdenCompraController.class);

	@Autowired
	private HttpServletRequest servletRequest;

	@Autowired
	private APIProperties apiProperties;

	@RequestMapping(value = "/listarAlmacenOrdenCompra", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	@ApiOperation(value = "obtiene almacen", notes = "obtiene almacen", response = ListarAlmacenOrdenCompraResponse.class)
	public ListarAlmacenOrdenCompraResponse obtenerActoMedicoPorCita(Integer idAlmacenOrdenCompra, String estado,
			Integer nuPagina, Integer nuRegisMostrar) {
		ListarAlmacenOrdenCompraResponse response = new ListarAlmacenOrdenCompraResponse();
		ListarAlmacenOrdenCompraRequest request = new ListarAlmacenOrdenCompraRequest();
		request.setIdAlmacenOrdenCompra(idAlmacenOrdenCompra);
		request.setEstado(estado);
		request.setNuPagina(nuPagina);
		request.setNuRegisMostrar(nuRegisMostrar);
		try {
			response = almacenOrdenCompraService.listarAlmacenOrdenCompra(request);
		} catch (Exception e) {
			String codigoError = ResponseHelper.obtenerCodigoErrorPorFecha(apiProperties.getNombre());
			response.setEstado(ResponseEstado.ERROR_APLICACION);
			response.setMensaje("Ocurrió un error al obtener las Ordenes de Compra");
			response.setCodigoError(codigoError);
			LOG.error(codigoError, e);
		}
		return response;
	}

	@RequestMapping(value = "/listarMaterialesPorOrden", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	@ApiOperation(value = "obtiene almacen", notes = "obtiene almacen", response = ListarAlmacenOrdenCompraMaterialResponse.class)
	public ListarAlmacenOrdenCompraMaterialResponse obtenerMaterialesporOrden(
			@RequestParam Integer idAlmacenOrdenCompra) {
		ListarAlmacenOrdenCompraMaterialResponse response = new ListarAlmacenOrdenCompraMaterialResponse();
		ListarAlmacenOrdenCompraMaterialRequest request = new ListarAlmacenOrdenCompraMaterialRequest();
		request.setIdAlmacenOrdenCompra(idAlmacenOrdenCompra);
		try {
			response = almacenOrdenCompraService.listarAlmacenOrdenCompraMaterial(request);
		} catch (Exception e) {
			String codigoError = ResponseHelper.obtenerCodigoErrorPorFecha(apiProperties.getNombre());
			response.setEstado(ResponseEstado.ERROR_APLICACION);
			response.setMensaje("Ocurrió un error al obtener los Materiales");
			response.setCodigoError(codigoError);
			LOG.error(codigoError, e);
		}
		return response;
	}

	@RequestMapping(value = "/actualizarEstado", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	@ApiOperation(value = "Actualizar", notes = "Actualizar", response = ActualizarEstadoAlmacenOrdenCompraResponse.class)
	public ActualizarEstadoAlmacenOrdenCompraResponse insertaAmbiente(
			@RequestBody ActualizarEstadoAlmacenOrdenCompraRequest request) {
		ActualizarEstadoAlmacenOrdenCompraResponse response = new ActualizarEstadoAlmacenOrdenCompraResponse();

		try {
			response = almacenOrdenCompraService.actualizarEstado(request);
		} catch (Exception e) {
			String codigoError = ResponseHelper.obtenerCodigoErrorPorFecha(apiProperties.getNombre());

			response.setEstado(ResponseEstado.ERROR_APLICACION);
			response.setMensaje("Error al actualizar el estado");
			response.setCodigoError(codigoError);

			LOG.error(codigoError, e);
		}
		return response;
	}

	@RequestMapping(value = "/actualizarCantidadFisica", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	@ApiOperation(value = "Actualizar", notes = "Actualizar", response = ActualizarCantidadFisicaResponse.class)
	public ActualizarCantidadFisicaResponse actualizarEstado(@RequestBody ActualizarCantidadFisicaRequest request) {
		ActualizarCantidadFisicaResponse response = new ActualizarCantidadFisicaResponse();

		try {
			response = almacenOrdenCompraService.actualizarCantidadFisica(request);
		} catch (Exception e) {
			String codigoError = ResponseHelper.obtenerCodigoErrorPorFecha(apiProperties.getNombre());
			response.setEstado(ResponseEstado.ERROR_APLICACION);
			response.setMensaje("Error al actualizar cantidad física");
			response.setCodigoError(codigoError);

			LOG.error(codigoError, e);
		}
		return response;
	}
}
