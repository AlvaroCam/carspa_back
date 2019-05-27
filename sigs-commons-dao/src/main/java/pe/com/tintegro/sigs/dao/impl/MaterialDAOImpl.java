package pe.com.tintegro.sigs.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import pe.com.tintegro.sigs.dao.MaterialDAO;
import pe.com.tintegro.sigs.dto.request.EliminarMaterialRequest;
import pe.com.tintegro.sigs.dto.request.InsertarActualizarMaterialRequest;
import pe.com.tintegro.sigs.dto.request.ListarMaterialRequest;
import pe.com.tintegro.sigs.dto.request.ListarProveedorRequest;
import pe.com.tintegro.sigs.dto.response.InsertarActualizarMaterialResponse;
import pe.com.tintegro.sigs.dto.response.ListarMaterialResponse;
import pe.com.tintegro.sigs.dto.response.ListarProveedorResponse;
import pe.com.tintegro.sigs.entidad.Material;
import pe.com.tintegro.sigs.entidad.Proveedor;
import pe.com.tintegro.sigs.entidad.general.Confirmacion;
import pe.com.tintegro.sigs.mapper.MaterialMapper;


@Repository( "materialDAO" )
@Transactional
public class MaterialDAOImpl implements MaterialDAO{

	@Autowired
	MaterialMapper materialMapper;
	
	@Override
	public InsertarActualizarMaterialResponse activarMaterial(EliminarMaterialRequest request)
			throws Exception {
		InsertarActualizarMaterialResponse response = new InsertarActualizarMaterialResponse();
		Confirmacion confirmacion = materialMapper.activarMaterial(request.getIdMaterial());
		response.setConfirmacion(confirmacion);
		return response;
	}

	@Override
	public InsertarActualizarMaterialResponse desactivarMaterial(EliminarMaterialRequest request)
			throws Exception {
		InsertarActualizarMaterialResponse response = new InsertarActualizarMaterialResponse();
		Confirmacion confirmacion = materialMapper.desactivarMaterial(request.getIdMaterial());
		response.setConfirmacion(confirmacion);
		return response;
	}

	@Override
	public InsertarActualizarMaterialResponse updateMaterial(InsertarActualizarMaterialRequest request)
			throws Exception {
		InsertarActualizarMaterialResponse response = new InsertarActualizarMaterialResponse();
		Confirmacion confirmacion = materialMapper.updateMaterial(request.getMaterial().getIdMaterial(),request.getMaterial().getCodigo(), request.getMaterial().getStockMaximo(), request.getMaterial().getStockMinimo(), request.getMaterial().getPuntoPedido(), 
				 request.getMaterial().getNombre(), request.getMaterial().getMarca(), request.getMaterial().getStock(), request.getMaterial().getDescripcion());

		response.setConfirmacion(confirmacion);
		return response;
	}

	@Override
	public ListarMaterialResponse listarMateriales(ListarMaterialRequest request)
			throws Exception {
		ListarMaterialResponse response = new ListarMaterialResponse();
		List<Material>listaMateriales=materialMapper.listarMateriales(request.getNombre(), request.getEstado(), request.getNuPagina(), request.getNuRegisMostrar());
		response.setMateriales(listaMateriales);
		return response;
	}

	@Override
	public ListarProveedorResponse comboProveedor(ListarProveedorRequest request)
			throws Exception {
		ListarProveedorResponse response = new ListarProveedorResponse();
		List<Proveedor> proveedores=materialMapper.comboProveedor();
		response.setProveedorList(proveedores);
		return response;
	}

	@Override
	public InsertarActualizarMaterialResponse insertMaterial(
			InsertarActualizarMaterialRequest request) throws Exception {
		InsertarActualizarMaterialResponse response = new InsertarActualizarMaterialResponse();
		Confirmacion confirmacion = materialMapper.insertMaterial(request.getMaterial().getCodigo(), request.getMaterial().getStockMaximo(), request.getMaterial().getStockMinimo(), request.getMaterial().getPuntoPedido(), 
				 request.getMaterial().getNombre(), request.getMaterial().getMarca(), request.getMaterial().getStock(), request.getMaterial().getDescripcion());

		response.setConfirmacion(confirmacion);
		return response;
	}

	@Override
	public ListarMaterialResponse listarMaterialesAlerta(
			ListarMaterialRequest request) throws Exception {
		ListarMaterialResponse response = new ListarMaterialResponse();
		List<Material>listaMateriales=materialMapper.listarMaterialesAlerta(request.getNombre(), request.getEstado(), request.getNuPagina(), request.getNuRegisMostrar());
		response.setMateriales(listaMateriales);
		return response;
	}
}
