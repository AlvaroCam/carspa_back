/**
 * 
 */
package pe.com.tintegro.sigs.dao;

import pe.com.tintegro.sigs.dto.request.ObtieneUbigeoRequest;
import pe.com.tintegro.sigs.dto.response.ObtieneUbigeoResponse;

/**
 * @author Carlos
 *
 */
public interface UbigeoDAO
{
	public ObtieneUbigeoResponse obtenerUbigeo(ObtieneUbigeoRequest request) throws Exception;
}
