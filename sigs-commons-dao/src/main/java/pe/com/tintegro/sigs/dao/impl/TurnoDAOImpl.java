/**
 * 
 */
package pe.com.tintegro.sigs.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.com.tintegro.sigs.dao.TurnoDAO;
import pe.com.tintegro.sigs.dto.request.InsertarTurnoRequest;
import pe.com.tintegro.sigs.dto.request.ObtieneTurnoRequest;
import pe.com.tintegro.sigs.dto.response.InsertarTurnoResponse;
import pe.com.tintegro.sigs.dto.response.ObtieneTurnoResponse;
import pe.com.tintegro.sigs.entidad.general.Confirmacion;
import pe.com.tintegro.sigs.entidad.general.Item;
import pe.com.tintegro.sigs.mapper.TurnoMapper;

/**
 * @author daniel - 14 set. 2017
 *
 */
@Repository( "turnoDAO" )
@Transactional
public class TurnoDAOImpl implements TurnoDAO
{
	@Autowired
	private TurnoMapper turnoMapper;

	@Override
	public ObtieneTurnoResponse obtenerTurnos(ObtieneTurnoRequest request)
			throws Exception {
		ObtieneTurnoResponse response = new ObtieneTurnoResponse();
		List<Item> turnosList = turnoMapper.obtenerTurnos( request.getIdTurno(), request.getIdActividad());
		response.setTurno(turnosList);
		return response;
	}

	@Override
	public InsertarTurnoResponse insertarTurno(InsertarTurnoRequest request)
			throws Exception {
		InsertarTurnoResponse response = new InsertarTurnoResponse();
		Confirmacion confirmar = turnoMapper.insertarTurno(request.getHo_inicio(), request.getHo_final(),request.getIdActividad());
		response.setConfirmacion(confirmar);
		return response;
	}
}
