package pe.com.tintegro.sigs.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.com.tintegro.sigs.dao.AlmacenOrdenCompraDAO;
import pe.com.tintegro.sigs.dto.request.ActualizarCantidadFisicaRequest;
import pe.com.tintegro.sigs.dto.request.ActualizarEstadoAlmacenOrdenCompraRequest;
import pe.com.tintegro.sigs.dto.request.ListarAlmacenOrdenCompraMaterialRequest;
import pe.com.tintegro.sigs.dto.request.ListarAlmacenOrdenCompraRequest;
import pe.com.tintegro.sigs.dto.response.ActualizarCantidadFisicaResponse;
import pe.com.tintegro.sigs.dto.response.ActualizarEstadoAlmacenOrdenCompraResponse;
import pe.com.tintegro.sigs.dto.response.InsertarActividadResponse;
import pe.com.tintegro.sigs.dto.response.ListarAlmacenOrdenCompraMaterialResponse;
import pe.com.tintegro.sigs.dto.response.ListarAlmacenOrdenCompraResponse;
import pe.com.tintegro.sigs.entidad.AlmacenOrdenCompra;
import pe.com.tintegro.sigs.entidad.AlmacenOrdenCompraMaterial;
import pe.com.tintegro.sigs.entidad.general.Confirmacion;
import pe.com.tintegro.sigs.mapper.AlmacenOrdenCompraMapper;

@Repository("almacenOrdenCompraDAO")
@Transactional
public class AlmacenOrdenCompraDAOImpl implements AlmacenOrdenCompraDAO {

	@Autowired
	private AlmacenOrdenCompraMapper almacenOrdenCompraMapper;

	@Override
	public ListarAlmacenOrdenCompraResponse listarAlmacenOrdenCompra(
			ListarAlmacenOrdenCompraRequest request) throws Exception {
		ListarAlmacenOrdenCompraResponse response = new ListarAlmacenOrdenCompraResponse();
		List<AlmacenOrdenCompra> almacenOrdenCompraList = almacenOrdenCompraMapper
				.listarAlmacenOrdenCompra(request.getIdAlmacenOrdenCompra(),
						request.getEstado(), request.getNuPagina(),
						request.getNuRegisMostrar());

		response.setAlmacenOrdenCompraList(almacenOrdenCompraList);
		System.out.println(request.getIdAlmacenOrdenCompra());
		return response;
	}

	@Override
	public ListarAlmacenOrdenCompraMaterialResponse listarAlmacenOrdenCompraMaterial(
			ListarAlmacenOrdenCompraMaterialRequest request) throws Exception {
		ListarAlmacenOrdenCompraMaterialResponse response = new ListarAlmacenOrdenCompraMaterialResponse();
		List<AlmacenOrdenCompraMaterial> almacenOrdenCompraMaterialList = almacenOrdenCompraMapper
				.listarAlmacenOrdenCompraMaterial(request
						.getIdAlmacenOrdenCompra());
		response.setAlmacenOrdenCompraMaterialList(almacenOrdenCompraMaterialList);
		return response;
	}

	@Override
	public ActualizarCantidadFisicaResponse actualizarCantidadFisica(
			ActualizarCantidadFisicaRequest request) throws Exception {
		ActualizarCantidadFisicaResponse response = new ActualizarCantidadFisicaResponse();
		Confirmacion confirmacion = almacenOrdenCompraMapper
				.actualizarCantidadFisica(
						request.getIdAlmacenOrdenCompraMaterial(),
						request.getIdAlmacenOrdenCompra(),
						request.getIdMaterial(), request.getCantidadFisica());
		response.setConfirmacion(confirmacion);
		return response;
	}

	@Override
	public ActualizarEstadoAlmacenOrdenCompraResponse actualizarEstado(
			ActualizarEstadoAlmacenOrdenCompraRequest request) throws Exception {
		ActualizarEstadoAlmacenOrdenCompraResponse response = new ActualizarEstadoAlmacenOrdenCompraResponse();

		Confirmacion confirmacion = almacenOrdenCompraMapper
				.actualizarEstado(request.getIdAlmacenOrdenCompra());
		response.setConfirmacion(confirmacion);
		return response;
	}
}
