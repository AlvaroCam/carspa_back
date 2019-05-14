/**
 * 
 */
package pe.com.tintegro.sigs.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import pe.com.tintegro.sigs.entidad.general.Item;

/**
 * @author FReyes
 *
 */
public interface OcupacionMapper 
{
	public List<Item> obtenerOcupacion() throws Exception;
	public List<Item> obtenerOcupacionForActoMedico(@Param( "descripcion" ) String descripcion) throws Exception;
}
