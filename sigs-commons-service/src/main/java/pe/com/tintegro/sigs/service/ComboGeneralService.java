package pe.com.tintegro.sigs.service;

import pe.com.tintegro.sigs.dto.request.ObtenerComboGeneralRequest;
import pe.com.tintegro.sigs.dto.request.ObtenerComboTipoDocumentoIdentidadRequest;
import pe.com.tintegro.sigs.dto.response.ObtenerComboGeneralResponse;
import pe.com.tintegro.sigs.dto.response.ObtenerComboTipoDocumentoIdentidadResponse;

/**
 * @author miguel - 12 ene. 2017
 *
 */
public interface ComboGeneralService
{
 
	public ObtenerComboGeneralResponse obtenerComboGeneral (ObtenerComboGeneralRequest request) throws Exception;
	public ObtenerComboTipoDocumentoIdentidadResponse obtenerComboTipoDocumento (ObtenerComboTipoDocumentoIdentidadRequest request) throws Exception;
}
