/**
 * 
 */
package pe.com.tintegro.sigs.service;

import pe.com.tintegro.sigs.dto.request.InsertarTurnoRequest;
import pe.com.tintegro.sigs.dto.request.ObtieneTurnoRequest;
import pe.com.tintegro.sigs.dto.request.ObtieneTurnosRequest;
import pe.com.tintegro.sigs.dto.response.InsertarTurnoResponse;
import pe.com.tintegro.sigs.dto.response.ObtieneTurnoResponse;
import pe.com.tintegro.sigs.dto.response.ObtieneTurnosResponse;

/**
 * @author daniel - 15 set. 2017
 *
 */
public interface TurnoService
{
	public ObtieneTurnosResponse obtenerTurnos( ObtieneTurnosRequest request ) throws Exception;
	
	public ObtieneTurnoResponse obtenerTurno( ObtieneTurnoRequest request ) throws Exception;
	
	public InsertarTurnoResponse insertarTurno( InsertarTurnoRequest request) throws Exception;
}
