package pe.com.tintegro.sigs.service;

import pe.com.tintegro.sigs.dto.request.ListarProveedorRequest;

import pe.com.tintegro.sigs.dto.response.ListarProveedorResponse;



public interface ProveedorService {
	ListarProveedorResponse listarProveedor(
			ListarProveedorRequest request) throws Exception;
}
