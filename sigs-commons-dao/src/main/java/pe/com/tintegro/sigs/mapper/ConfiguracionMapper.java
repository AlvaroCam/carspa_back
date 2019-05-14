package pe.com.tintegro.sigs.mapper;

import org.apache.ibatis.annotations.Param;

import pe.com.tintegro.sigs.entidad.Configuracion;

public interface ConfiguracionMapper
{
	public Configuracion obtenerConfiguracion(@Param("idConfiguracion") Integer idConfiguracion) throws Exception;
}
