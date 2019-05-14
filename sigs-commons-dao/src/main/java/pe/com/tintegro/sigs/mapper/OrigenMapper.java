package pe.com.tintegro.sigs.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import pe.com.tintegro.sigs.entidad.general.Item;

public interface OrigenMapper 
{
	public List<Item> obtenerOrigenes(@Param("idOrigen") Integer idOrigen);
}
