package pe.com.tintegro.sigs.dao;

import pe.com.tintegro.sigs.dto.request.ActualizarCantidadFisicaRequest;
import pe.com.tintegro.sigs.dto.request.ActualizarEstadoAlmacenOrdenCompraRequest;
import pe.com.tintegro.sigs.dto.request.ListarAlmacenOrdenCompraMaterialRequest;
import pe.com.tintegro.sigs.dto.request.ListarAlmacenOrdenCompraRequest;
import pe.com.tintegro.sigs.dto.response.ActualizarCantidadFisicaResponse;
import pe.com.tintegro.sigs.dto.response.ActualizarEstadoAlmacenOrdenCompraResponse;
import pe.com.tintegro.sigs.dto.response.ListarAlmacenOrdenCompraMaterialResponse;
import pe.com.tintegro.sigs.dto.response.ListarAlmacenOrdenCompraResponse;

public interface AlmacenOrdenCompraDAO {

	ListarAlmacenOrdenCompraResponse listarAlmacenOrdenCompra(
			ListarAlmacenOrdenCompraRequest request) throws Exception;

	ListarAlmacenOrdenCompraMaterialResponse listarAlmacenOrdenCompraMaterial(
			ListarAlmacenOrdenCompraMaterialRequest request) throws Exception;

	ActualizarCantidadFisicaResponse actualizarCantidadFisica(
			ActualizarCantidadFisicaRequest request) throws Exception;

	ActualizarEstadoAlmacenOrdenCompraResponse actualizarEstado(
			ActualizarEstadoAlmacenOrdenCompraRequest request) throws Exception;
}
