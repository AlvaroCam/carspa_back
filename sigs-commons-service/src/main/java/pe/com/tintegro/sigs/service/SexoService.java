/**
 * 
 */
package pe.com.tintegro.sigs.service;

import pe.com.tintegro.sigs.dto.request.ObtieneSexoRequest;
import pe.com.tintegro.sigs.dto.response.ObtieneSexoResponse;

/**
 * @author Carlos
 *
 */
public interface SexoService
{
	public ObtieneSexoResponse obtenerSexo(ObtieneSexoRequest request) throws Exception;
}
