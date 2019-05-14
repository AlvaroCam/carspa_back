package pe.com.tintegro.sigs.dao;

import pe.com.tintegro.sigs.dto.request.ObtenerComboDestinosAtencionRequest;
import pe.com.tintegro.sigs.dto.response.ObtenerComboDestinosAtencionResponse;

public interface DestinosAtencionDAO {
	
	public ObtenerComboDestinosAtencionResponse obtenerDestinos (ObtenerComboDestinosAtencionRequest request)throws Exception;
}
