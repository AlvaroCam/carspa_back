/**
 * 
 */
package pe.com.tintegro.sigs.dao;

import java.util.List;

import pe.com.tintegro.sigs.dto.request.EliminarEspecialidadJRequest;
import pe.com.tintegro.sigs.dto.request.InsertarEspecialidadJRequest;
import pe.com.tintegro.sigs.dto.request.ObtenerEspecialidadJRequest;
import pe.com.tintegro.sigs.dto.response.EliminarEspecialidadJResponse;
import pe.com.tintegro.sigs.dto.response.InsertarEspecialidadJResponse;
import pe.com.tintegro.sigs.dto.response.ObtenerEspecialidadJResponse;
import pe.com.tintegro.sigs.entidad.general.Item;

/**
 * @author daniel - 11 set. 2017
 *
 */
public interface EspecialidadDAO
{
	public List<Item> obtenerEspecialidades( String idIPRESS, Integer idArea, Integer idEspecialidad, String codUsuario ) throws Exception;
	
	public List<Item> obtenerEspecialidadesConsultaAmbulatoria( String idIPRESS, Integer idArea, Integer idEspecialidad, String codUsuario ) throws Exception;

	//Insertar
	public InsertarEspecialidadJResponse insertaEspecialidadJ (InsertarEspecialidadJRequest Request) throws Exception;
	//Obtener
	public ObtenerEspecialidadJResponse obtenerEspecialidadJ (ObtenerEspecialidadJRequest request) throws Exception;
	//Eliminar
	public EliminarEspecialidadJResponse eliminarEspecialidadJ (EliminarEspecialidadJRequest request) throws Exception;
	
	
}
