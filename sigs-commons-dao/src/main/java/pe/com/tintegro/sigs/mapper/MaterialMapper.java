package pe.com.tintegro.sigs.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import pe.com.tintegro.sigs.entidad.Material;
import pe.com.tintegro.sigs.entidad.Proveedor;
import pe.com.tintegro.sigs.entidad.general.Confirmacion;

public interface MaterialMapper {
	public Confirmacion activarMaterial(
			@Param("idMaterial")Integer idMaterial) throws Exception;
	public Confirmacion desactivarMaterial(
			@Param("idMaterial")Integer idMaterial) throws Exception;
	public List<Material> listarMateriales(
			@Param("nombre")String nombre,
			@Param("estado")Integer estado,
			@Param("nuPagina")Integer nuPagina,
			@Param("nuRegisMostrar")Integer nuRegisMostrar) throws Exception;
	
	public List<Proveedor> comboProveedor()throws Exception;
	
	public Confirmacion insertMaterial(
			@Param("codigo")String codigo,
			@Param("stockMaximo")Integer stockMaximo,
			@Param("stockMinimo")Integer stockMinimo,
			@Param("puntoPedido")Integer puntoPedido,
			@Param("nombre")String nombre,
			@Param("marca")String marca,
			@Param("stock")Integer stock,
			@Param("descripcion")String descripcion) throws Exception;
	
	public Confirmacion updateMaterial(
			@Param("idMaterial")Integer idMaterial,
			@Param("codigo")String codigo,
			@Param("stockMaximo")Integer stockMaximo,
			@Param("stockMinimo")Integer stockMinimo,
			@Param("puntoPedido")Integer puntoPedido,
			@Param("nombre")String nombre,
			@Param("marca")String marca,
			@Param("stock")Integer stock,
			@Param("descripcion")String descripcion) throws Exception;
	
	public List<Material> listarMaterialesAlerta(
			@Param("nombre")String nombre,
			@Param("estado")Integer estado,
			@Param("nuPagina")Integer nuPagina,
			@Param("nuRegisMostrar")Integer nuRegisMostrar) throws Exception;

	
	public Confirmacion updateMaterial(
			@Param("idMaterial")Integer idMaterial,
			@Param("stockMaximo")Integer stockMaximo,
			@Param("stockMinimo")Integer stockMinimo,
			@Param("puntoPedido")Integer puntoPedido,
			@Param("precioVenta")Integer precioVenta,
			@Param("nombre")String nombre,
			@Param("marca")String marca,
			@Param("stock")Integer stock,
			@Param("precioCompra")Integer precioCompra,
			@Param("descripcion")String descripcion,
			@Param("idProveedor")Integer idProveedor) throws Exception; 
}
