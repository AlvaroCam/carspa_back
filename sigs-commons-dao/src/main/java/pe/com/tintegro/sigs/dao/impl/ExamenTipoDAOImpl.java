package pe.com.tintegro.sigs.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.com.tintegro.sigs.dao.ExamenTipoDAO;
import pe.com.tintegro.sigs.dto.request.ObtieneExamenTiposRequest;
import pe.com.tintegro.sigs.dto.response.ObtieneExamenTiposResponse;
import pe.com.tintegro.sigs.mapper.ExamenTipoMapper;

@Transactional
@Repository("examenTipoDAO")
public class ExamenTipoDAOImpl implements ExamenTipoDAO 
{
	
	@Autowired
	private ExamenTipoMapper examenTipoMapper;
	
	@Override
	public ObtieneExamenTiposResponse obtenerExamenTipos(ObtieneExamenTiposRequest request) throws Exception {
		ObtieneExamenTiposResponse response = new ObtieneExamenTiposResponse();
		response.setExamenTipoList(examenTipoMapper.obtenerExamenTipos(request.getIdExamenTipo()));
		return response;
	}

}
