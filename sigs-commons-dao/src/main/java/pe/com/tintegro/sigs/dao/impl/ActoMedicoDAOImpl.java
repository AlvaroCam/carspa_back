package pe.com.tintegro.sigs.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.com.tintegro.sigs.dao.ActoMedicoDAO;
import pe.com.tintegro.sigs.dto.request.ObtieneActoMedicoPorCitaRequest;
import pe.com.tintegro.sigs.dto.response.ObtieneActoMedicoPorCitaResponse;
import pe.com.tintegro.sigs.entidad.ActoMedico;
import pe.com.tintegro.sigs.mapper.ActoMedicoMapper;

@Transactional
@Repository("actoMedicoDAO")
public class ActoMedicoDAOImpl implements ActoMedicoDAO
{
	@Autowired
	private ActoMedicoMapper actoMedicoMapper;
	
	@Override
	public ObtieneActoMedicoPorCitaResponse obtenerActoMedicoPorCita(ObtieneActoMedicoPorCitaRequest request)
			throws Exception
	{
		ObtieneActoMedicoPorCitaResponse response = new ObtieneActoMedicoPorCitaResponse();
		ActoMedico actoMedico = actoMedicoMapper.obtenerActoMedicoPorCita(request.getIdCita());
		response.setActoMedico(actoMedico);
		return response;
	}

}
