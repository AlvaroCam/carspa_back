/**
 * 
 */
package pe.com.tintegro.sigs.service;

import pe.com.tintegro.sigs.dto.request.ObtieneParentescoRequest;
import pe.com.tintegro.sigs.dto.response.ObtieneParentescoResponse;

/**
 * @author FReyes
 *
 */
public interface ParentescoService 
{
	public ObtieneParentescoResponse obtenerParentesco(ObtieneParentescoRequest request) throws Exception;
}
