/**
 * 
 */
package pe.com.tintegro.sigs.service;

import pe.com.tintegro.sigs.dto.request.ObtienePersonalesRequest;
import pe.com.tintegro.sigs.dto.response.ObtienePersonalesResponse;

/**
 * @author daniel - 18 set. 2017
 *
 */
public interface PersonalService
{
	public ObtienePersonalesResponse obtenerPersonales( ObtienePersonalesRequest request ) throws Exception;
}
