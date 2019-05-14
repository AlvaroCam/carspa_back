package pe.com.tintegro.sigs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.tintegro.sigs.constants.ResponseEstado;
import pe.com.tintegro.sigs.dao.ComboGeneralDAO;
import pe.com.tintegro.sigs.dto.request.ObtenerComboGeneralRequest;
import pe.com.tintegro.sigs.dto.request.ObtenerComboTipoDocumentoIdentidadRequest;
import pe.com.tintegro.sigs.dto.response.ObtenerComboGeneralResponse;
import pe.com.tintegro.sigs.dto.response.ObtenerComboTipoDocumentoIdentidadResponse;
import pe.com.tintegro.sigs.service.ComboGeneralService;
import pe.com.tintegro.sigs.util.EncriptacionUtil;

@Service("comboGeneralService")
public class ComboGeneralServiceImpl implements ComboGeneralService
{
	@Autowired
	private ComboGeneralDAO comboGeneralDAO;

	@Override
	public ObtenerComboGeneralResponse obtenerComboGeneral(ObtenerComboGeneralRequest request) throws Exception
	{
		request.setIdIPRESS(EncriptacionUtil.desencriptar(request.getIdIPRESS()));
		ObtenerComboGeneralResponse response = comboGeneralDAO.obtenerComboGeneral(request);
		if (response.getLsComboGeneral().size() == 0)
		{
			response.setEstado(ResponseEstado.ERROR_NEGOCIO);
			response.setMensaje("No se ha podido listar los elementos de combo general");
		}
		else
		{
			response.setEstado(ResponseEstado.OK);
			response.setMensaje("Elementos del combo general obtenidos correctamente");
		}
		return response;
	}

	@Override
	public ObtenerComboTipoDocumentoIdentidadResponse obtenerComboTipoDocumento(ObtenerComboTipoDocumentoIdentidadRequest request) throws Exception {
		request.setIdIPRESS(EncriptacionUtil.desencriptar(request.getIdIPRESS()));
		ObtenerComboTipoDocumentoIdentidadResponse response = comboGeneralDAO.obtenerComboTipoDocumento(request);
		if (response.getLsComboTipoDoc().size() == 0) {
			response.setEstado(ResponseEstado.ERROR_NEGOCIO);
			response.setMensaje("No se ha podido listar los elementos de combo tipo documento");
		} else {
			response.setEstado(ResponseEstado.OK);
			response.setMensaje("Elementos del combo general obtenidos correctamente");
		}
		return response;
	}

}
