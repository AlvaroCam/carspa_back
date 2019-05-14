package pe.com.tintegro.sigs.dao;

import pe.com.tintegro.sigs.dto.request.ObtenerComboIpressByUsuarioRequest;
import pe.com.tintegro.sigs.dto.response.ObtenerComboIpressByUsuarioResponse;

public interface IpressDAO {
	
	public ObtenerComboIpressByUsuarioResponse obtenerIpress (ObtenerComboIpressByUsuarioRequest request) throws Exception;
}
