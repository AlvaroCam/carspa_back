package pe.com.tintegro.sigs.service;

import pe.com.tintegro.sigs.dto.request.ObtenerComboIpressByUsuarioRequest;
import pe.com.tintegro.sigs.dto.response.ObtenerComboIpressByUsuarioResponse;

public interface IpressService {

	ObtenerComboIpressByUsuarioResponse obtenerIpress (ObtenerComboIpressByUsuarioRequest request)throws Exception;
}
