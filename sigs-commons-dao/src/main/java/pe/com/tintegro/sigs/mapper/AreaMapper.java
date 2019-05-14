/**
 * 
 */
package pe.com.tintegro.sigs.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import pe.com.tintegro.sigs.entidad.Area;
import pe.com.tintegro.sigs.entidad.general.Confirmacion;
import pe.com.tintegro.sigs.entidad.general.Item;

/**
 * @author daniel - 11 set. 2017
 *
 */
public interface AreaMapper
{
	public List<Item> obtenerAreas( @Param( "idIPRESS" ) String idIPRESS, 
									@Param( "idArea") Integer idArea, 
									@Param( "codUsuario" ) String codUsuario );
	
	public List<Item> obtenerAreasConsultaAmbulatoria( @Param( "idIPRESS" ) String idIPRESS, 
													   @Param( "idArea") Integer idArea, 
													   @Param( "codUsuario" ) String codUsuario );
	
	public List<Item> obtenerAreasSinAlmacen(@Param("idArea") Integer idArea, 
											 @Param("idIPRESS") String idIPRESS, 
											 @Param( "codUsuario") String codUsuario);
	
	public List<Area> obtenerAreasMaestra(@Param ("descripcionArea") String descripcionArea, 
	   		  							  @Param ("numPagina") Integer numPagina, 
	   		  							  @Param ("numRegisMostrar") Integer numRegisMostrar);
	
	public Confirmacion insertarArea(@Param( "descripcionArea" ) String descripcionArea,
			 						 @Param("abreviaturaArea") String abreviaturaArea);

	public Confirmacion eliminarArea(@Param("idArea") Integer idArea);
}
