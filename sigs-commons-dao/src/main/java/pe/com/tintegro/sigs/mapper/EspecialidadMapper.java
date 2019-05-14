/**
 * 
 */
package pe.com.tintegro.sigs.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import pe.com.tintegro.sigs.entidad.Especialidad;
import pe.com.tintegro.sigs.entidad.general.Confirmacion;
import pe.com.tintegro.sigs.entidad.general.Item;

/**
 * @author daniel - 11 set. 2017
 *
 */
public interface EspecialidadMapper
{
	public List<Item> obtenerEspecialidades( @Param( "idIPRESS" ) String idIPRESS, 
											 @Param( "idArea" ) Integer idArea, 
											 @Param( "idEspecialidad" ) Integer idEspecialidad,
											 @Param( "codUsuario" ) String codUsuario);
	
	public List<Item> obtenerEspecialidadesConsultaAmbulatoria( @Param( "idIPRESS" ) String idIPRESS, 
																@Param( "idArea" ) Integer idArea, 
																@Param( "idEspecialidad" ) Integer idEspecialidad,
																@Param( "codUsuario" ) String codUsuario);
	
	// Confirmacion Insertar
	public Confirmacion insertarEspecialidadJ (
			@Param("descripcion_especialidad") String descripcion_especialidad, 
			@Param("abreviatura_espec") String abreviatura_espec);
	
	// Obtener
	public List<Especialidad> obtenerEspecialidadJ(@Param("descripcion_especialidad")String descripcion_especialidad, 
												   @Param("numPagina") Integer numPagina,
												   @Param("numMostrarPagina") Integer numMostrarPagina);
	
	//Confirmacion Eliminar
		public Confirmacion eliminarEspecialidadJ(
				@Param ("idEspecialidad") Integer idEspecialidad) throws Exception;
	
	
	
}
