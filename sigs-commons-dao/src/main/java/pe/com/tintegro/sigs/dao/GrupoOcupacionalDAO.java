/**
 * 
 */
package pe.com.tintegro.sigs.dao;

import pe.com.tintegro.sigs.dto.request.ActualizarGrupoOcupacionalJRequest;
import pe.com.tintegro.sigs.dto.request.EliminarGrupoOcupacionalJRequest;
import pe.com.tintegro.sigs.dto.request.InsertarGrupoOcupacionalJRequest;
import pe.com.tintegro.sigs.dto.request.ObtenerGrupoOcupacionalJRequest;
import pe.com.tintegro.sigs.dto.request.ObtenerTipoProfesionalJRequest;
import pe.com.tintegro.sigs.dto.request.ObtieneGrupoOcupacionalRequest;
import pe.com.tintegro.sigs.dto.response.ActualizarGrupoOcupacionalJResponse;
import pe.com.tintegro.sigs.dto.response.EliminarGrupoOcupacionalJResponse;
import pe.com.tintegro.sigs.dto.response.InsertarGrupoOcupacionalJResponse;
import pe.com.tintegro.sigs.dto.response.ObtenerGrupoOcupacionalJResponse;
import pe.com.tintegro.sigs.dto.response.ObtenerTipoProfesionalJResponse;
import pe.com.tintegro.sigs.dto.response.ObtieneGrupoOcupacionalResponse;

/**
 * @author Carlos
 *
 */
public interface GrupoOcupacionalDAO
{
	public ObtieneGrupoOcupacionalResponse obtenerGrupoOcupacional(ObtieneGrupoOcupacionalRequest request) throws Exception;

	//Obtener
	public ObtenerGrupoOcupacionalJResponse obtenerGrupoOcupacionalJ (ObtenerGrupoOcupacionalJRequest request) throws Exception;
	//Insertar
	public InsertarGrupoOcupacionalJResponse insertarGrupoOcupacionalJ (InsertarGrupoOcupacionalJRequest request) throws Exception;
	//Actualizar
	public ActualizarGrupoOcupacionalJResponse actualizarGrupoOcupacionalJ (ActualizarGrupoOcupacionalJRequest request) throws Exception;
	//Eliminar
	public EliminarGrupoOcupacionalJResponse eliminarGrupoOcupacionalJ (EliminarGrupoOcupacionalJRequest request) throws Exception;


	public ObtenerTipoProfesionalJResponse obtenerTipoProfesionalJ(ObtenerTipoProfesionalJRequest request) throws Exception;

}
