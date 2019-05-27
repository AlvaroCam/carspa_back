package pe.com.tintegro.sigs.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.com.tintegro.sigs.dao.AnaquelDAO;
import pe.com.tintegro.sigs.dto.request.ActualizarAnaquelRequest;
import pe.com.tintegro.sigs.dto.response.ActualizarAnaquelResponse;
import pe.com.tintegro.sigs.entidad.general.Confirmacion;
import pe.com.tintegro.sigs.mapper.AnaquelMapper;

@Repository("anaquelDAO")
@Transactional
public class AnaquelDAOImpl implements AnaquelDAO {

	@Autowired
	AnaquelMapper anaquelMapper;

	@Override
	public ActualizarAnaquelResponse actualizarAnaquel(ActualizarAnaquelRequest request) throws Exception {
		ActualizarAnaquelResponse response = new ActualizarAnaquelResponse();

		Confirmacion confirmacion = anaquelMapper.actualizarAnaquel(request.getIdAlmacenOrdenCompraMaterial(),
				request.getIdAnaquel());
		response.setConfirmacion(confirmacion);
		return response;
	}

}
