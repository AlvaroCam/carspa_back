package pe.com.tintegro.sigs.dao;

import pe.com.tintegro.sigs.dto.request.ObtieneMedicamentoDispositivoRequest;
import pe.com.tintegro.sigs.dto.response.ObtieneMedicamentoDispositivoResponse;

public interface MedicamentoDispositivoDAO
{
	public ObtieneMedicamentoDispositivoResponse obtenerMedicamentoDispMedicoProdSanitario(ObtieneMedicamentoDispositivoRequest request) throws Exception;
	
} 
