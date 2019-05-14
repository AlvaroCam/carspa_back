package pe.com.tintegro.sigs.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.com.tintegro.sigs.dao.OrigenDAO;
import pe.com.tintegro.sigs.dto.request.ObtieneOrigenesRequest;
import pe.com.tintegro.sigs.dto.response.ObtieneOrigenesResponse;
import pe.com.tintegro.sigs.mapper.OrigenMapper;

@Transactional
@Repository("origenDAO")
public class OrigenDAOImpl implements OrigenDAO
{
	@Autowired
	private OrigenMapper origenMapper;
	
	@Override
	public ObtieneOrigenesResponse obtenerOrigen(ObtieneOrigenesRequest request) throws Exception 
	{
		ObtieneOrigenesResponse response = new ObtieneOrigenesResponse();
		response.setOrigenList(origenMapper.obtenerOrigenes(request.getIdOrigen()));
		return response;
	}

}
