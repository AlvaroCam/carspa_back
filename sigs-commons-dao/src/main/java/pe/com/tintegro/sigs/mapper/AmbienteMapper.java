/**
 * 
 */
package pe.com.tintegro.sigs.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import pe.com.tintegro.sigs.entidad.Ambiente;
import pe.com.tintegro.sigs.entidad.general.Confirmacion;
import pe.com.tintegro.sigs.entidad.general.Item;

/**
 * @author daniel - 14 set. 2017
 *
 */
public interface AmbienteMapper {
	public List<Item> obtenerAmbientes(@Param("idIPRESS") String idIPRESS,
			@Param("idArea") Integer idArea,
			@Param("idEspecialidad") Integer idEspecialidad,
			@Param("idActividad") Integer idActividad,
			@Param("codUsuario") String codUsuario);

	public List<Ambiente> obtenerAmbienteEspecialidad(
			@Param("idArea") Integer idArea,
			@Param("descripcionAmbiente") String descripcionAmbiente,
			@Param("idEspecialidad") Integer idEspecialidad,
			@Param("idActividad") Integer idActividad,
			@Param("nuPagina") Integer nuPagina,
			@Param("nuRegisMostrar") Integer nuRegisMostrar) throws Exception;

	public Confirmacion insertaAmbiente(
			@Param("descripcionAmbiente") String descripcionAmbiente,
			@Param("abreviaturaAmbiente") String abreviaturaAmbiente,
			@Param("idArea") Integer idArea,
			@Param("jsonAmbiente") String jsonAmbiente,
			@Param("idIPRESS") String idIPRESS) throws Exception;

	public List<Ambiente> obtenerActividadAmbiente(
			@Param("idArea") Integer idArea,
			@Param("idEspecialidad") Integer idEspecialidad,
			@Param("idIPRESS") String idIPRESS) throws Exception;

	public Confirmacion eliminaAmbiente(@Param("idAmbiente") Integer idAmbiente)
			throws Exception;

	public Confirmacion actualizarAmbiente(
			@Param("idAmbiente") Integer idAmbiente,
			@Param("descripcionAmbiente") String descripcionAmbiente,
			@Param("abreviaturaAmbiente") String abreviaturaAmbiente,
			@Param("idArea") Integer idArea,
			@Param("jsonAmbiente") String jsonAmbiente,
			@Param("idIPRESS") String idIPRESS) throws Exception;
}
