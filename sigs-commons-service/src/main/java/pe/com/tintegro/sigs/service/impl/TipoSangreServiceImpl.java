package pe.com.tintegro.sigs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.tintegro.sigs.dao.TipoSangreDAO;
import pe.com.tintegro.sigs.dto.request.ObtieneTipoSangreResquest;
import pe.com.tintegro.sigs.dto.response.ObtieneTipoSangreResponse;
import pe.com.tintegro.sigs.service.TipoSangreService;

@Service("tipoSangreService")
public class TipoSangreServiceImpl implements TipoSangreService{

	@Autowired
	private TipoSangreDAO tipoSangreDAO;

	@Override
	public ObtieneTipoSangreResponse obtenerTipoSangre(
			ObtieneTipoSangreResquest resquest) throws Exception {
		return tipoSangreDAO.obtenerTipoSangre(resquest);
	}

}
