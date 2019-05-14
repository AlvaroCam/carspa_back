/**
 * 
 */
package pe.com.tintegro.sigs.dao;

import pe.com.tintegro.sigs.dto.request.ObtieneEstadoCivilRequest;
import pe.com.tintegro.sigs.dto.response.ObtieneEstadoCivilResponse;

/**
 * @author Carlos
 *
 */
public interface EstadoCivilDAO
{
	public ObtieneEstadoCivilResponse obtenerEstadoCivil(ObtieneEstadoCivilRequest request) throws Exception;
}
