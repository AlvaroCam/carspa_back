package pe.com.tintegro.sigs.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import pe.com.tintegro.sigs.entidad.CptEspecialidad;

public interface CptEspecialidadMapper {
	public List<CptEspecialidad> ListarCptEspecialidad(
											@Param("idEspecialidad") Integer idEspecialidad,
											@Param("idCpt") Integer idCpt, 
											@Param("idIPRESS") String idIPRESS,
											@Param("nuPagina") Integer nuPagina,
											@Param("nuRegisMostrar") Integer nuRegisMostrar) throws Exception;
}