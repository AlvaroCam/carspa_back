package pe.com.tintegro.sigs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.tintegro.sigs.dao.TipoDocumentoDAO;
import pe.com.tintegro.sigs.dto.request.ObtieneTipoDocumentoRequest;
import pe.com.tintegro.sigs.dto.response.ObtieneTipoDocumentoResponse;
import pe.com.tintegro.sigs.service.TipoDocumentoService;

@Service("tipoDocumentoService")
public class TipoDocumentoServiceImpl implements TipoDocumentoService{

	@Autowired
	private TipoDocumentoDAO tipoDocumentoDAO;
	
	@Override
	public ObtieneTipoDocumentoResponse obtenerTipoDocumento(
			ObtieneTipoDocumentoRequest request) throws Exception {
		ObtieneTipoDocumentoResponse response = tipoDocumentoDAO.obtieneTipoDocumento(request);
		return response;
	}

}
