/**
 * 
 */
package pe.com.tintegro.sigs.service;

import pe.com.tintegro.sigs.dto.request.ObtieneGradoInstruccionRequest;
import pe.com.tintegro.sigs.dto.response.ObtieneGradoInstruccionResponse;

/**
 * @author FReyes
 *
 */
public interface GradoInstruccionService 
{
	public ObtieneGradoInstruccionResponse obtenerGradoInstruccion(ObtieneGradoInstruccionRequest request) throws Exception;
}
