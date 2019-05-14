/**
 * 
 */
package pe.com.tintegro.sigs.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import pe.com.tintegro.sigs.entidad.Ubigeo;
import pe.com.tintegro.sigs.entidad.general.Item;

/**
 * @author Carlos
 *
 */
public interface UbigeoMapper
{
	public List<Ubigeo> obtenerUbigeo(@Param("codDepartamento") String codDepartamento, @Param("codProvincia") String codProvincia)throws Exception;
}
