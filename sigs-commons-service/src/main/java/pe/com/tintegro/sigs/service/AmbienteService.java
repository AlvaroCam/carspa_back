/**
 * 
 */
package pe.com.tintegro.sigs.service;

import pe.com.tintegro.sigs.dto.request.ActualizarAmbienteRequest;
import pe.com.tintegro.sigs.dto.request.EliminarAmbienteRequest;
import pe.com.tintegro.sigs.dto.request.InsertarAmbienteRequest;
import pe.com.tintegro.sigs.dto.request.ObtieneActividadAmbienteRequest;
import pe.com.tintegro.sigs.dto.request.ObtieneAmbienteEspecialidadRequest;
import pe.com.tintegro.sigs.dto.request.ObtieneAmbienteRequest;
import pe.com.tintegro.sigs.dto.request.ObtieneAmbientesRequest;
import pe.com.tintegro.sigs.dto.response.ActualizarAmbienteResponse;
import pe.com.tintegro.sigs.dto.response.EliminarAmbienteResponse;
import pe.com.tintegro.sigs.dto.response.InsertarAmbienteResponse;
import pe.com.tintegro.sigs.dto.response.ObtieneActividadAmbienteResponse;
import pe.com.tintegro.sigs.dto.response.ObtieneAmbienteEspecialidadResponse;
import pe.com.tintegro.sigs.dto.response.ObtieneAmbienteResponse;
import pe.com.tintegro.sigs.dto.response.ObtieneAmbientesResponse;

/**
 * @author daniel - 15 set. 2017
 *
 */
public interface AmbienteService
{
	public ObtieneAmbientesResponse obtenerAmbientes( ObtieneAmbientesRequest request ) throws Exception;
	public ObtieneAmbienteResponse obtenerAmbiente( ObtieneAmbienteRequest request ) throws Exception;
	public ObtieneAmbienteEspecialidadResponse obtenerAmbienteEspecialidad(ObtieneAmbienteEspecialidadRequest request)throws Exception;
	public InsertarAmbienteResponse insertaAmbiente(InsertarAmbienteRequest request)throws Exception;
	public ObtieneActividadAmbienteResponse obtenerActividadAmbiente(ObtieneActividadAmbienteRequest request)throws Exception;
	public EliminarAmbienteResponse eliminaAmbiente(EliminarAmbienteRequest request)throws Exception;
	public ActualizarAmbienteResponse actualizarAmbiente(ActualizarAmbienteRequest request)throws Exception;
}
