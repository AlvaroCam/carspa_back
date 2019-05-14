package pe.com.tintegro.sigs.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.com.tintegro.sigs.dao.ExamenAreaDAO;
import pe.com.tintegro.sigs.dto.request.ObtieneExamenAreasRequest;
import pe.com.tintegro.sigs.dto.response.ObtieneExamenAreasResponse;
import pe.com.tintegro.sigs.entidad.general.Item;
import pe.com.tintegro.sigs.mapper.ExamenAreaMapper;

@Transactional
@Repository("examenAreaDAO")
public class ExamenAreaDAOImpl implements ExamenAreaDAO 
{
	@Autowired
	private ExamenAreaMapper examenAreaMapper;
	@Override
	public ObtieneExamenAreasResponse obtenerExamenAreas(ObtieneExamenAreasRequest request) throws Exception 
	{
		ObtieneExamenAreasResponse response = new ObtieneExamenAreasResponse();
		List<Item> examenAreaList = examenAreaMapper.obtenerExamenAreas(request.getIdExamenArea(), request.getIdExamenTipo());
		response.setExamenAreaList(examenAreaList);
		return response;
	}

}
