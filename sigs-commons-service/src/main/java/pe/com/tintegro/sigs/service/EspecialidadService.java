/**
 * 
 */
package pe.com.tintegro.sigs.service;

import pe.com.tintegro.sigs.dto.request.EliminarEspecialidadJRequest;
import pe.com.tintegro.sigs.dto.request.InsertarEspecialidadJRequest;
import pe.com.tintegro.sigs.dto.request.ObtenerEspecialidadJRequest;
import pe.com.tintegro.sigs.dto.request.ObtieneEspecialidadRequest;
import pe.com.tintegro.sigs.dto.request.ObtieneEspecialidadesConsultaAmbulatoriaRequest;
import pe.com.tintegro.sigs.dto.request.ObtieneEspecialidadesRequest;
import pe.com.tintegro.sigs.dto.response.EliminarEspecialidadJResponse;
import pe.com.tintegro.sigs.dto.response.InsertarEspecialidadJResponse;
import pe.com.tintegro.sigs.dto.response.ObtenerEspecialidadJResponse;
import pe.com.tintegro.sigs.dto.response.ObtieneEspecialidadResponse;
import pe.com.tintegro.sigs.dto.response.ObtieneEspecialidadesConsultaAmbulatoriaResponse;
import pe.com.tintegro.sigs.dto.response.ObtieneEspecialidadesResponse;

/**
 * @author daniel - 11 set. 2017
 *
 */
public interface EspecialidadService
{
	public ObtieneEspecialidadesResponse obtenerEspecialidades( ObtieneEspecialidadesRequest request ) throws Exception;

	public ObtieneEspecialidadResponse obtenerEspecialidad( ObtieneEspecialidadRequest request ) throws Exception;
	
	public ObtieneEspecialidadesConsultaAmbulatoriaResponse obtenerEspecialidadesConsultaAmbulatoria( ObtieneEspecialidadesConsultaAmbulatoriaRequest request ) throws Exception;
	
	//Obtener 
	public ObtenerEspecialidadJResponse obtenerEspecialidadJ( ObtenerEspecialidadJRequest request ) throws Exception;
	//Insertar
	public InsertarEspecialidadJResponse insertarEspecialidadJ( InsertarEspecialidadJRequest request ) throws Exception;
	//Eliminar
	public EliminarEspecialidadJResponse eliminarEspecialidadJ ( EliminarEspecialidadJRequest request ) throws Exception;
}
