package pe.com.tintegro.sigs.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import pe.com.tintegro.sigs.entidad.ComboGeneral;

public interface ComboGeneralMapper
{
	public List<ComboGeneral> obtenerComboGeneral( @Param( "idGrupoOpcion" ) String idGrupoOpcion) throws Exception;
	public List<ComboGeneral> obtenerComboTipoDocumentoIdentidad () throws Exception;
}
