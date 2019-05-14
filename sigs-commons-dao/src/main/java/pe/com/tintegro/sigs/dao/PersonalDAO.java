/**
 * 
 */
package pe.com.tintegro.sigs.dao;

import java.util.List;

import pe.com.tintegro.sigs.entidad.Personal;

/**
 * @author daniel - 18 set. 2017
 *
 */
public interface PersonalDAO
{
	public List<Personal> obtenerPersonales( String idIPRESS, Integer idArea, Integer idEspecialidad, Integer idActividad, Integer idSubActividad, String idPersonal ) throws Exception;
}
