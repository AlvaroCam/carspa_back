package pe.com.tintegro.sigs.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.com.tintegro.sigs.dao.TipoDocumentoDAO;
import pe.com.tintegro.sigs.dto.request.ObtieneTipoDocumentoRequest;
import pe.com.tintegro.sigs.dto.response.ObtieneTipoDocumentoResponse;
import pe.com.tintegro.sigs.entidad.general.Item;
import pe.com.tintegro.sigs.mapper.TipoDocumentoMapper;

@Repository("tipoDocumentoDAO")
@Transactional
public class TipoDocumentoDAOImpl implements TipoDocumentoDAO{
	
	@Autowired
	private TipoDocumentoMapper tipoDocumentoMapper;

	@Override
	public ObtieneTipoDocumentoResponse obtieneTipoDocumento( ObtieneTipoDocumentoRequest request) throws Exception 
	{
		ObtieneTipoDocumentoResponse response = new ObtieneTipoDocumentoResponse();
		
		List<Item> tipoDocumento = tipoDocumentoMapper.obtenerTipoDocumento();
		
		response.setTipoDocumentoList(tipoDocumento);
		
		return response;
	}
}
