package pe.com.tintegro.sigs.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.com.tintegro.sigs.dao.CptEspecialidadDAO;
import pe.com.tintegro.sigs.dto.request.ListarCptEspecialidadRequest;
import pe.com.tintegro.sigs.dto.response.ListarCptEspecialidadResponse;
import pe.com.tintegro.sigs.entidad.CptEspecialidad;
import pe.com.tintegro.sigs.mapper.CptEspecialidadMapper;

@Repository( "cptEspecialidadDAO" )
@Transactional
public class CptEspecialidadDAOImpl implements CptEspecialidadDAO{

	@Autowired
	CptEspecialidadMapper cptEspecialidadMapper;
	
	@Override
	public ListarCptEspecialidadResponse listarCptEspecialidadResponse(ListarCptEspecialidadRequest request)
			throws Exception {
		ListarCptEspecialidadResponse response = new ListarCptEspecialidadResponse();
		List<CptEspecialidad> listaCptEspecialidad = cptEspecialidadMapper.ListarCptEspecialidad(
				request.getIdEspecialidad(), request.getIdCpt(), request.getIdIPRESS(), request.getNuPagina(), request.getNuRegisMostrar());
		response.setListaCptEspecialidad(listaCptEspecialidad);
		return response;
	}

}
