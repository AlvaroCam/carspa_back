/**
 * 
 */
package pe.com.tintegro.sigs.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import pe.com.tintegro.sigs.entidad.Personal;

/**
 * @author daniel - 18 set. 2017
 *
 */
public interface PersonalMapper
{
	public List<Personal> obtenerPersonales( @Param( "idIPRESS" ) String idIPRESS, @Param( "idArea" ) Integer idArea, @Param( "idEspecialidad" ) Integer idEspecialidad, @Param( "idActividad" ) Integer idActividad, @Param( "idSubActividad" ) Integer idSubActividad, @Param( "idPersonal" ) String idPersonal );
}
