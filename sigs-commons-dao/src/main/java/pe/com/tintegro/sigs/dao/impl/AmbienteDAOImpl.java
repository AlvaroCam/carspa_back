/**
 * 
 */
package pe.com.tintegro.sigs.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.com.tintegro.sigs.dao.AmbienteDAO;
import pe.com.tintegro.sigs.dto.request.ActualizarAmbienteRequest;
import pe.com.tintegro.sigs.dto.request.EliminarAmbienteRequest;
import pe.com.tintegro.sigs.dto.request.InsertarAmbienteRequest;
import pe.com.tintegro.sigs.dto.request.ObtieneActividadAmbienteRequest;
import pe.com.tintegro.sigs.dto.request.ObtieneAmbienteEspecialidadRequest;
import pe.com.tintegro.sigs.dto.request.ObtieneAmbientesRequest;
import pe.com.tintegro.sigs.dto.response.ActualizarAmbienteResponse;
import pe.com.tintegro.sigs.dto.response.EliminarAmbienteResponse;
import pe.com.tintegro.sigs.dto.response.InsertarAmbienteResponse;
import pe.com.tintegro.sigs.dto.response.InsertarAreaResponse;
import pe.com.tintegro.sigs.dto.response.ObtieneActividadAmbienteResponse;
import pe.com.tintegro.sigs.dto.response.ObtieneAmbienteEspecialidadResponse;
import pe.com.tintegro.sigs.dto.response.ObtieneAmbientesResponse;
import pe.com.tintegro.sigs.entidad.Ambiente;
import pe.com.tintegro.sigs.entidad.general.Confirmacion;
import pe.com.tintegro.sigs.entidad.general.Item;
import pe.com.tintegro.sigs.mapper.AmbienteMapper;

@Repository( "ambienteDAO" )
@Transactional
public class AmbienteDAOImpl implements AmbienteDAO
{
	@Autowired
	private AmbienteMapper ambienteMapper;

	@Override
	public ObtieneAmbientesResponse obtenerAmbientes(
			ObtieneAmbientesRequest request) throws Exception {
		ObtieneAmbientesResponse response = new ObtieneAmbientesResponse();
		List<Item> ambientesList = ambienteMapper.obtenerAmbientes(request.getIdIPRESS(),
																   request.getIdArea(),
																   request.getIdEspecialidad(),
																   request.getIdActividad(),
																   request.getCodUsuario());
		response.setAmbienteList(ambientesList);
		return response;
	}

	@Override
	public ObtieneAmbienteEspecialidadResponse obtenerAmbienteEspecialidad(
			ObtieneAmbienteEspecialidadRequest request) throws Exception {
		ObtieneAmbienteEspecialidadResponse response = new ObtieneAmbienteEspecialidadResponse();
		List<Ambiente> ambienteList = ambienteMapper.obtenerAmbienteEspecialidad(
				request.getIdArea(), 
				request.getDescripcionAmbiente(),
				request.getIdEspecialidad(),
				request.getIdActividad(),
				request.getNuPagina(),
				request.getNuRegisMostrar());
		response.setAmbienteList(ambienteList);
		return response;
	}

	@Override
	public InsertarAmbienteResponse insertaAmbiente(
			InsertarAmbienteRequest request) throws Exception {
		InsertarAmbienteResponse response = new InsertarAmbienteResponse();
		Confirmacion confirmacion = ambienteMapper.insertaAmbiente(
				request.getDescripcionAmbiente(), 
				request.getAbreviaturaAmbiente(), 
				request.getIdArea(), 
				request.getJsonAmbiente(), 
				request.getIdIPRESS());
		response.setConfirmacion(confirmacion);
		return response;
	}

	@Override
	public ObtieneActividadAmbienteResponse obtenerActividadAmbiente(
			ObtieneActividadAmbienteRequest request) throws Exception {
		ObtieneActividadAmbienteResponse response = new ObtieneActividadAmbienteResponse();
		List<Ambiente> ambienteList = ambienteMapper.obtenerActividadAmbiente(
				request.getIdArea(), 
				request.getIdEspecialidad(),
				request.getIdIPRESS());
		response.setAmbienteList(ambienteList);
		return response;
	}

	@Override
	public EliminarAmbienteResponse eliminaAmbiente(
			EliminarAmbienteRequest request) throws Exception {
		EliminarAmbienteResponse response = new EliminarAmbienteResponse();
		Confirmacion confirmacion = ambienteMapper.eliminaAmbiente(request.getIdAmbiente());
		response.setConfirmacion(confirmacion);
		return response;
	}

	@Override
	public ActualizarAmbienteResponse actualizarAmbiente(
			ActualizarAmbienteRequest request) throws Exception {
		ActualizarAmbienteResponse response = new ActualizarAmbienteResponse();
		Confirmacion confirmacion = ambienteMapper.actualizarAmbiente(
				request.getIdAmbiente(),
				request.getDescripcionAmbiente(), 
				request.getAbreviaturaAmbiente(), 
				request.getIdArea(), 
				request.getJsonAmbiente(), request.getIdIPRESS());
		response.setConfirmacion(confirmacion);
		return response;
	}

}
