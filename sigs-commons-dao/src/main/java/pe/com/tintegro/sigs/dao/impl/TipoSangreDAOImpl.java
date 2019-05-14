package pe.com.tintegro.sigs.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.com.tintegro.sigs.dao.TipoSangreDAO;
import pe.com.tintegro.sigs.dto.request.ObtieneTipoSangreResquest;
import pe.com.tintegro.sigs.dto.response.ObtieneTipoSangreResponse;
import pe.com.tintegro.sigs.entidad.general.Item;
import pe.com.tintegro.sigs.mapper.TipoSangreMapper;


@Repository("tipoSangreDAO")
@Transactional
public class TipoSangreDAOImpl implements TipoSangreDAO{
	
	@Autowired
	private TipoSangreMapper tipoSangreMapper;
	
	@Override
	public ObtieneTipoSangreResponse obtenerTipoSangre(
			ObtieneTipoSangreResquest request) throws Exception {
		ObtieneTipoSangreResponse response = new ObtieneTipoSangreResponse();
		List<Item> listTipoSangre = tipoSangreMapper.obtenerTipoSangre();
		response.setTipoSangre(listTipoSangre);
		return response;
	}

}
