package pe.com.tintegro.sigs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.tintegro.sigs.dao.MaquinariaDAO;
import pe.com.tintegro.sigs.dto.request.EliminarMaquinariaRequest;
import pe.com.tintegro.sigs.dto.request.InsertarActualizarMaquinariaRequest;
import pe.com.tintegro.sigs.dto.request.ListarMaquinariaRequest;
import pe.com.tintegro.sigs.dto.response.InsertarActualizarMaquinariaResponse;
import pe.com.tintegro.sigs.dto.response.ListarMaquinariaResponse;
import pe.com.tintegro.sigs.service.MaquinariaService;

@Service("maquinariaService")
public class MaquinariaServiceImpl implements MaquinariaService{


	@Autowired
	MaquinariaDAO maquinariaDAO;
	@Override
	public InsertarActualizarMaquinariaResponse desactivarMaquinaria(
			EliminarMaquinariaRequest request) throws Exception {
		// TODO Auto-generated method stub
		return maquinariaDAO.desactivarMaquinaria(request);
	}

	@Override
	public InsertarActualizarMaquinariaResponse activarMaquinaria(
			EliminarMaquinariaRequest request) throws Exception {
		// TODO Auto-generated method stub
		return maquinariaDAO.activarMaquinaria(request);
	}

	@Override
	public InsertarActualizarMaquinariaResponse insertMaquinaria(
			InsertarActualizarMaquinariaRequest request) throws Exception {
		// TODO Auto-generated method stub
		return maquinariaDAO.insertMaquinaria(request);
	}

	@Override
	public InsertarActualizarMaquinariaResponse updateMaquinaria(
			InsertarActualizarMaquinariaRequest request) throws Exception {
		// TODO Auto-generated method stub
		return maquinariaDAO.updateMaquinaria(request);
	}

	@Override
	public ListarMaquinariaResponse listarMaquinaria(
			ListarMaquinariaRequest request) throws Exception {
		// TODO Auto-generated method stub
		return maquinariaDAO.listarMaquinaria(request);
	}

}
