package pe.com.tintegro.sigs.service;

import pe.com.tintegro.sigs.dto.request.ListarCptEspecialidadRequest;
import pe.com.tintegro.sigs.dto.response.ListarCptEspecialidadResponse;

public interface CptEspecialidadService {
	public ListarCptEspecialidadResponse listarCptEspecialidadResponse(ListarCptEspecialidadRequest request) throws Exception;
}
