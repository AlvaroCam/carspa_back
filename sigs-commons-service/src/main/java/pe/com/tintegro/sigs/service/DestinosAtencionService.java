package pe.com.tintegro.sigs.service;

import pe.com.tintegro.sigs.dto.request.ObtenerComboDestinosAtencionRequest;
import pe.com.tintegro.sigs.dto.response.ObtenerComboDestinosAtencionResponse;

public interface DestinosAtencionService {
	
	public ObtenerComboDestinosAtencionResponse obtenerDestinos (ObtenerComboDestinosAtencionRequest request)throws Exception;

}
