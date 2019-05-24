package pe.com.tintegro.sigs.dao;

import pe.com.tintegro.sigs.dto.request.ListarProveedorRequest;

import pe.com.tintegro.sigs.dto.response.ListarProveedorResponse;


public interface ProveedorDAO {
	ListarProveedorResponse listarProveedor(
			ListarProveedorRequest request) throws Exception;

	
	
}
