package pe.com.tintegro.sigs.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import pe.com.tintegro.sigs.entidad.Ipress;

public interface IpressMapper {
	
	public List<Ipress> obtenerIpress (@Param("codUsuario") String codUsuario);

}
