/**
 * 
 */
package pe.com.tintegro.sigs.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import pe.com.tintegro.sigs.entidad.Actividad;
import pe.com.tintegro.sigs.entidad.SubActividad;
import pe.com.tintegro.sigs.entidad.general.Confirmacion;
import pe.com.tintegro.sigs.entidad.general.Item;

/**
 * @author daniel - 12 set. 2017
 *
 */
public interface ActividadMapper
{
	public List<Item> obtenerActividades( @Param( "idIPRESS" ) String idIPRESS,
										  @Param( "idArea" ) Integer idArea, 
										  @Param( "idEspecialidad" ) Integer idEspecialidad, 
										  @Param( "idActividad" ) Integer idActividad );
	
	public List<Item> obtenerActividadesConsultaAmbulatoria( @Param( "idIPRESS" ) String idIPRESS, 
													         @Param( "idArea" ) Integer idArea, 
													         @Param( "idEspecialidad" ) Integer idEspecialidad, 
													         @Param( "idActividad" ) Integer idActividad );
	
	public List<Item> obtenerSubActividades( @Param( "idIPRESS" ) String idIPRESS, 
											 @Param( "idArea" ) Integer idArea, 
											 @Param( "idEspecialidad" ) Integer idEspecialidad, 
											 @Param( "idActividad" ) Integer idActividad, 
											 @Param( "idSubActividad" ) Integer idSubActividad );

	public Confirmacion insertarActividad ( 
			@Param("descripcionActividad") String descripcionActividad, 
			@Param("abreviatura") String abreviatura, 
			@Param("tipoProgramacion") Integer tipoProgramacion,
			@Param ("tipoActividad") Integer tipoActividad,
			@Param ("ambiente") String ambiente);
	
	public List<Actividad> obtenerActividadDescripcion (
			@Param("descripcionActividad") String descripcionActividad, 
			@Param("nuPagina") Integer nuPagina, 
			@Param("nuRegisMostrar") Integer nuRegisMostrar);
	
	public Confirmacion eliminarActividad(@Param("idActividad") Integer idActividad) throws Exception;
	
	//ObtenerSubActividad
		public List<SubActividad> obtenerSubActividad (
				@Param ("descripcionSubActividad") String descripcionSubActividad, 
				@Param ("numPagina") Integer numPagina, 
				@Param ("numRegisMostrar") Integer numRegisMostrar);
		
		//IngresarSubActividad
		public Confirmacion insertarSubActividad(
				@Param ("descripcionSubActividad") String descripcionSubActividad,
				@Param ("abreviatura") String abreviatura,	
				@Param ("idActividad") Integer idActividad );
		
		//EliminarSubActividad
		public Confirmacion eliminarSubActividad(
				@Param("idSubActividad") Integer idSubActividad);
		//Editar Actividad
		public Confirmacion editarActividad(
			@Param("idActividad") Integer idActividad,
			@Param("descripcionActividad") String descripcionActividad,
			@Param("abreviatura")String abreviatura,
			@Param("tipoProgramacion")Integer tipoProgramacion,
			@Param("tipoActividad") Integer tipoActividad,
			@Param("ambiente") Integer ambiente);
		
}
