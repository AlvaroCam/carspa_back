package pe.com.tintegro.sigs.mapper;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import pe.com.tintegro.sigs.entidad.AlmacenOrdenCompra;
import pe.com.tintegro.sigs.entidad.AlmacenOrdenCompraMaterial;
import pe.com.tintegro.sigs.entidad.general.Confirmacion;

public interface AlmacenOrdenCompraMapper {

	public List<AlmacenOrdenCompra> listarAlmacenOrdenCompra(
			@Param("idAlmacenOrdenCompra") Integer idAlmacenOrdenCompra,
			@Param("estado") String estado,
			@Param("nuPagina") Integer nuPagina,
			@Param("nuRegisMostrar") Integer nuRegisMostrar) throws Exception;

	public List<AlmacenOrdenCompraMaterial> listarAlmacenOrdenCompraMaterial(
			@Param("idAlmacenOrdenCompra") Integer idAlmacenOrdenCompra)
			throws Exception;

	public Confirmacion actualizarCantidadFisica(
			@Param("idAlmacenOrdenCompraMaterial") Integer idAlmacenOrdenCompraMaterial,
			@Param("idAlmacenOrdenCompra") Integer idAlmacenOrdenCompra,
			@Param("idMaterial") Integer idMaterial,
			@Param("cantidadFisica") BigDecimal cantidadFisica)
			throws Exception;

	public Confirmacion actualizarEstado(
			@Param("idAlmacenOrdenCompra") Integer idAlmacenOrdenCompra)
			throws Exception;
}
