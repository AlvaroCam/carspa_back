/**
 * 
 */
package pe.com.tintegro.sigs.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.com.tintegro.sigs.dao.ActividadDAO;
import pe.com.tintegro.sigs.dto.request.ActualizarActividadRequest;
import pe.com.tintegro.sigs.dto.request.EliminarActividadRequest;
import pe.com.tintegro.sigs.dto.request.EliminarSubActividadRequest;
import pe.com.tintegro.sigs.dto.request.InsertarActividadRequest;
import pe.com.tintegro.sigs.dto.request.InsertarSubActvidadesRequest;
import pe.com.tintegro.sigs.dto.request.ObtenerActividadDescripcionRequest;
import pe.com.tintegro.sigs.dto.request.ObtenerSubActividadesRequest;
import pe.com.tintegro.sigs.dto.response.ActualizarActividadResponse;
import pe.com.tintegro.sigs.dto.response.EliminarActividadResponse;
import pe.com.tintegro.sigs.dto.response.EliminarSubActividadResponse;
import pe.com.tintegro.sigs.dto.response.InsertarActividadResponse;
import pe.com.tintegro.sigs.dto.response.InsertarSubActividadesResponse;
import pe.com.tintegro.sigs.dto.response.ObtenerActividadDescripcionResponse;
import pe.com.tintegro.sigs.dto.response.ObtenerSubActividadResponse;
import pe.com.tintegro.sigs.entidad.Actividad;
import pe.com.tintegro.sigs.entidad.SubActividad;
import pe.com.tintegro.sigs.entidad.general.Confirmacion;
import pe.com.tintegro.sigs.entidad.general.Item;
import pe.com.tintegro.sigs.mapper.ActividadMapper;

/**
 * @author daniel - 12 set. 2017
 *
 */
@Repository( "actividadDAO" )
@Transactional
public class ActividadDAOImpl implements ActividadDAO
{
	@Autowired
	private ActividadMapper actividadMapper;
	
	@Override
	public List<Item> obtenerActividades(String idIPRESS, Integer idArea, Integer idEspecialidad, Integer idActividad) throws Exception
	{
		return actividadMapper.obtenerActividades( idIPRESS, idArea, idEspecialidad, idActividad );
	}

	@Override
	public List<Item> obtenerSubActividades(String idIPRESS, Integer idArea, Integer idEspecialidad, Integer idActividad, Integer idSubActividad) throws Exception
	{
		return actividadMapper.obtenerSubActividades( idIPRESS, idArea, idEspecialidad, idActividad, idSubActividad );
	}

	@Override
	public InsertarActividadResponse insertarActividad(
			InsertarActividadRequest request) throws Exception {
		InsertarActividadResponse response = new InsertarActividadResponse();
		Confirmacion confirmacion = actividadMapper.insertarActividad(
				request.getDescripcionActividad(), 
				request.getAbreviatura(), 
				request.getTipoProgramacion(),
				request.getTipoActividad(),
				request.getAmbiente());
		
		response.setConfirmacion(confirmacion);		
		return response;
	}

	@Override
	public ObtenerActividadDescripcionResponse obtenerActividadDescripcion(
			ObtenerActividadDescripcionRequest request) throws Exception {
		ObtenerActividadDescripcionResponse response = new ObtenerActividadDescripcionResponse();
		List<Actividad> actividadList = actividadMapper.obtenerActividadDescripcion(
				request.getDescripcionActividad(), 
				request.getNuPagina(), 
				request.getNuRegisMostrar());
		response.setActividadList(actividadList);
		return response;
	}

	@Override
	public EliminarActividadResponse eliminarActividad(
			EliminarActividadRequest request) throws Exception {
		EliminarActividadResponse response = new EliminarActividadResponse();
		Confirmacion confirmacion = actividadMapper.eliminarActividad(request.getIdActividad());
		response.setConfirmacion(confirmacion);
		return response;
	}

	@Override
	public ObtenerSubActividadResponse obtenerSubActividad(
			ObtenerSubActividadesRequest request) throws Exception {
		ObtenerSubActividadResponse response = new ObtenerSubActividadResponse();
		List<SubActividad> subActivList = actividadMapper.obtenerSubActividad(
		request.getDescripcionSubActividad(),
		request.getNumPagina(),
		request.getNumRegisMostrar());
		response.setSubActividadList(subActivList);
		return response;
	}

	@Override
	public InsertarSubActividadesResponse insertarSubActividad(
			InsertarSubActvidadesRequest request) throws Exception {
		InsertarSubActividadesResponse response = new InsertarSubActividadesResponse();
		Confirmacion confirmacion = actividadMapper.insertarSubActividad(
				request.getDescripcionSubActividad(),
				request.getAbreviatura(),
				//request.getIdActividad());
				request.getActividad().getIdActividad());
		response.setConfirmacion(confirmacion);
		return response;
	}

	@Override
	public EliminarSubActividadResponse eliminarSubActividad(
			EliminarSubActividadRequest request) throws Exception {
		EliminarSubActividadResponse response = new EliminarSubActividadResponse();
		Confirmacion confirmacion = actividadMapper.eliminarSubActividad(request.getIdSubActividad());
		response.setConfirmacion(confirmacion);
		return response;
	}

	@Override
	public ActualizarActividadResponse actualizarActividad(ActualizarActividadRequest request) throws Exception {
	ActualizarActividadResponse response= new ActualizarActividadResponse();
	Confirmacion confirmacion=actividadMapper.editarActividad(request.getIdActividad(),request.getDescripcionActividad(),request.getAbreviatura(),request.getTipoProgramacion(),request.getTipoActividad(),request.getAmbiente());

	response.setConfirmacion(confirmacion);
	return response;
	}

	@Override
	public List<Item> obtenerActividadesConsultaAmbulatoria(String idIPRESS,
			Integer idArea, Integer idEspecialidad, Integer idActividad)
			throws Exception {
		return actividadMapper.obtenerActividadesConsultaAmbulatoria(idIPRESS, idArea, idEspecialidad, idActividad);
	}
	
	
}
