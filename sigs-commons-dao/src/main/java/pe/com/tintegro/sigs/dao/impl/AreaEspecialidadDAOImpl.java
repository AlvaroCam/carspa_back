package pe.com.tintegro.sigs.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
import pe.com.tintegro.sigs.mapper.AreaEspecialidadMapper;

@Repository( "areaEspecialidadDAO" )
@Transactional
public class AreaEspecialidadDAOImpl implements AreaEspecialidadDAO{
	
	@Autowired
	private AreaEspecialidadMapper areaEspecialidadMapper;
	
	@Override
	public ObtenerAreaPorEspecialidadResponse obtenerAreaPorEspecialidad(
			ObtenerAreaPorEspecialidadRequest request) throws Exception {
		ObtenerAreaPorEspecialidadResponse response = new ObtenerAreaPorEspecialidadResponse();
		List<AreaEspecialidad> areaEspecialidadList = areaEspecialidadMapper.obtenerAreaPorEspecialidad(
				request.getIdArea(),
				request.getIdEspecialidad(),
				request.getNuPagina(),
				request.getNuRegisMostrar());
		
		response.setAreaEspecialidadList(areaEspecialidadList);
		return response;
	}

	@Override
	public InsertarAreaPorEspecialidadResponse insertarAreaPorEspecialidad(
			InsertarAreaPorEspecialidadRequest request) throws Exception {
		InsertarAreaPorEspecialidadResponse response = new InsertarAreaPorEspecialidadResponse();
		Confirmacion confirmacion = areaEspecialidadMapper.insertarAreaPorEspecialidad(
				request.getIdArea(),
				request.getIdEspecialidad(),
				request.getRpct(),
				request.getFlag_interconsulta(),
				request.getIdSexo(),
				request.getEdadMaxima(),
				request.getEdadMinima());
		response.setConfirmacion(confirmacion);
		return response;
	}

	@Override
	public ActualizarAreaPorEspecialidadResponse actualizarAreaPorEspecialidad(
			ActualizarAreaPorEspecialidadRequest request) throws Exception {
		ActualizarAreaPorEspecialidadResponse response = new ActualizarAreaPorEspecialidadResponse();
		Confirmacion confirmacion = areaEspecialidadMapper.actualizarAreaPorEspecialidad(
				request.getIdArea(),
				request.getIdEspecialidad(),
				request.getRpct(),
				request.getFlag_interconsulta(),
				request.getIdSexo(),
				request.getEdadMaxima(),
				request.getEdadMinima());
		response.setConfirmacion(confirmacion);
		return response;
	}

	@Override
	public EliminarAreaPorEspecialidadResponse eliminarAreaPorEspecialidad(
			EliminarAreaPorEspecialidadRequest request) throws Exception {
		EliminarAreaPorEspecialidadResponse response = new EliminarAreaPorEspecialidadResponse();
		Confirmacion confirmacion = areaEspecialidadMapper.eliminarAreaPorEspecialidad(
				request.getIdArea(),
				request.getIdEspecialidad());
		response.setConfirmacion(confirmacion);
		return response;
	}

}
