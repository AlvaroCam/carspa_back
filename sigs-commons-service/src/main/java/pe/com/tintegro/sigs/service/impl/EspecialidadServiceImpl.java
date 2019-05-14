/**
 * 
 */
package pe.com.tintegro.sigs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.tintegro.sigs.constants.ResponseEstado;
import pe.com.tintegro.sigs.dao.EspecialidadDAO;
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
import pe.com.tintegro.sigs.entidad.Especialidad;
import pe.com.tintegro.sigs.entidad.general.Confirmacion;
import pe.com.tintegro.sigs.entidad.general.Item;
import pe.com.tintegro.sigs.service.EspecialidadService;
import pe.com.tintegro.sigs.util.EncriptacionUtil;

/**
 * @author daniel - 11 set. 2017
 *
 */
@Service( "especialidadService" ) 
public class EspecialidadServiceImpl implements EspecialidadService
{
	@Autowired
	private EspecialidadDAO especialidadDAO;
	
	@Override
	public ObtieneEspecialidadesResponse obtenerEspecialidades(ObtieneEspecialidadesRequest request) throws Exception
	{
		ObtieneEspecialidadesResponse response = new ObtieneEspecialidadesResponse();
		
		request.setIdIPRESS( EncriptacionUtil.desencriptar( request.getIdIPRESS() ) );
		
		List<Item> especialidadList = especialidadDAO.obtenerEspecialidades( request.getIdIPRESS(), request.getIdArea(), null, request.getCodUsuario() );
		response.setEspecialidadList( especialidadList );
		
		return response;
	}

	@Override
	public ObtieneEspecialidadResponse obtenerEspecialidad(ObtieneEspecialidadRequest request) throws Exception
	{
		ObtieneEspecialidadResponse response = new ObtieneEspecialidadResponse();
		
		request.setIdIPRESS( EncriptacionUtil.desencriptar( request.getIdIPRESS() ) );
		
		List<Item> especialidadList = especialidadDAO.obtenerEspecialidades( request.getIdIPRESS(), request.getIdArea(), request.getIdEspecialidad(), request.getCodUsuario() );
		
		Item especialidad = especialidadList.isEmpty() ? null : especialidadList.get( 0 );
		
		if( especialidad == null )
		{
			response.setEstado( ResponseEstado.ERROR_NEGOCIO );
			response.setMensaje( "Especialidad no encontrada." );
		}
		else
		{
			response.setEstado( ResponseEstado.OK );
			response.setMensaje( "Especialidad obtenida correctamente." );
		}
		
		response.setEspecialidad( especialidad );
		
		return response;
	}

	@Override
	public ObtenerEspecialidadJResponse obtenerEspecialidadJ(ObtenerEspecialidadJRequest request) throws Exception {
		ObtenerEspecialidadJResponse response = especialidadDAO.obtenerEspecialidadJ(request);
		
		List<Especialidad> especialidadList = response.getEspecialidadList();
		
		if(especialidadList == null)
		{
			response.setEstado(ResponseEstado.ERROR_NEGOCIO);
			response.setMensaje("Especialidad no encontrada");
		}else{
			response.setEstado(ResponseEstado.OK);
			response.setMensaje("Especialidad obtenida correctamente");
		}
		return response;
	}

	@Override
	public InsertarEspecialidadJResponse insertarEspecialidadJ(InsertarEspecialidadJRequest request) throws Exception {
		InsertarEspecialidadJResponse response = especialidadDAO.insertaEspecialidadJ(request);
		
		Confirmacion confirmacion = response.getConfirmacion();
		
		if(confirmacion.getId()== ResponseEstado.OK){
			response.setEstado(ResponseEstado.OK);
			response.setMensaje("Especialidad Ingresada Correctamente");
		}else{
			response.setEstado(ResponseEstado.ERROR_NEGOCIO);
			response.setMensaje("Especialidad no se pudo ingresar");
		}
		
		return response;
	}

	@Override
	public EliminarEspecialidadJResponse eliminarEspecialidadJ(EliminarEspecialidadJRequest request) throws Exception {
		EliminarEspecialidadJResponse response = especialidadDAO.eliminarEspecialidadJ(request);
		
		Confirmacion confirmacion = response.getConfirmacion();
		
		if(confirmacion.getId()== ResponseEstado.OK){
			response.setEstado(ResponseEstado.OK);
			response.setMensaje("Especialidad eliminada correctamente");
		}else{
			response.setEstado(ResponseEstado.ERROR_NEGOCIO);
			response.setMensaje("Especialidad no se puedo eliminar");
		}
		return response;
	}

	@Override
	public ObtieneEspecialidadesConsultaAmbulatoriaResponse obtenerEspecialidadesConsultaAmbulatoria(
			ObtieneEspecialidadesConsultaAmbulatoriaRequest request)
			throws Exception {
		ObtieneEspecialidadesConsultaAmbulatoriaResponse response = new ObtieneEspecialidadesConsultaAmbulatoriaResponse();
		request.setIdIPRESS(EncriptacionUtil.desencriptar(request.getIdIPRESS()));
		List<Item> list1 = especialidadDAO.obtenerEspecialidadesConsultaAmbulatoria(request.getIdIPRESS(), 
																						    request.getIdArea(), 
																						    null, 
																						    request.getCodUsuario());
		response.setEspecialidadList(list1);
		return response;
	}


}
