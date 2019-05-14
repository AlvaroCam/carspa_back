package pe.com.tintegro.sigs.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import pe.com.tintegro.sigs.entidad.AreaEspecialidadActividadGrupoOcupacional;
import pe.com.tintegro.sigs.entidad.general.Confirmacion;

public interface AreaEspecialidadActividadGrupoOcupacionalMapper {

	public Confirmacion insertarAreaEspecialidadActividadGrupoOcupacionalJ(
			@Param("idIPRESS") String idIPRESS,
			@Param("idArea") Integer idArea,
			@Param("idEspecialidad") Integer idEspecialidad,
			@Param("idActividad") Integer idActividad,
			@Param("idGrupoOcupacional") Integer idGrupoOcupacional);

	public List<AreaEspecialidadActividadGrupoOcupacional> obtenerAreaEspecialidadActividadGrupoOcupacionalJ(
			@Param("idArea") Integer idArea,
			@Param("idEspecialidad") Integer idEspecialidad,
			@Param("idActividad") Integer idActividad,
			@Param("idGrupoOcupacional") Integer idGrupoOcupacional,
			@Param("idIPRESS") String idIPRESS,
			@Param("nuPagina") Integer nuPagina,
			@Param("nuRegisMostrar") Integer nuRegisMostrar);

	public Confirmacion eliminarAreaEspecialidadActividadGrupoOcupacionalJ(
			@Param("idIPRESS") String idIPRESS,
			@Param("idArea") Integer idArea,
			@Param("idEspecialidad") Integer idEspecialidad,
			@Param("idActividad") Integer idActividad,
			@Param("idGrupoOcupacional") Integer idGrupoOcupacional);

}
