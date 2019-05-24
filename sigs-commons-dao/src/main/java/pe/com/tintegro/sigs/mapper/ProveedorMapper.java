package pe.com.tintegro.sigs.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import pe.com.tintegro.sigs.entidad.Proveedor;

import pe.com.tintegro.sigs.entidad.general.Confirmacion;

public interface ProveedorMapper {
	public List<Proveedor> listarProveedor(
			@Param("idProveedor") Integer idProveedor,
			@Param("nombreProveedor") String nombreProveedor,
			@Param("nuPagina") Integer nuPagina,
			@Param("nuRegisMostrar") Integer nuRegisMostrar) throws Exception;

	
}
