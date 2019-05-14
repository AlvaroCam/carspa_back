/**
 * 
 */
package pe.com.tintegro.sigs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.tintegro.sigs.constants.ResponseEstado;
import pe.com.tintegro.sigs.dao.ActividadDAO;
import pe.com.tintegro.sigs.dto.request.ActualizarActividadRequest;
import pe.com.tintegro.sigs.dto.request.EliminarActividadRequest;
import pe.com.tintegro.sigs.dto.request.EliminarSubActividadRequest;
import pe.com.tintegro.sigs.dto.request.InsertarActividadRequest;
import pe.com.tintegro.sigs.dto.request.InsertarSubActvidadesRequest;
import pe.com.tintegro.sigs.dto.request.ObtenerActividadDescripcionRequest;
import pe.com.tintegro.sigs.dto.request.ObtenerActividadesConsultaAmbulatoriaRequest;
import pe.com.tintegro.sigs.dto.request.ObtenerSubActividadesRequest;
import pe.com.tintegro.sigs.dto.request.ObtieneActividadRequest;
import pe.com.tintegro.sigs.dto.request.ObtieneActividadesRequest;
import pe.com.tintegro.sigs.dto.request.ObtieneSubActividadRequest;
import pe.com.tintegro.sigs.dto.request.ObtieneSubActividadesRequest;
import pe.com.tintegro.sigs.dto.response.ActualizarActividadResponse;
import pe.com.tintegro.sigs.dto.response.EliminarActividadResponse;
import pe.com.tintegro.sigs.dto.response.EliminarSubActividadResponse;
import pe.com.tintegro.sigs.dto.response.InsertarActividadResponse;
import pe.com.tintegro.sigs.dto.response.InsertarSubActividadesResponse;
import pe.com.tintegro.sigs.dto.response.ObtenerActividadDescripcionResponse;
import pe.com.tintegro.sigs.dto.response.ObtenerActividadesConsultaAmbulatoriaResponse;
import pe.com.tintegro.sigs.dto.response.ObtenerSubActividadResponse;
import pe.com.tintegro.sigs.dto.response.ObtieneActividadResponse;
import pe.com.tintegro.sigs.dto.response.ObtieneActividadesResponse;
import pe.com.tintegro.sigs.dto.response.ObtieneSubActividadResponse;
import pe.com.tintegro.sigs.dto.response.ObtieneSubActividadesResponse;
import pe.com.tintegro.sigs.entidad.Actividad;
import pe.com.tintegro.sigs.entidad.SubActividad;
import pe.com.tintegro.sigs.entidad.general.Confirmacion;
import pe.com.tintegro.sigs.entidad.general.Item;
import pe.com.tintegro.sigs.service.ActividadService;
import pe.com.tintegro.sigs.util.EncriptacionUtil;

/**
 * @author daniel - 12 set. 2017
 *
 */
@Service( "actividadService" )
public class ActividadServiceImpl implements ActividadService
{
	@Autowired
	private ActividadDAO actividadDAO;
	
	@Override
	public ObtieneActividadesResponse obtenerActividades(ObtieneActividadesRequest request) throws Exception
	{
		ObtieneActividadesResponse response = new ObtieneActividadesResponse();
		
		request.setIdIPRESS( EncriptacionUtil.desencriptar( request.getIdIPRESS() ) );
		
		List<Item> actividadList = actividadDAO.obtenerActividades( request.getIdIPRESS(), request.getIdArea(), request.getIdEspecialidad(), null );		
		response.setActividadList( actividadList );
		
		return response;
	}

	@Override
	public ObtieneActividadResponse obtenerActividad(ObtieneActividadRequest request) throws Exception
	{
		ObtieneActividadResponse response = new ObtieneActividadResponse(); 
		
		request.setIdIPRESS( EncriptacionUtil.desencriptar( request.getIdIPRESS() ) );
		
		List<Item> actividadList = actividadDAO.obtenerActividades( request.getIdIPRESS(), request.getIdArea(), request.getIdEspecialidad(), request.getIdActividad() );
		
		Item actividad = actividadList.isEmpty() ? null : actividadList.get( 0 );
		
		if( actividad == null )
		{
			response.setEstado( ResponseEstado.ERROR_NEGOCIO );
			response.setMensaje( "Actividad no encontrada." );
		}
		else
		{
			response.setEstado( ResponseEstado.OK );
			response.setMensaje( "Actividad obtenida correctamente." );
		}
		
		response.setActividad( actividad );
		
		return response;
	}

	@Override
	public ObtieneSubActividadesResponse obtenerSubActividades(ObtieneSubActividadesRequest request) throws Exception
	{
		ObtieneSubActividadesResponse response = new ObtieneSubActividadesResponse();
		
		request.setIdIPRESS( EncriptacionUtil.desencriptar( request.getIdIPRESS() ) );
		
		List<Item> subActividadList = actividadDAO.obtenerSubActividades( request.getIdIPRESS(), request.getIdArea(), request.getIdEspecialidad(), request.getIdActividad(), null );
		response.setSubActividadList( subActividadList );
		
		return response;
	}

