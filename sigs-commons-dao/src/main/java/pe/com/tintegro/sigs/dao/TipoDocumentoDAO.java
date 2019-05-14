package pe.com.tintegro.sigs.dao;

import pe.com.tintegro.sigs.dto.request.ObtieneTipoDocumentoRequest;
import pe.com.tintegro.sigs.dto.response.ObtieneTipoDocumentoResponse;

public interface TipoDocumentoDAO {
	
	public ObtieneTipoDocumentoResponse obtieneTipoDocumento( ObtieneTipoDocumentoRequest request) throws Exception;
}
