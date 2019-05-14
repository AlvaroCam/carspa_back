package pe.com.tintegro.sigs.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.com.tintegro.sigs.dao.AreaEspecialidadActividadGrupoOcupacionalDAO;
import pe.com.tintegro.sigs.dto.request.EliminarAreaEspecialidadActividadGrupoOcupacionalJRequest;
import pe.com.tintegro.sigs.dto.request.InsertarAreaEspecialidadActividadGrupoOcupacionalJRequest;
import pe.com.tintegro.sigs.dto.request.ObtenerAreaEspecialidadActividadGrupoOcupacionalJRequest;
import pe.com.tintegro.sigs.dto.response.EliminarAreaEspecialidadActividadGrupoOcupacionalJResponse;
import pe.com.tintegro.sigs.dto.response.InsertarAreaEspecialidadActividadGrupoOcupacionalJResponse;
import pe.com.tintegro.sigs.dto.response.ObtenerAreaEspecialidadActividadGrupoOcupacionalJResponse;
import pe.com.tintegro.sigs.entidad.AreaEspecialidadActividadGrupoOcupacional;
import pe.com.tintegro.sigs.entidad.general.Confirmacion;
import pe.com.tintegro.sigs.mapper.AreaEspecialidadActividadGrupoOcupacionalMapper;

@Repository("areaEspecialidadActividadGrupoOcupacionalDAO")
@Transactional
public class AreaEspecialidadActividadGrupoOcupacionalDAOImpl implements AreaEspecialidadActividadGrupoOcupacionalDAO
{
	
	@Autowired
	private AreaEspecialidadActividadGrupoOcupacionalMapper areaEspecialidadActividadGrupoOcupacionalMapper;

	@Override
	public InsertarAreaEspecialidadActividadGrupoOcupacionalJResponse insertarAreaEspecialidadActividadGrupoOcupacionalJ(InsertarAreaEspecialidadActividadGrupoOcupacionalJRequest request)throws Exception {
		InsertarAreaEspecialidadActividadGrupoOcupacionalJResponse response = new InsertarAreaEspecialidadActividadGrupoOcupacionalJResponse();
		Confirmacion confirmar = areaEspecialidadActividadGrupoOcupacionalMapper.insertarAreaEspecialidadActividadGrupoOcupacionalJ(
									request.getIdIPRESS(),
									request.getIdArea(), 
									request.getIdEspecialidad(),
									request.getIdActividad(),
									request.getIdGrupoOcupacional());
		response.setConfirmacion(confirmar);
		return response;
	}

	@Override
	public ObtenerAreaEspecialidadActividadGrupoOcupacionalJResponse obtenerAreaEspecialidadActividadGrupoOcupacionalJ(ObtenerAreaEspecialidadActividadGrupoOcupacionalJRequest request)throws Exception {
		ObtenerAreaEspecialidadActividadGrupoOcupacionalJResponse response = new ObtenerAreaEspecialidadActividadGrupoOcupacionalJResponse();
		
		List<AreaEspecialidadActividadGrupoOcupacional> areaEspecialidadActividadGrupoOcupacionalList = areaEspecialidadActividadGrupoOcupacionalMapper.obtenerAreaEspecialidadActividadGrupoOcupacionalJ(
				request.getIdArea(),
				request.getIdEspecialidad(),
				request.getIdActividad(),
				request.getIdGrupoOcupacional(),
				request.getIdIPRESS(),
				request.getNuPagina(),
				request.getNuRegisMostrar());
				   
		response.setAreaEspecialidadActividadGrupoOcupacional(areaEspecialidadActividadGrupoOcupacionalList);
		return response;
	}
	@Override
	public EliminarAreaEspecialidadActividadGrupoOcupacionalJResponse eliminarAreaEspecialidadActividadGrupoOcupacionalJ(EliminarAreaEspecialidadActividadGrupoOcupacionalJRequest request)throws Exception {
		EliminarAreaEspecialidadActividadGrupoOcupacionalJResponse response = new EliminarAreaEspecialidadActividadGrupoOcupacionalJResponse();
		Confirmacion confirmar = areaEspecialidadActividadGrupoOcupacionalMapper.eliminarAreaEspecialidadActividadGrupoOcupacionalJ(
				request.getIdIPRESS(),
				request.getIdArea(), 
				request.getIdEspecialidad(),
				request.getIdActividad(), 
				request.getIdGrupoOcupacional());
		response.setConfirmacion(confirmar);
		return response;
	}
	

}
