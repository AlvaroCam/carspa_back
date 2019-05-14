/**
 * 
 */
package pe.com.tintegro.sigs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.tintegro.sigs.constants.ResponseEstado;
import pe.com.tintegro.sigs.dao.GrupoOcupacionalDAO;
import pe.com.tintegro.sigs.dto.request.ActualizarGrupoOcupacionalJRequest;
import pe.com.tintegro.sigs.dto.request.EliminarGrupoOcupacionalJRequest;
import pe.com.tintegro.sigs.dto.request.InsertarGrupoOcupacionalJRequest;
import pe.com.tintegro.sigs.dto.request.ObtenerGrupoOcupacionalJRequest;
import pe.com.tintegro.sigs.dto.request.ObtenerTipoProfesionalJRequest;
import pe.com.tintegro.sigs.dto.request.ObtieneGrupoOcupacionalRequest;
import pe.com.tintegro.sigs.dto.response.ActualizarGrupoOcupacionalJResponse;
import pe.com.tintegro.sigs.dto.response.EliminarGrupoOcupacionalJResponse;
import pe.com.tintegro.sigs.dto.response.InsertarGrupoOcupacionalJResponse;
import pe.com.tintegro.sigs.dto.response.ObtenerGrupoOcupacionalJResponse;
import pe.com.tintegro.sigs.dto.response.ObtenerTipoProfesionalJResponse;
import pe.com.tintegro.sigs.dto.response.ObtieneGrupoOcupacionalResponse;
import pe.com.tintegro.sigs.entidad.GrupoOcupacional;
import pe.com.tintegro.sigs.entidad.TipoProfesional;
import pe.com.tintegro.sigs.entidad.general.Confirmacion;
import pe.com.tintegro.sigs.entidad.general.Item;
import pe.com.tintegro.sigs.service.GrupoOcupacionalService;

/**
 * @author Carlos
 *
 */
@Service("grupoOcupacionalService")
public class GrupoOcupacionalServiceImpl implements GrupoOcupacionalService
{

	@Autowired
	private GrupoOcupacionalDAO grupoOcupacionalDAO;

	@Override
	public ObtieneGrupoOcupacionalResponse obtenerGrupoOcupacional(ObtieneGrupoOcupacionalRequest request) throws Exception
	{
		ObtieneGrupoOcupacionalResponse response = new ObtieneGrupoOcupacionalResponse();
	
		response = grupoOcupacionalDAO.obtenerGrupoOcupacional(request);
		List<Item> areaEspecialidadList = response.getGrupoOcupacionalList();
			if(areaEspecialidadList == null){
				response.setEstado(ResponseEstado.ERROR_APLICACION);
				response.setMensaje("Grupo Ocupacional no encontrada");
						
			}
			else {
				
				response.setEstado(ResponseEstado.OK);
				response.setMensaje("Grupo Ocupacional obtenida y encontrada");
			}
		
		return response;
	}

	@Override
	public InsertarGrupoOcupacionalJResponse insertarGrupoOcupacionalJ(InsertarGrupoOcupacionalJRequest request) throws Exception {
		InsertarGrupoOcupacionalJResponse response = grupoOcupacionalDAO.insertarGrupoOcupacionalJ(request);
		
		Confirmacion confirmacion = response.getConfirmacion();
		
		if(confirmacion.getId()== ResponseEstado.OK){
			response.setEstado(ResponseEstado.OK);
			response.setMensaje("Grupo Ocupacional Registrado Correctamente");
		}else{
			response.setEstado(ResponseEstado.ERROR_NEGOCIO);
			response.setMensaje("Grupo Ocupacional no se pudo ingresar");
		}

		return response;
	}

	@Override
	public ObtenerGrupoOcupacionalJResponse obtenerGrupoOcupacionalJ(ObtenerGrupoOcupacionalJRequest request) throws Exception {
		ObtenerGrupoOcupacionalJResponse response = new ObtenerGrupoOcupacionalJResponse();
		
		response = grupoOcupacionalDAO.obtenerGrupoOcupacionalJ(request);
		List<GrupoOcupacional> areaEspecialidadList = response.getGrupoOcupacionalList();
			if(areaEspecialidadList == null){
				response.setEstado(ResponseEstado.ERROR_APLICACION);
				response.setMensaje("Grupo Ocupacional no encontrada");
						
			}
			else {
				
				response.setEstado(ResponseEstado.OK);
				response.setMensaje("Grupo Ocupacional obtenida y encontrada");
			}
		
		return response;
	}

	@Override
	public EliminarGrupoOcupacionalJResponse eliminarGrupoOcupacionalJ(EliminarGrupoOcupacionalJRequest request) throws Exception {
		EliminarGrupoOcupacionalJResponse response = grupoOcupacionalDAO.eliminarGrupoOcupacionalJ(request);
		
		Confirmacion confirmacion = response.getConfirmacion();
		
		if(confirmacion.getId() == ResponseEstado.OK){
			response.setEstado(ResponseEstado.OK);
			response.setMensaje("Grupo Ocupacional eliminado Correctamente");
		}else{
			response.setEstado(ResponseEstado.ERROR_NEGOCIO);
			response.setMensaje("Grupo Ocupacional no se pudo eliminar");
		}
		
		return response;
	}

	@Override
	public ActualizarGrupoOcupacionalJResponse actualizarGrupoOcupacionalJ(ActualizarGrupoOcupacionalJRequest request) throws Exception {
		ActualizarGrupoOcupacionalJResponse response = grupoOcupacionalDAO.actualizarGrupoOcupacionalJ(request);
		Confirmacion confirmacion = response.getConfirmacion();
		
		if(confirmacion.getId() == ResponseEstado.OK){
			response.setEstado(ResponseEstado.OK);
			response.setMensaje("Grupo Ocupacional actualizado Correctamente");
		}else{
			response.setEstado(ResponseEstado.ERROR_NEGOCIO);
			response.setMensaje("Grupo Ocupacional no se pudo actualizar");
		}
		
		return response;
	}

	@Override
	public ObtenerTipoProfesionalJResponse obtenerTipoProfesionalJ(ObtenerTipoProfesionalJRequest request) throws Exception {
		ObtenerTipoProfesionalJResponse response = new ObtenerTipoProfesionalJResponse();
		
		response = grupoOcupacionalDAO.obtenerTipoProfesionalJ(request);
		List<TipoProfesional> tipoProfesionalList = response.getTipoProfesionalList();
				
			if(tipoProfesionalList == null){
				response.setEstado(ResponseEstado.ERROR_APLICACION);
				response.setMensaje("Tipo Profesional no encontrada");
						
			}
			else {
				
				response.setEstado(ResponseEstado.OK);
				response.setMensaje("Tipo Profesional obtenida y encontrada");
			}
		
		return response;
	
	}
}
