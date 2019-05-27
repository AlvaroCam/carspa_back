package pe.com.tintegro.sigs.mapper;

import java.math.BigDecimal;

import org.apache.ibatis.annotations.Param;

import pe.com.tintegro.sigs.entidad.general.Confirmacion;

public interface AnaquelMapper {

	public Confirmacion actualizarAnaquel(@Param("idAlmacenOrdenCompraMaterial") Integer idAlmacenOrdenCompraMaterial,
			@Param("idAnaquel") Integer idAnaquel) throws Exception;

}
