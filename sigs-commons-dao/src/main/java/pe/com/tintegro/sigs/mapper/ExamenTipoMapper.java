package pe.com.tintegro.sigs.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import pe.com.tintegro.sigs.entidad.general.Item;

public interface ExamenTipoMapper
{
	public List<Item> obtenerExamenTipos(@Param("idExamenTipo") Integer idExamenTipo) throws Exception;
}
