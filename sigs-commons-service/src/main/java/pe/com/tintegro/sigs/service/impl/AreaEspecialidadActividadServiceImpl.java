package pe.com.tintegro.sigs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.tintegro.sigs.constants.ResponseEstado;
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
import pe.com.tintegro.sigs.service.AreaEspecialidadActividadService;
import pe.com.tintegro.sigs.util.EncriptacionUtil;

@Service( "areaEspecialidadActividadService" )
public class AreaEspecialidadActividadServiceImpl implements AreaEspecialidadActividadService{
	
	@Autowired
	private AreaEspecialidadActividadDAO areaEspecialidadActividadDAO;

	@Override
	public ObtenerAreaEspecialidadActividadResponse obtenerAreaEspecialidadActividadResponse(
			ObtenerAreaEspecialidadActividadRequest request) throws Exception {
		ObtenerAreaEspecialidadActividadResponse response = new ObtenerAreaEspecialidadActividadResponse();
		request.setIdIPRESS(EncriptacionUtil.desencriptar(request.getIdIPRESS()));
		response = areaEspecialidadActividadDAO.obtenerAreaEspecialidadActividadResponse(request);
		List<AreaEspecialidadActividad> areaEspecialidadActividadList = response.getAreaEspecialidadActividadList();
		if(areaEspecialidadActividadList == null) {
			response.setEstado(ResponseEstado.ERROR_APLICACION);
			response.setMensaje("AreaxEspecialidadxActividad no encontrada");
		}else {
			response.setEstado(ResponseEstado.OK);
			response.setMensaje("AreaxEspxAct obtenida y encontrada");
		}
		return response;
	}

	@Override
	public InsertarAreaEspecialidadActividadResponse insertarAreaEspecialidadActividadResponse(
			InsertarAreaEspecialidadActividadRequest request) throws Exception {
		InsertarAreaEspecialidadActividadResponse response = new InsertarAreaEspecialidadActividadResponse();
		request.setIdIPRESS(EncriptacionUtil.desencriptar(request.getIdIPRESS()));
		response = areaEspecialidadActividadDAO.insertarAreaEspecialidadActividadResponse(request);
		Confirmacion confirmacion = response.getConfirmacion();
		if (confirmacion.getId() == ResponseEstado.OK) {
			response.setEstado(ResponseEstado.OK);
			response.setMensaje("Se insertó correctamente");
		} else {
			response.setEstado(ResponseEstado.ERROR_NEGOCIO);
			response.setMensaje(confirmacion.getMensaje());
		}
		return response;
	}

	@Override
	public ActualizarAreaEspecialidadActividadResponse actualizarAreaEspecialidadActividadResponse(
			ActualizarAreaEspecialidadActividadRequest request)
			throws Exception {
		ActualizarAreaEspecialidadActividadResponse response = new ActualizarAreaEspecialidadActividadResponse();
		request.setIdIPRESS(EncriptacionUtil.desencriptar(request.getIdIPRESS()));
		response = areaEspecialidadActividadDAO.actualizarAreaEspecialidadActividadResponse(request);
		Confirmacion confirmacion = response.getConfirmacion();
		if (confirmacion.getId() == ResponseEstado.OK) {
			response.setEstado(ResponseEstado.OK);
			response.setMensaje("Se editó correctamente");
		} else {
			response.setEstado(ResponseEstado.ERROR_NEGOCIO);
			response.setMensaje(confirmacion.getMensaje());
		}
		return response;
	}

	@Override
	public EliminarAreaEspecialidadActividadResponse eliminarAreaEspecialidadActividadResponse(
			EliminarAreaEspecialidadActividadRequest request) throws Exception {
		EliminarAreaEspecialidadActividadResponse response = new EliminarAreaEspecialidadActividadResponse();
		request.setIdIPRESS(EncriptacionUtil.desencriptar(request.getIdIPRESS()));
		response = areaEspecialidadActividadDAO.eliminarAreaEspecialidadActividadResponse(request);
		Confirmacion confirmacion = response.getConfirmacion();
		if (confirmacion.getId() == ResponseEstado.OK) {
			response.setEstado(ResponseEstado.OK);
			response.setMensaje("Se eliminó correctamente");
		} else {
			response.setEstado(ResponseEstado.ERROR_NEGOCIO);
			response.setMensaje(confirmacion.getMensaje());
		}
		return response;
	}

}
