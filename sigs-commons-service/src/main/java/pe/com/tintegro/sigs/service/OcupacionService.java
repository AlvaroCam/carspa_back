/**
 * 
 */
package pe.com.tintegro.sigs.service;

import pe.com.tintegro.sigs.dto.request.ObtieneOcupacionRequest;
import pe.com.tintegro.sigs.dto.response.ObtieneOcupacionResponse;

/**
 * @author FReyes
 *
 */
public interface OcupacionService 
{
	public ObtieneOcupacionResponse obtenerOcupacion(ObtieneOcupacionRequest request) throws Exception;
	
	public ObtieneOcupacionResponse obtenerOcupacionOfDescripcion(ObtieneOcupacionRequest request) throws Exception;
}
