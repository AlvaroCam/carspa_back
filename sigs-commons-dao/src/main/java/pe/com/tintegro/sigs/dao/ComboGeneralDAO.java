package pe.com.tintegro.sigs.dao;

import pe.com.tintegro.sigs.dto.request.ObtenerComboGeneralRequest;
import pe.com.tintegro.sigs.dto.request.ObtenerComboTipoDocumentoIdentidadRequest;
import pe.com.tintegro.sigs.dto.response.ObtenerComboGeneralResponse;
import pe.com.tintegro.sigs.dto.response.ObtenerComboTipoDocumentoIdentidadResponse;
/**
 * @author Miguel Mascco
 *
 * 12 ene. 2018
 */
public interface ComboGeneralDAO
{
	 public ObtenerComboGeneralResponse obtenerComboGeneral (ObtenerComboGeneralRequest request) throws Exception;
	 public ObtenerComboTipoDocumentoIdentidadResponse obtenerComboTipoDocumento (ObtenerComboTipoDocumentoIdentidadRequest request) throws Exception;
}
