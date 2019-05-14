package pe.com.tintegro.sigs.service;

import pe.com.tintegro.sigs.dto.request.ObtieneTipoDocumentoRequest;
import pe.com.tintegro.sigs.dto.response.ObtieneTipoDocumentoResponse;

public interface TipoDocumentoService {

	public ObtieneTipoDocumentoResponse obtenerTipoDocumento (
			ObtieneTipoDocumentoRequest request) throws Exception;

}
