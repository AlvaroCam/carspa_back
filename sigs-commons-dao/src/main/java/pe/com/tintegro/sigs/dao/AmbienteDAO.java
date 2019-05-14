package pe.com.tintegro.sigs.dao;

import pe.com.tintegro.sigs.dto.request.ActualizarAmbienteRequest;
import pe.com.tintegro.sigs.dto.request.EliminarAmbienteRequest;
import pe.com.tintegro.sigs.dto.request.InsertarAmbienteRequest;
import pe.com.tintegro.sigs.dto.request.ObtieneActividadAmbienteRequest;
import pe.com.tintegro.sigs.dto.request.ObtieneAmbienteEspecialidadRequest;
import pe.com.tintegro.sigs.dto.request.ObtieneAmbientesRequest;
import pe.com.tintegro.sigs.dto.response.ActualizarAmbienteResponse;
import pe.com.tintegro.sigs.dto.response.EliminarAmbienteResponse;
import pe.com.tintegro.sigs.dto.response.InsertarAmbienteResponse;
import pe.com.tintegro.sigs.dto.response.ObtieneActividadAmbienteResponse;
import pe.com.tintegro.sigs.dto.response.ObtieneAmbienteEspecialidadResponse;
import pe.com.tintegro.sigs.dto.response.ObtieneAmbientesResponse;

public interface AmbienteDAO
{
	public ObtieneAmbientesResponse obtenerAmbientes( ObtieneAmbientesRequest request) throws Exception;
	public ObtieneAmbienteEspecialidadResponse obtenerAmbienteEspecialidad(ObtieneAmbienteEspecialidadRequest request)throws Exception;
	public InsertarAmbienteResponse insertaAmbiente(InsertarAmbienteRequest request)throws Exception;
	public ObtieneActividadAmbienteResponse obtenerActividadAmbiente(ObtieneActividadAmbienteRequest request)throws Exception;
	public EliminarAmbienteResponse eliminaAmbiente(EliminarAmbienteRequest request)throws Exception;
	public ActualizarAmbienteResponse actualizarAmbiente(ActualizarAmbienteRequest request)throws Exception;
}
