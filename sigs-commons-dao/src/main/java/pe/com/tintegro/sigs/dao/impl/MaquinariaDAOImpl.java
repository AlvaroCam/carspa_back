package pe.com.tintegro.sigs.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.com.tintegro.sigs.dao.MaquinariaDAO;
import pe.com.tintegro.sigs.dto.request.EliminarMaquinariaRequest;
import pe.com.tintegro.sigs.dto.request.InsertarActualizarMaquinariaRequest;
import pe.com.tintegro.sigs.dto.request.ListarMaquinariaRequest;
import pe.com.tintegro.sigs.dto.response.InsertarActualizarMaquinariaResponse;
import pe.com.tintegro.sigs.dto.response.ListarMaquinariaResponse;
import pe.com.tintegro.sigs.entidad.general.Confirmacion;
import pe.com.tintegro.sigs.mapper.MaquinariaMapper;
import pe.com.tintegro.sigs.entidad.Maquinaria;

@Repository( "maquinariaDAO" )
@Transactional

public class MaquinariaDAOImpl implements MaquinariaDAO {

	@Autowired
	MaquinariaMapper maquinariaMapper;
	@Override
	public InsertarActualizarMaquinariaResponse desactivarMaquinaria(EliminarMaquinariaRequest request) throws Exception {
		InsertarActualizarMaquinariaResponse response = new InsertarActualizarMaquinariaResponse();
		Confirmacion confirmacion = maquinariaMapper.desactivarMaquinaria(request.getIdMaquinaria());
		response.setConfirmacion(confirmacion);
		return response;
	}
	@Override
	public InsertarActualizarMaquinariaResponse activarMaquinaria(EliminarMaquinariaRequest request) throws Exception {
		InsertarActualizarMaquinariaResponse response = new InsertarActualizarMaquinariaResponse();
		Confirmacion confirmacion = maquinariaMapper.activarMaquinaria(request.getIdMaquinaria());
		response.setConfirmacion(confirmacion);
		return response;
	}
	@Override
	public InsertarActualizarMaquinariaResponse insertMaquinaria(InsertarActualizarMaquinariaRequest request) throws Exception {
		InsertarActualizarMaquinariaResponse response = new InsertarActualizarMaquinariaResponse();
		Confirmacion confirmacion = maquinariaMapper.insertMaquinaria(request.getMaquinaria().getNombre(), 
				request.getMaquinaria().getMarca(), 
				request.getMaquinaria().getCodigo(),
				request.getMaquinaria().getFechaMantenimiento(),
				request.getMaquinaria().getDetalle());

		response.setConfirmacion(confirmacion);
		return response;
	}
	@Override
	public InsertarActualizarMaquinariaResponse updateMaquinaria(InsertarActualizarMaquinariaRequest request) throws Exception {
		InsertarActualizarMaquinariaResponse response = new InsertarActualizarMaquinariaResponse();
		Confirmacion confirmacion = maquinariaMapper.updateMaquinaria(request.getMaquinaria().getIdMaquinaria(),request.getMaquinaria().getNombre(), request.getMaquinaria().getMarca(), 
				request.getMaquinaria().getCodigo(),request.getMaquinaria().getFechaMantenimiento(),request.getMaquinaria().getDetalle());

		response.setConfirmacion(confirmacion);
		return response;
	}
	@Override
	public ListarMaquinariaResponse listarMaquinaria(ListarMaquinariaRequest request) throws Exception {
		ListarMaquinariaResponse response = new ListarMaquinariaResponse();
		List<Maquinaria>listaMaquinaria=maquinariaMapper.listarMaquinaria(request.getNombre(),request.getEstado(),request.getNuPagina(), request.getNuRegisMostrar());
		response.setMaquinarias(listaMaquinaria);
		return response;
	}




}