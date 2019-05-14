package pe.com.tintegro.sigs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.tintegro.sigs.constants.ResponseEstado;
import pe.com.tintegro.sigs.dao.AlmacenOrdenCompraDAO;
import pe.com.tintegro.sigs.dto.request.ActualizarCantidadFisicaRequest;
import pe.com.tintegro.sigs.dto.request.ActualizarEstadoAlmacenOrdenCompraRequest;
import pe.com.tintegro.sigs.dto.request.ListarAlmacenOrdenCompraMaterialRequest;
import pe.com.tintegro.sigs.dto.request.ListarAlmacenOrdenCompraRequest;
import pe.com.tintegro.sigs.dto.response.ActualizarCantidadFisicaResponse;
import pe.com.tintegro.sigs.dto.response.ActualizarEstadoAlmacenOrdenCompraResponse;
import pe.com.tintegro.sigs.dto.response.InsertarAreaResponse;
import pe.com.tintegro.sigs.dto.response.ListarAlmacenOrdenCompraMaterialResponse;
import pe.com.tintegro.sigs.dto.response.ListarAlmacenOrdenCompraResponse;
import pe.com.tintegro.sigs.entidad.general.Confirmacion;
import pe.com.tintegro.sigs.service.AlmacenOrdenCompraService;

@Service("almacenOrdenCompraService")
public class AlmacenOrdenCompraServiceImpl implements AlmacenOrdenCompraService {

	@Autowired
	private AlmacenOrdenCompraDAO almacenOrdenCompraDAO;

	@Override
	public ListarAlmacenOrdenCompraResponse listarAlmacenOrdenCompra(
			ListarAlmacenOrdenCompraRequest request) throws Exception {
		ListarAlmacenOrdenCompraResponse response = new ListarAlmacenOrdenCompraResponse();
		response = almacenOrdenCompraDAO.listarAlmacenOrdenCompra(request);
		if (response.getAlmacenOrdenCompraList().size() == 0) {
			response.setMensaje("No se encuentran ordenes de compra");
			response.setEstado(ResponseEstado.ERROR_NEGOCIO);
		} else {
			response.setMensaje("Se listo correctamente");
			response.setEstado(ResponseEstado.OK);
		}
		return response;
	}

	@Override
	public ListarAlmacenOrdenCompraMaterialResponse listarAlmacenOrdenCompraMaterial(
			ListarAlmacenOrdenCompraMaterialRequest request) throws Exception {
		ListarAlmacenOrdenCompraMaterialResponse response = new ListarAlmacenOrdenCompraMaterialResponse();
		response = almacenOrdenCompraDAO
				.listarAlmacenOrdenCompraMaterial(request);
		if (response.getAlmacenOrdenCompraMaterialList().size() == 0) {
			response.setMensaje("No se encuentran materiales");
			response.setEstado(ResponseEstado.ERROR_NEGOCIO);
		} else {
			response.setMensaje("Se listo correctamente");
			response.setEstado(ResponseEstado.OK);
		}
		return response;
	}

	@Override
	public ActualizarCantidadFisicaResponse actualizarCantidadFisica(
			ActualizarCantidadFisicaRequest request) throws Exception {
		ActualizarCantidadFisicaResponse response = almacenOrdenCompraDAO
				.actualizarCantidadFisica(request);

		Confirmacion confirmacion = response.getConfirmacion();

		if (confirmacion.getId() == ResponseEstado.OK) {
			response.setEstado(ResponseEstado.OK);
			response.setMensaje("Cantidad Física actualizada correctamente.");
		} else {
			response.setEstado(ResponseEstado.ERROR_NEGOCIO);
			response.setMensaje("No se ingreso la cantidad física");
		}
		return response;
	}

	@Override
	public ActualizarEstadoAlmacenOrdenCompraResponse actualizarEstado(
			ActualizarEstadoAlmacenOrdenCompraRequest request) throws Exception {
		ActualizarEstadoAlmacenOrdenCompraResponse response = almacenOrdenCompraDAO
				.actualizarEstado(request);

		Confirmacion confirmacion = response.getConfirmacion();

		if (confirmacion.getId() == ResponseEstado.OK) {
			response.setEstado(ResponseEstado.OK);
			response.setMensaje("Estado actualizado correctamente.");
		} else {
			response.setEstado(ResponseEstado.ERROR_NEGOCIO);
			response.setMensaje("La cantidad física no es igual a la cantidad solicitada.");
		}
		return response;
	}

}
