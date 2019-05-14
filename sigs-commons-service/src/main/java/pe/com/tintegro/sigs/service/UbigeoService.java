/**
 * 
 */
package pe.com.tintegro.sigs.service;

import pe.com.tintegro.sigs.dto.request.ObtieneUbigeoRequest;
import pe.com.tintegro.sigs.dto.response.ObtieneUbigeoResponse;

/**
 * @author Carlos
 *
 */
public interface UbigeoService
{
	public ObtieneUbigeoResponse obtenerUbigeo(ObtieneUbigeoRequest request) throws Exception;;
}
