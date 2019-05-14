package pe.com.tintegro.sigs.service;

import pe.com.tintegro.sigs.dto.request.ObtieneTipoSangreResquest;
import pe.com.tintegro.sigs.dto.response.ObtieneTipoSangreResponse;

public interface TipoSangreService {
	
	public ObtieneTipoSangreResponse obtenerTipoSangre(ObtieneTipoSangreResquest resquest)throws Exception;

}
