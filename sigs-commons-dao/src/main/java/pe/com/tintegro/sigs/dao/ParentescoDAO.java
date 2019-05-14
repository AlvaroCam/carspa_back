/**
 * 
 */
package pe.com.tintegro.sigs.dao;

import pe.com.tintegro.sigs.dto.request.ObtieneParentescoRequest;
import pe.com.tintegro.sigs.dto.response.ObtieneParentescoResponse;

/**
 * @author FReyes
 *
 */
public interface ParentescoDAO 
{
	public ObtieneParentescoResponse obtenerParentesco(ObtieneParentescoRequest request) throws Exception;
}
