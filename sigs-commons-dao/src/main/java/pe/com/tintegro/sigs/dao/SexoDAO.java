/**
 * 
 */
package pe.com.tintegro.sigs.dao;

import pe.com.tintegro.sigs.dto.request.ObtieneSexoRequest;
import pe.com.tintegro.sigs.dto.response.ObtieneSexoResponse;

/**
 * @author Carlos
 *
 */
public interface SexoDAO
{
	public ObtieneSexoResponse obtenerSexo(ObtieneSexoRequest request) throws Exception;
}
