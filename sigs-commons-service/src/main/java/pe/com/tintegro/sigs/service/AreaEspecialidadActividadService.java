package pe.com.tintegro.sigs.service;

import pe.com.tintegro.sigs.dto.request.ActualizarAreaEspecialidadActividadRequest;
import pe.com.tintegro.sigs.dto.request.EliminarAreaEspecialidadActividadRequest;
import pe.com.tintegro.sigs.dto.request.InsertarAreaEspecialidadActividadRequest;
import pe.com.tintegro.sigs.dto.request.ObtenerAreaEspecialidadActividadRequest;
import pe.com.tintegro.sigs.dto.response.ActualizarAreaEspecialidadActividadResponse;
import pe.com.tintegro.sigs.dto.response.EliminarAreaEspecialidadActividadResponse;
import pe.com.tintegro.sigs.dto.response.InsertarAreaEspecialidadActividadResponse;
import pe.com.tintegro.sigs.dto.response.ObtenerAreaEspecialidadActividadResponse;

public interface AreaEspecialidadActividadService {
	
	public ObtenerAreaEspecialidadActividadResponse obtenerAreaEspecialidadActividadResponse(ObtenerAreaEspecialidadActividadRequest request)throws Exception;
	
	public InsertarAreaEspecialidadActividadResponse insertarAreaEspecialidadActividadResponse(InsertarAreaEspecialidadActividadRequest request)throws Exception;
	
	public ActualizarAreaEspecialidadActividadResponse actualizarAreaEspecialidadActividadResponse(ActualizarAreaEspecialidadActividadRequest request)throws Exception;
	
	public EliminarAreaEspecialidadActividadResponse eliminarAreaEspecialidadActividadResponse(EliminarAreaEspecialidadActividadRequest request)throws Exception;
    
}