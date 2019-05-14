package pe.com.tintegro.sigs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.tintegro.sigs.dao.CptEspecialidadDAO;
import pe.com.tintegro.sigs.dto.request.ListarCptEspecialidadRequest;
import pe.com.tintegro.sigs.dto.response.ListarCptEspecialidadResponse;
import pe.com.tintegro.sigs.service.CptEspecialidadService;
import pe.com.tintegro.sigs.util.EncriptacionUtil;

@Service( "cptEspecialidadService" )
public class CptEspecialidadServiceImpl implements CptEspecialidadService{
	@Autowired
	private CptEspecialidadDAO cptEspecialidadDAO;
	
	@Override
	public ListarCptEspecialidadResponse listarCptEspecialidadResponse(ListarCptEspecialidadRequest request)
			throws Exception {
		request.setIdIPRESS(EncriptacionUtil.desencriptar(request.getIdIPRESS()));
		
		return cptEspecialidadDAO.listarCptEspecialidadResponse(request);
	}

}
