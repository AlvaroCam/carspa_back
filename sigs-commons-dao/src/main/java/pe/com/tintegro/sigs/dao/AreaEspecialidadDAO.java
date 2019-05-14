package pe.com.tintegro.sigs.dao;

import pe.com.tintegro.sigs.dto.request.ActualizarAreaPorEspecialidadRequest;
import pe.com.tintegro.sigs.dto.request.EliminarAreaPorEspecialidadRequest;
import pe.com.tintegro.sigs.dto.request.InsertarAreaPorEspecialidadRequest;
import pe.com.tintegro.sigs.dto.request.ObtenerAreaPorEspecialidadRequest;
import pe.com.tintegro.sigs.dto.response.ActualizarAreaPorEspecialidadResponse;
import pe.com.tintegro.sigs.dto.response.EliminarAreaPorEspecialidadResponse;
import pe.com.tintegro.sigs.dto.response.InsertarAreaPorEspecialidadResponse;
import pe.com.tintegro.sigs.dto.response.ObtenerAreaPorEspecialidadResponse;

public interface AreaEspecialidadDAO {
	
	public ObtenerAreaPorEspecialidadResponse obtenerAreaPorEspecialidad(ObtenerAreaPorEspecialidadRequest request) throws Exception;
	
	public InsertarAreaPorEspecialidadResponse insertarAreaPorEspecialidad(InsertarAreaPorEspecialidadRequest request) throws Exception;
	
	public ActualizarAreaPorEspecialidadResponse actualizarAreaPorEspecialidad(ActualizarAreaPorEspecialidadRequest request) throws Exception;
	
	public EliminarAreaPorEspecialidadResponse eliminarAreaPorEspecialidad(EliminarAreaPorEspecialidadRequest request) throws Exception;
}
