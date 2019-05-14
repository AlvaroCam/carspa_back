package pe.com.tintegro.sigs.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import pe.com.tintegro.sigs.entidad.MedicamentoDispMedicoProdSanitario;

/**
 * @author Aldo Huamán
 *
 *         1 feb. 2018
 */
public interface MedicamentoDispositivoMapper
{
	public List<MedicamentoDispMedicoProdSanitario> obtenerMedicamentoDispMedicoProdSanitario(
			@Param("idAlmacen") Integer idAlmacen, @Param("idIPRESS") String idIPRESS) throws Exception;

	public List<MedicamentoDispMedicoProdSanitario> obtenerMedicamentoDispositivoAnaquel(
			@Param("idAlmacen") int idAlmacen, @Param("idMedicamento") Integer idMedicamento,
			@Param("anaquel") String anaquel, @Param("fiTipo") String fiTipo) throws Exception;
}
