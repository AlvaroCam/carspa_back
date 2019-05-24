package pe.com.tintegro.sigs.dao;

import pe.com.tintegro.sigs.dto.request.EliminarMaquinariaRequest;
import pe.com.tintegro.sigs.dto.request.InsertarActualizarMaquinariaRequest;
import pe.com.tintegro.sigs.dto.request.ListarMaquinariaRequest;
import pe.com.tintegro.sigs.dto.response.InsertarActualizarMaquinariaResponse;
import pe.com.tintegro.sigs.dto.response.ListarMaquinariaResponse;

public interface MaquinariaDAO {

	public InsertarActualizarMaquinariaResponse desactivarMaquinaria(EliminarMaquinariaRequest request)throws Exception;
	
	public InsertarActualizarMaquinariaResponse activarMaquinaria(EliminarMaquinariaRequest request)throws Exception;
	
	public InsertarActualizarMaquinariaResponse insertMaquinaria(InsertarActualizarMaquinariaRequest request)throws Exception;
	
	public InsertarActualizarMaquinariaResponse updateMaquinaria(InsertarActualizarMaquinariaRequest request)throws Exception;

	public ListarMaquinariaResponse listarMaquinaria(ListarMaquinariaRequest request)throws Exception;
}

