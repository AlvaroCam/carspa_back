/**
 * 
 */
package pe.com.tintegro.sigs.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.com.tintegro.sigs.dao.EspecialidadDAO;
import pe.com.tintegro.sigs.dto.request.EliminarEspecialidadJRequest;
import pe.com.tintegro.sigs.dto.request.InsertarEspecialidadJRequest;
import pe.com.tintegro.sigs.dto.request.ObtenerEspecialidadJRequest;
import pe.com.tintegro.sigs.dto.response.EliminarEspecialidadJResponse;
import pe.com.tintegro.sigs.dto.response.InsertarEspecialidadJResponse;
import pe.com.tintegro.sigs.dto.response.ObtenerEspecialidadJResponse;
import pe.com.tintegro.sigs.entidad.Especialidad;
import pe.com.tintegro.sigs.entidad.general.Confirmacion;
import pe.com.tintegro.sigs.entidad.general.Item;
import pe.com.tintegro.sigs.mapper.EspecialidadMapper;

/**
 * @author daniel - 11 set. 2017
 *
 */
@Repository( "especialidadDAO" )
@Transactional
public class EspecialidadDAOImpl implements EspecialidadDAO
{
	@Autowired
	private EspecialidadMapper especialidadMapper;
	
	@Override
	public List<Item> obtenerEspecialidades( String idIPRESS, Integer idArea, Integer idEspecialidad, String codUsuario ) throws Exception
	{
		return especialidadMapper.obtenerEspecialidades( idIPRESS, idArea, idEspecialidad, codUsuario );
	}

	@Override
	public InsertarEspecialidadJResponse insertaEspecialidadJ(InsertarEspecialidadJRequest Request) throws Exception {
		InsertarEspecialidadJResponse response= new InsertarEspecialidadJResponse();
		Confirmacion confirmacion = especialidadMapper.insertarEspecialidadJ( 
																		   Request.getDescripcion_especialidad(),
																		   Request.getAbreviatura_espec());
		response.setConfirmacion(confirmacion);
		return response;
	}

	@Override
	public ObtenerEspecialidadJResponse obtenerEspecialidadJ(ObtenerEspecialidadJRequest request) throws Exception {
		ObtenerEspecialidadJResponse response = new ObtenerEspecialidadJResponse();
	    List<Especialidad> especialidadlist = especialidadMapper.obtenerEspecialidadJ(
	    		request.getDescripcion_especialidad(),
	    		request.getNumPagina(),
	    		request.getNumMostrarPagina());
	    response.setEspecialidadList(especialidadlist);
		return response;
	}

	@Override
	public EliminarEspecialidadJResponse eliminarEspecialidadJ(EliminarEspecialidadJRequest request) throws Exception {
		EliminarEspecialidadJResponse response = new EliminarEspecialidadJResponse();
		
		Confirmacion confirmacion = especialidadMapper.eliminarEspecialidadJ(request.getIdEspecialidad());
		
		response.setConfirmacion(confirmacion);
		return response;
	}

	@Override
	public List<Item> obtenerEspecialidadesConsultaAmbulatoria(String idIPRESS,
			Integer idArea, Integer idEspecialidad, String codUsuario)
			throws Exception {
		return especialidadMapper.obtenerEspecialidadesConsultaAmbulatoria(idIPRESS, idArea, idEspecialidad, codUsuario);
	}
}
