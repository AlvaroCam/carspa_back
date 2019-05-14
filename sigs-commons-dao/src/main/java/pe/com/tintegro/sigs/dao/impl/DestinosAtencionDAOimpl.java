package pe.com.tintegro.sigs.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.com.tintegro.sigs.dao.DestinosAtencionDAO;
import pe.com.tintegro.sigs.dto.request.ObtenerComboDestinosAtencionRequest;
import pe.com.tintegro.sigs.dto.response.ObtenerComboDestinosAtencionResponse;
import pe.com.tintegro.sigs.entidad.general.Item;
import pe.com.tintegro.sigs.mapper.DestinosAtencionMapper;

@Repository("destinosAtencionDAO")
@Transactional
public class DestinosAtencionDAOimpl implements DestinosAtencionDAO{
	
	@Autowired
	private DestinosAtencionMapper destinoAtencionMapper;
	
	@Override
	public ObtenerComboDestinosAtencionResponse obtenerDestinos(
			ObtenerComboDestinosAtencionRequest request) throws Exception {
		ObtenerComboDestinosAtencionResponse response = new ObtenerComboDestinosAtencionResponse();
		List<Item> listDestinos = destinoAtencionMapper.obtenerDestinos();
		response.setListDestinos(listDestinos);
		return response;
	}

}
