/**
 * 
 */
package pe.com.tintegro.sigs.dao;

import pe.com.tintegro.sigs.dto.request.ObtieneGradoInstruccionRequest;
import pe.com.tintegro.sigs.dto.response.ObtieneGradoInstruccionResponse;

/**
 * @author FReyes
 *
 */
public interface GradoInstruccionDAO 
{
	public ObtieneGradoInstruccionResponse obtenerGradoInstruccion(ObtieneGradoInstruccionRequest request) throws Exception;
}
