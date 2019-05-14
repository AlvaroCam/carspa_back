package pe.com.tintegro.sigs.service;

import pe.com.tintegro.sigs.dto.request.ObtieneMedicamentoDispositivoRequest;
import pe.com.tintegro.sigs.dto.response.ObtieneMedicamentoDispositivoResponse;

/**
 * @author Aldo Huamán
 *
 * 12 ene. 2018
 */
public interface MedicamentoDispositivoService
{
	public ObtieneMedicamentoDispositivoResponse obtenerMedicamentoDispMedicoProdSanitario(ObtieneMedicamentoDispositivoRequest request) throws Exception;
	
}
