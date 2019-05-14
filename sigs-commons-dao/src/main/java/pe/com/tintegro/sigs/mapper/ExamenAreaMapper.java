package pe.com.tintegro.sigs.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import pe.com.tintegro.sigs.entidad.general.Item;

public interface ExamenAreaMapper 
{
	public List<Item> obtenerExamenAreas(@Param("idExamenArea") Integer idExamenArea, @Param("idExamenTipo") Integer idExamenTipo);
}
