package pe.com.tintegro.sigs.dao;

import pe.com.tintegro.sigs.dto.request.ListarCptEspecialidadRequest;
import pe.com.tintegro.sigs.dto.response.ListarCptEspecialidadResponse;

public interface CptEspecialidadDAO {
	public ListarCptEspecialidadResponse listarCptEspecialidadResponse(ListarCptEspecialidadRequest request) throws Exception;
}
