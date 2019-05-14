/**
 * 
 */
package pe.com.tintegro.sigs.service;

import pe.com.tintegro.sigs.dto.request.ObtieneEstadoCivilRequest;
import pe.com.tintegro.sigs.dto.response.ObtieneEstadoCivilResponse;

/**
 * @author Carlos
 *
 */
public interface EstadoCivilService
{
	public ObtieneEstadoCivilResponse obtenerEstadoCivil(ObtieneEstadoCivilRequest request) throws Exception;
}
