package pe.com.tintegro.sigs.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.com.tintegro.sigs.dao.ComboGeneralDAO;
import pe.com.tintegro.sigs.dto.request.ObtenerComboGeneralRequest;
import pe.com.tintegro.sigs.dto.request.ObtenerComboTipoDocumentoIdentidadRequest;
import pe.com.tintegro.sigs.dto.response.ObtenerComboGeneralResponse;
import pe.com.tintegro.sigs.dto.response.ObtenerComboTipoDocumentoIdentidadResponse;
import pe.com.tintegro.sigs.entidad.ComboGeneral;
import pe.com.tintegro.sigs.mapper.ComboGeneralMapper;

@Transactional
@Repository("comboGeneralDAO")
public class ComboGeneralDAOImpl implements ComboGeneralDAO
{
	@Autowired
	private ComboGeneralMapper comboGeneralMapper;

	@Override
	public ObtenerComboGeneralResponse obtenerComboGeneral(ObtenerComboGeneralRequest request) throws Exception
	{
		ObtenerComboGeneralResponse response = new ObtenerComboGeneralResponse();
		List<ComboGeneral> lsComboGeneral = comboGeneralMapper.obtenerComboGeneral(request.getIdGrupoOpcion());
		response.setLsComboGeneral(lsComboGeneral);
		return response;
	}

	@Override
	public ObtenerComboTipoDocumentoIdentidadResponse obtenerComboTipoDocumento(ObtenerComboTipoDocumentoIdentidadRequest request) throws Exception {
		ObtenerComboTipoDocumentoIdentidadResponse response = new ObtenerComboTipoDocumentoIdentidadResponse();
		List<ComboGeneral> lsComboTipoDoc = comboGeneralMapper.obtenerComboTipoDocumentoIdentidad();
		response.setLsComboTipoDoc(lsComboTipoDoc);
		return response;
	}

}
