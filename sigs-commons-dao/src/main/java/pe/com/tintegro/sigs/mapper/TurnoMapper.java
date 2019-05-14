/**
 * 
 */
package pe.com.tintegro.sigs.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import pe.com.tintegro.sigs.entidad.general.Confirmacion;
import pe.com.tintegro.sigs.entidad.general.Item;

/**
 * @author daniel - 14 set. 2017
 *
 */
public interface TurnoMapper
{
	public List<Item> obtenerTurnos( @Param( "idTurno" ) Integer idTurno ,
									 @Param( "idActividad" ) Integer idActividad);
	
	public Confirmacion insertarTurno ( @Param("ho_inicio") String ho_inicio,
										@Param("ho_final") String ho_final,
										@Param("idActividad") Integer idActividad);
}