	@Override
	public ObtieneSubActividadResponse obtenerSubActividad(ObtieneSubActividadRequest request) throws Exception
	{
		ObtieneSubActividadResponse response = new ObtieneSubActividadResponse();
		
		request.setIdIPRESS( EncriptacionUtil.desencriptar( request.getIdIPRESS() ) );
		
		List<Item> subActividadList = actividadDAO.obtenerSubActividades( request.getIdIPRESS(), request.getIdArea(), request.getIdEspecialidad(), request.getIdActividad(), request.getIdSubActividad() );
		
		Item subActividad = subActividadList.isEmpty() ? null : subActividadList.get( 0 );
		
		if( subActividad == null )
		{
			response.setEstado( ResponseEstado.ERROR_NEGOCIO );
			response.setMensaje( "Subactividad no encontrada." );
		}
		else
		{
			response.setEstado( ResponseEstado.OK );
			response.setMensaje( "Subactividad obtenida correctamente." );
		}
		
		response.setSubActividad( subActividad );
		
		return response;
	}
//Agregado Barreto
	@Override
	public InsertarActividadResponse insertarActividad(
			InsertarActividadRequest request) throws Exception {
		InsertarActividadResponse response = new InsertarActividadResponse();
		response = actividadDAO.insertarActividad(request);
		
		Confirmacion confirmacion = response.getConfirmacion();
		
		if(confirmacion.getId() == ResponseEstado.OK) {
			response.setEstado(ResponseEstado.OK);
			response.setMensaje("Actividad insertada correctamente.");
		} else {
			response.setEstado(ResponseEstado.ERROR_NEGOCIO);
			response.setMensaje(confirmacion.getMensaje());
		}
		return response;
	}

	@Override
	public ObtenerActividadDescripcionResponse obtenerActividadDescripcion(
			ObtenerActividadDescripcionRequest request) throws Exception {
		ObtenerActividadDescripcionResponse response = actividadDAO.obtenerActividadDescripcion(request);
		List<Actividad> actividadList = response.getActividadList();
		
		if( actividadList == null ){
			response.setEstado( ResponseEstado.ERROR_NEGOCIO );
			response.setMensaje( "Actividad no encontrada." );
		} else {
			response.setEstado( ResponseEstado.OK );
			response.setMensaje( "Actividad obtenida correctamente." );
		}
		return response;
	}

	@Override
	public EliminarActividadResponse eliminarActividad(
			EliminarActividadRequest request) throws Exception {
		EliminarActividadResponse  response = actividadDAO.eliminarActividad(request);
		Confirmacion confirmacion = response.getConfirmacion();
		
		if (confirmacion.getId() == ResponseEstado.OK) {
			response.setEstado(ResponseEstado.OK);
			response.setMensaje("Eliminado correctamente.");
		} else {
			response.setEstado(ResponseEstado.ERROR_NEGOCIO);
			response.setMensaje(confirmacion.getMensaje());
		}
		return response;
	}

	@Override
	public ObtenerSubActividadResponse obtenerSubActividadd(
			ObtenerSubActividadesRequest request) throws Exception {
		ObtenerSubActividadResponse response = actividadDAO.obtenerSubActividad(request);
		List<SubActividad> subActividadList=response.getSubActividadList();
		
		if( subActividadList == null)
		{
			response.setEstado( ResponseEstado.ERROR_NEGOCIO );
			response.setMensaje( "Subactividad no encontrada." );
		}
		else
		{
			response.setEstado( ResponseEstado.OK );
			response.setMensaje( "Subactividad obtenida correctamente." );
		}
		
				return response;
	}

	@Override
	public InsertarSubActividadesResponse insertarSubActividad(
			InsertarSubActvidadesRequest request) throws Exception {
		
		InsertarSubActividadesResponse response = actividadDAO.insertarSubActividad(request);
		
		Confirmacion confirmacion = response.getConfirmacion();
		
		if(confirmacion.getId() == ResponseEstado.OK) {
			response.setEstado(ResponseEstado.OK);
			response.setMensaje("SubActividad insertada correctamente.");
		} else {
			response.setEstado(ResponseEstado.ERROR_NEGOCIO);
			response.setMensaje(confirmacion.getMensaje());
		}
		return response;
	}

	@Override
	public EliminarSubActividadResponse eliminarSubActividad(
			EliminarSubActividadRequest request) throws Exception {
		EliminarSubActividadResponse response =actividadDAO.eliminarSubActividad(request);
		Confirmacion confirmacion = response.getConfirmacion();
		
		if(confirmacion.getId() == ResponseEstado.OK) {
			response.setEstado(ResponseEstado.OK);
			response.setMensaje("SubActividad eliminada correctamente.");
		} else {
			response.setEstado(ResponseEstado.ERROR_NEGOCIO);
			response.setMensaje(confirmacion.getMensaje());
		}
		response.setConfirmacion(confirmacion);
		return response;
	}
	///////////////////////////////////////////////////////
	@Override
	public ActualizarActividadResponse actualizarActividad(
			ActualizarActividadRequest request) throws Exception {
	ActualizarActividadResponse response=new ActualizarActividadResponse();
	response=actividadDAO.actualizarActividad(request);
	Confirmacion confirmacion= response.getConfirmacion();
	if(confirmacion.getId()==ResponseEstado.OK){
		response.setEstado(ResponseEstado.OK);
		response.setMensaje("El registro se actualizo correctamente .");
		
	}else{
		response.setEstado(ResponseEstado.ERROR_NEGOCIO);
		response.setMensaje(confirmacion.getMensaje());
	}
	
	return response;
	}

	@Override
	public ObtenerActividadesConsultaAmbulatoriaResponse obtenerActividadesConsultaAmbulatoria(
			ObtenerActividadesConsultaAmbulatoriaRequest request)
			throws Exception {
		ObtenerActividadesConsultaAmbulatoriaResponse response = new ObtenerActividadesConsultaAmbulatoriaResponse();
		request.setIdIPRESS(EncriptacionUtil.desencriptar(request.getIdIPRESS()));
		List<Item> list1 = actividadDAO.obtenerActividadesConsultaAmbulatoria(request.getIdIPRESS(),
																			  request.getIdArea(),
																			  request.getIdEspecialidad(),
																			  null);
		response.setActividadList(list1);
		return response;
	}
}
