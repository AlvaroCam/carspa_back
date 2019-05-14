package pe.com.tintegro.sigs.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.com.tintegro.sigs.dao.AreaEspecialidadActividadDAO;
import pe.com.tintegro.sigs.dto.request.ActualizarAreaEspecialidadActividadRequest;
import pe.com.tintegro.sigs.dto.request.EliminarAreaEspecialidadActividadRequest;
import pe.com.tintegro.sigs.dto.request.InsertarAreaEspecialidadActividadRequest;
import pe.com.tintegro.sigs.dto.request.ObtenerAreaEspecialidadActividadRequest;
import pe.com.tintegro.sigs.dto.response.ActualizarAreaEspecialidadActividadResponse;
import pe.com.tintegro.sigs.dto.response.EliminarAreaEspecialidadActividadResponse;
import pe.com.tintegro.sigs.dto.response.InsertarAreaEspecialidadActividadResponse;
import pe.com.tintegro.sigs.dto.response.ObtenerAreaEspecialidadActividadResponse;
import pe.com.tintegro.sigs.entidad.AreaEspecialidadActividad;
import pe.com.tintegro.sigs.entidad.general.Confirmacion;
import pe.com.tintegro.sigs.mapper.AreaEspecialidadActividadMapper;

@Repository( "areaEspecialidadActividadDAO" )
@Transactional
public class AreaEspecialidadActividadDAOImpl implements AreaEspecialidadActividadDAO{
	
	@Autowired
	private AreaEspecialidadActividadMapper areaEspecialidadActividadMapper;

	@Override
	public ObtenerAreaEspecialidadActividadResponse obtenerAreaEspecialidadActividadResponse(
			ObtenerAreaEspecialidadActividadRequest request) throws Exception {
		ObtenerAreaEspecialidadActividadResponse response = new ObtenerAreaEspecialidadActividadResponse();
		List<AreaEspecialidadActividad> areaEspecialidadActividadList = areaEspecialidadActividadMapper.obtenerAreaEspecialidadActividad(
				request.getIdIPRESS(),
				request.getIdArea(),
				request.getIdEspecialidad(),
				request.getIdActividad(),
				request.getNuPagina(),
				request.getNuRegiMostrar());
		response.setAreaEspecialidadActividadList(areaEspecialidadActividadList);
		return response;
	}

	@Override
	public InsertarAreaEspecialidadActividadResponse insertarAreaEspecialidadActividadResponse(
			InsertarAreaEspecialidadActividadRequest request) throws Exception {
		InsertarAreaEspecialidadActividadResponse response = new InsertarAreaEspecialidadActividadResponse();
		Confirmacion confirmacion = areaEspecialidadActividadMapper.insertarAreaEspecialidadActividad(
				request.getIdIPRESS(), 
				request.getIdArea(), 
				request.getIdEspecialidad(), 
				request.getIdActividad(), 
				request.getActMedica(), 
				request.getPacienteHora(), 
				request.getAmbiente(), 
				request.getcCitasVoluntarias(), 
				request.getcRecitas(), 
				request.getcInterconsultas(), 
				request.getcCitarReferido(), 
				request.getcCitasDias(), 
				request.gettCuposNuevos(), 
				request.gettCuposAdicionales(), 
				request.getdAdeLiberaCupos(), 
				request.getIdFormImpre(),
				request.getPrioVolu(),
				request.getPrioRecita(),
				request.getPrioInter(),
				request.getPrioReferidos(),
				request.getPrioDias(),
				request.getFlgAmb());
		response.setConfirmacion(confirmacion);
		return response;
	}

	@Override
	public ActualizarAreaEspecialidadActividadResponse actualizarAreaEspecialidadActividadResponse(
			ActualizarAreaEspecialidadActividadRequest request)
			throws Exception {
		ActualizarAreaEspecialidadActividadResponse response = new ActualizarAreaEspecialidadActividadResponse();
		Confirmacion confirmacion = areaEspecialidadActividadMapper.actualizarAreaEspecialidadActividad(
				request.getIdIPRESS(), 
				request.getIdArea(), 
				request.getIdEspecialidad(), 
				request.getIdActividad(), 
				request.getActMedica(), 
				request.getPacienteHora(), 
				request.getAmbiente(), 
				request.getcCitasVoluntarias(), 
				request.getcRecitas(), 
				request.getcInterconsultas(), 
				request.getcCitarReferido(), 
				request.getcCitasDias(), 
				request.gettCuposNuevos(), 
				request.gettCuposAdicionales(), 
				request.getdAdeLiberaCupos(), 
				request.getIdFormImpre(),
				request.getPrioVolu(),
				request.getPrioRecita(),
				request.getPrioInter(),
				request.getPrioReferidos(),
				request.getPrioDias(),
				request.getFlgAmb());
		response.setConfirmacion(confirmacion);
		return response;
	}

	@Override
	public EliminarAreaEspecialidadActividadResponse eliminarAreaEspecialidadActividadResponse(
			EliminarAreaEspecialidadActividadRequest request) throws Exception {
		EliminarAreaEspecialidadActividadResponse response = new EliminarAreaEspecialidadActividadResponse();
		Confirmacion confirmacion = areaEspecialidadActividadMapper.eliminarAreaEspecialidadActividad(
				request.getIdIPRESS(), 
				request.getIdArea(), 
				request.getIdEspecialidad(), 
				request.getIdActividad());
		response.setConfirmacion(confirmacion);
		return response;
	}

}
