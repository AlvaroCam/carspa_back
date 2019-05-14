/**
 * 
 */
package pe.com.tintegro.sigs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.tintegro.sigs.constants.ResponseEstado;
import pe.com.tintegro.sigs.dao.TurnoDAO;
import pe.com.tintegro.sigs.dto.request.InsertarTurnoRequest;
import pe.com.tintegro.sigs.dto.request.ObtieneTurnoRequest;
import pe.com.tintegro.sigs.dto.request.ObtieneTurnosRequest;
import pe.com.tintegro.sigs.dto.response.InsertarTurnoResponse;
import pe.com.tintegro.sigs.dto.response.ObtieneTurnoResponse;
import pe.com.tintegro.sigs.dto.response.ObtieneTurnosResponse;
import pe.com.tintegro.sigs.entidad.general.Item;
import pe.com.tintegro.sigs.service.TurnoService;
import pe.com.tintegro.sigs.util.EncriptacionUtil;

/**
 * @author daniel - 15 set. 2017
 *
 */
@Service( "turnoService" )
public class TurnoServiceImpl implements TurnoService
{
	@Autowired
	private TurnoDAO turnoDAO;
	
	@Override
	public ObtieneTurnosResponse obtenerTurnos(ObtieneTurnosRequest request) throws Exception
	{
//		ObtieneTurnosResponse response = new ObtieneTurnosResponse();
//		
//		request.setIdIPRESS( EncriptacionUtil.desencriptar( request.getIdIPRESS() ) );
//		
//		List<Item> turnoList = turnoDAO.obtenerTurnos( null );
//		response.setTurnoList( turnoList );
//		
		return null;
	}

	@Override
	public ObtieneTurnoResponse obtenerTurno(ObtieneTurnoRequest request) throws Exception
	{
//		ObtieneTurnoResponse response = new ObtieneTurnoResponse();
		
		request.setIdIPRESS( EncriptacionUtil.desencriptar( request.getIdIPRESS() ) );
		
//		List<Item> turnoList = turnoDAO.obtenerTurnos(request);
//		Item turno = turnoList.isEmpty() ? null : turnoList.get( 0 );
//		
//		if( turno == null )
//		{
//			response.setEstado( ResponseEstado.ERROR_NEGOCIO );
//			response.setMensaje( "Turno no encontrado." );
//		}
//		else
//		{
//			response.setEstado( ResponseEstado.OK );
//			response.setMensaje( "Turno obtenido correctamente." );
//		}
//		
//		response.setTurno( turno );
		
		return turnoDAO.obtenerTurnos(request);
	}

	@Override
	public InsertarTurnoResponse insertarTurno(InsertarTurnoRequest request)
			throws Exception {
		request.setIdIPRESS( EncriptacionUtil.desencriptar( request.getIdIPRESS() ) );
		return turnoDAO.insertarTurno(request);
	}
}
