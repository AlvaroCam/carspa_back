package pe.com.tintegro.sigs.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import pe.com.tintegro.sigs.entidad.AreaEspecialidad;
import pe.com.tintegro.sigs.entidad.general.Confirmacion;

public interface AreaEspecialidadMapper {
	
	public List<AreaEspecialidad> obtenerAreaPorEspecialidad (@Param( "idArea" ) Integer idArea,
															  @Param( "idEspecialidad" ) Integer idEspecialidad,
															  @Param( "nuPagina" ) Integer nuPagina,
															  @Param( "nuRegisMostrar" ) Integer nuRegisMostrar)throws Exception;
	
	public Confirmacion insertarAreaPorEspecialidad (@Param("idArea") Integer idArea,
													 @Param("idEspecialidad") Integer idEspecialidad,
													 @Param( "rpct" ) Integer rpct,
													 @Param( "flag_interconsulta" ) Integer flag_interconsulta,
													 @Param( "idSexo" ) Integer idSexo,
													 @Param( "edadMaxima" ) Integer edadMaxima,
													 @Param( "edadMinima" ) Integer edadMinima);
	
	public Confirmacion actualizarAreaPorEspecialidad (@Param("idArea") Integer idArea,
			 										   @Param("idEspecialidad") Integer idEspecialidad,
			 										   @Param( "rpct" ) Integer rpct,
			 										   @Param( "flag_interconsulta" ) Integer flag_interconsulta,
			 										   @Param( "idSexo" ) Integer idSexo,
			 										   @Param( "edadMaxima" ) Integer edadMaxima,
			 										   @Param( "edadMinima" ) Integer edadMinima);
	
	public Confirmacion eliminarAreaPorEspecialidad (@Param("idArea") Integer idArea,
			   										 @Param("idEspecialidad") Integer idEspecialidad);
}
