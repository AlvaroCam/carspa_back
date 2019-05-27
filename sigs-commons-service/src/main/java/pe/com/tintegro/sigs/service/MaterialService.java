package pe.com.tintegro.sigs.service;

import pe.com.tintegro.sigs.dto.request.EliminarMaterialRequest;
import pe.com.tintegro.sigs.dto.request.InsertarActualizarMaterialRequest;
import pe.com.tintegro.sigs.dto.request.ListarMaterialRequest;
import pe.com.tintegro.sigs.dto.request.ListarProveedorRequest;
import pe.com.tintegro.sigs.dto.response.InsertarActualizarMaterialResponse;
import pe.com.tintegro.sigs.dto.response.ListarMaterialResponse;
import pe.com.tintegro.sigs.dto.response.ListarProveedorResponse;

public interface MaterialService {
	public InsertarActualizarMaterialResponse activarMaterial(EliminarMaterialRequest request) throws Exception;

	public InsertarActualizarMaterialResponse desactivarMaterial(EliminarMaterialRequest request) throws Exception;

	public InsertarActualizarMaterialResponse insertMaterial(InsertarActualizarMaterialRequest request) throws Exception;

	public InsertarActualizarMaterialResponse updateMaterial(InsertarActualizarMaterialRequest request) throws Exception;

	public ListarMaterialResponse listarMateriales(ListarMaterialRequest request) throws Exception;

	public ListarProveedorResponse comboProveedor(ListarProveedorRequest request) throws Exception;
	
	public ListarMaterialResponse listarMaterialesAlerta(ListarMaterialRequest request) throws Exception;

}
