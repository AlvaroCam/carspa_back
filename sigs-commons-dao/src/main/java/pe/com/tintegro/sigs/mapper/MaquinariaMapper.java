package pe.com.tintegro.sigs.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import pe.com.tintegro.sigs.entidad.Maquinaria;
import pe.com.tintegro.sigs.entidad.general.Confirmacion;

public interface MaquinariaMapper {
	public Confirmacion desactivarMaquinaria(
			@Param("idMaquinaria")Integer idMaquinaria) throws Exception;

	public Confirmacion activarMaquinaria(
			@Param("idMaquinaria")Integer idMaquinaria) throws Exception;
	
	public Confirmacion insertMaquinaria(
			@Param("nombre")String nombre,
			@Param("marca")String marca,
			@Param("codigo")String codigo,
			@Param("fechaMantenimiento")String fechaMantenimiento,
			@Param("detalle")String detalle) throws Exception;
	
	public Confirmacion updateMaquinaria(
			@Param("idMaquinaria")Integer idMaquinaria,

			@Param("nombre")String nombre,
			@Param("marca")String marca,
			@Param("codigo")String codigo,
			@Param("fechaMantenimiento")String fechaMantenimiento,
			@Param("detalle")String detalle) throws Exception;
	
	public List<Maquinaria> listarMaquinaria(
			@Param("nombre")String nombre,
			@Param("estado")Integer estado,
			@Param("nuPagina")Integer nuPagina,
			@Param("nuRegisMostrar")Integer nuRegisMostrar) throws Exception;

	
}
