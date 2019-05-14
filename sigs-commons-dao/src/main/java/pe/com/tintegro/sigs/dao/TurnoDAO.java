/**
 * 
 */
package pe.com.tintegro.sigs.dao;

import java.util.List;

import pe.com.tintegro.sigs.dto.request.InsertarTurnoRequest;
import pe.com.tintegro.sigs.dto.request.ObtieneTurnoRequest;
import pe.com.tintegro.sigs.dto.response.InsertarTurnoResponse;
import pe.com.tintegro.sigs.dto.response.ObtieneTurnoResponse;
import pe.com.tintegro.sigs.entidad.general.Item;

/**
 * @author daniel - 14 set. 2017
 *
 */
public interface TurnoDAO
{
	public ObtieneTurnoResponse obtenerTurnos( ObtieneTurnoRequest request ) throws Exception;
	
	public InsertarTurnoResponse insertarTurno( InsertarTurnoRequest request) throws Exception;
}
