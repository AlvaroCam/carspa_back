package pe.com.tintegro.sigs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.tintegro.sigs.constants.ResponseEstado;
import pe.com.tintegro.sigs.dao.AreaEspecialidadDAO;
import pe.com.tintegro.sigs.dto.request.ActualizarAreaPorEspecialidadRequest;
import pe.com.tintegro.sigs.dto.request.EliminarAreaPorEspecialidadRequest;
import pe.com.tintegro.sigs.dto.request.InsertarAreaPorEspecialidadRequest;
import pe.com.tintegro.sigs.dto.request.ObtenerAreaPorEspecialidadRequest;
import pe.com.tintegro.sigs.dto.response.ActualizarAreaPorEspecialidadResponse;
import pe.com.tintegro.sigs.dto.response.EliminarAreaPorEspecialidadResponse;
import pe.com.tintegro.sigs.dto.response.InsertarAreaPorEspecialidadResponse;
import pe.com.tintegro.sigs.dto.response.ObtenerAreaPorEspecialidadResponse;
import pe.com.tintegro.sigs.entidad.AreaEspecialidad;
import pe.com.tintegro.sigs.entidad.general.Confirmacion;
import pe.com.tintegro.sigs.service.AreaEspecialidadService;

@Service( "areaEspecialidadService" ) 
public class AreaEspecialidadServiceImpl implements AreaEspecialidadService{
	
	@Autowired
	private AreaEspecialidadDAO areaEspecialidadDAO;
	
	@Override
	public ObtenerAreaPorEspecialidadResponse obtenerAreaPorEspecialidad(
			ObtenerAreaPorEspecialidadRequest request) throws Exception {
		ObtenerAreaPorEspecialidadResponse response = new ObtenerAreaPorEspecialidadResponse();
		response = areaEspecialidadDAO.obtenerAreaPorEspecialidad(request);
		List<AreaEspecialidad> areaEspecialidadList = response.getAreaEspecialidadList();
			if(areaEspecialidadList == null){
				response.setEstado(ResponseEstado.ERROR_APLICACION);
				response.setMensaje("Area por Especialidad no encontrada");
			}
			else {
				response.setEstado(ResponseEstado.OK);
				response.setMensaje("Area por Especialidad obtenida y encontrada");
			}
		return response;
	}

	@Override
	public InsertarAreaPorEspecialidadResponse insertarAreaPorEspecialidad(
			InsertarAreaPorEspecialidadRequest request) throws Exception {
		InsertarAreaPorEspecialidadResponse response = new InsertarAreaPorEspecialidadResponse();
		response = areaEspecialidadDAO.insertarAreaPorEspecialidad(request);
		Confirmacion confirmacion = response.getConfirmacion();
		
		if(confirmacion.getId() == ResponseEstado.OK){
			response.setEstado(ResponseEstado.OK);
			response.setMensaje("Area por Especialidad ingresado Correctamente");
		}else{
			response.setEstado(ResponseEstado.ERROR_NEGOCIO);
			response.setMensaje("Area por Especialidad no se pudo ingresar");
		}
		return response;
	}

	@Override
	public ActualizarAreaPorEspecialidadResponse actualizarAreaPorEspecialidad(
			ActualizarAreaPorEspecialidadRequest request) throws Exception {
		ActualizarAreaPorEspecialidadResponse response = new ActualizarAreaPorEspecialidadResponse();
		response = areaEspecialidadDAO.actualizarAreaPorEspecialidad(request);
		Confirmacion confirmacion = response.getConfirmacion();
		
		if(confirmacion.getId() == ResponseEstado.OK){
			response.setEstado(ResponseEstado.OK);
			response.setMensaje("Area por Especialidad actualizado Correctamente");
		}else{
			response.setEstado(ResponseEstado.ERROR_NEGOCIO);
			response.setMensaje("Area por Especialidad no se pudo actualizar");
		}
		return response;
	}

	@Override
	public EliminarAreaPorEspecialidadResponse eliminarAreaPorEspecialidad(
			EliminarAreaPorEspecialidadRequest request) throws Exception {
		EliminarAreaPorEspecialidadResponse response = new EliminarAreaPorEspecialidadResponse();
		response = areaEspecialidadDAO.eliminarAreaPorEspecialidad(request);
		Confirmacion confirmacion = response.getConfirmacion();
		
		if(confirmacion.getId() == ResponseEstado.OK){
			response.setEstado(ResponseEstado.OK);
			response.setMensaje("Area por Especialidad eliminado Correctamente");
		}else{
			response.setEstado(ResponseEstado.ERROR_NEGOCIO);
			response.setMensaje("Area por Especialidad no se pudo eliminar");
		}
		return response;
	}

}
