/**
 * 
 */
package pe.com.tintegro.sigs.service;

import pe.com.tintegro.sigs.dto.request.ActualizarGrupoOcupacionalJRequest;
import pe.com.tintegro.sigs.dto.request.EliminarAreaEspecialidadActividadGrupoOcupacionalJRequest;
import pe.com.tintegro.sigs.dto.request.EliminarGrupoOcupacionalJRequest;
import pe.com.tintegro.sigs.dto.request.InsertarAreaEspecialidadActividadGrupoOcupacionalJRequest;
import pe.com.tintegro.sigs.dto.request.InsertarGrupoOcupacionalJRequest;
import pe.com.tintegro.sigs.dto.request.ObtenerAreaEspecialidadActividadGrupoOcupacionalJRequest;
import pe.com.tintegro.sigs.dto.request.ObtenerGrupoOcupacionalJRequest;
import pe.com.tintegro.sigs.dto.request.ObtenerTipoProfesionalJRequest;
import pe.com.tintegro.sigs.dto.request.ObtieneGrupoOcupacionalRequest;
import pe.com.tintegro.sigs.dto.response.ActualizarGrupoOcupacionalJResponse;
import pe.com.tintegro.sigs.dto.response.EliminarAreaEspecialidadActividadGrupoOcupacionalJResponse;
import pe.com.tintegro.sigs.dto.response.EliminarGrupoOcupacionalJResponse;
import pe.com.tintegro.sigs.dto.response.InsertarAreaEspecialidadActividadGrupoOcupacionalJResponse;
import pe.com.tintegro.sigs.dto.response.InsertarGrupoOcupacionalJResponse;
import pe.com.tintegro.sigs.dto.response.ObtenerAreaEspecialidadActividadGrupoOcupacionalJResponse;
import pe.com.tintegro.sigs.dto.response.ObtenerGrupoOcupacionalJResponse;
import pe.com.tintegro.sigs.dto.response.ObtenerTipoProfesionalJResponse;
import pe.com.tintegro.sigs.dto.response.ObtieneGrupoOcupacionalResponse;

/**
 * @author Carlos
 *
 */
public interface GrupoOcupacionalService
{
	public ObtieneGrupoOcupacionalResponse obtenerGrupoOcupacional(ObtieneGrupoOcupacionalRequest request) throws Exception;

	public InsertarGrupoOcupacionalJResponse insertarGrupoOcupacionalJ(InsertarGrupoOcupacionalJRequest request) throws Exception;
	
	public ObtenerGrupoOcupacionalJResponse obtenerGrupoOcupacionalJ(ObtenerGrupoOcupacionalJRequest request) throws Exception;
	
	public EliminarGrupoOcupacionalJResponse eliminarGrupoOcupacionalJ(EliminarGrupoOcupacionalJRequest request) throws Exception;
	
	public ActualizarGrupoOcupacionalJResponse actualizarGrupoOcupacionalJ(ActualizarGrupoOcupacionalJRequest request) throws Exception;

	public ObtenerTipoProfesionalJResponse obtenerTipoProfesionalJ(ObtenerTipoProfesionalJRequest request) throws Exception;
	
}