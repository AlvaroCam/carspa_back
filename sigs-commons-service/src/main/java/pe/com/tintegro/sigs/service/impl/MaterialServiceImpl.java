package pe.com.tintegro.sigs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.tintegro.sigs.dao.MaterialDAO;
import pe.com.tintegro.sigs.dto.request.EliminarMaterialRequest;
import pe.com.tintegro.sigs.dto.request.InsertarActualizarMaterialRequest;
import pe.com.tintegro.sigs.dto.request.ListarMaterialRequest;
import pe.com.tintegro.sigs.dto.request.ListarProveedorRequest;
import pe.com.tintegro.sigs.dto.response.InsertarActualizarMaterialResponse;
import pe.com.tintegro.sigs.dto.response.ListarMaterialResponse;
import pe.com.tintegro.sigs.dto.response.ListarProveedorResponse;
import pe.com.tintegro.sigs.service.MaterialService;

@Service("materialService")
public class MaterialServiceImpl implements MaterialService{

	@Autowired
	MaterialDAO materialDAO;

	@Override
	public InsertarActualizarMaterialResponse activarMaterial(
			EliminarMaterialRequest request) throws Exception {

		// TODO Auto-generated method stub
		return materialDAO.activarMaterial(request);
	}

	@Override
	public InsertarActualizarMaterialResponse desactivarMaterial(
			EliminarMaterialRequest request) throws Exception {
		// TODO Auto-generated method stub
		return materialDAO.desactivarMaterial(request);
	}

	@Override
	public InsertarActualizarMaterialResponse insertMaterial(
			InsertarActualizarMaterialRequest request) throws Exception {
		// TODO Auto-generated method stub
		return materialDAO.insertMaterial(request);
	}

	@Override
	public InsertarActualizarMaterialResponse updateMaterial(
			InsertarActualizarMaterialRequest request) throws Exception {
		// TODO Auto-generated method stub
		return materialDAO.updateMaterial(request);
	}

	@Override
	public ListarMaterialResponse listarMateriales(ListarMaterialRequest request)
			throws Exception {
		// TODO Auto-generated method stub
		return materialDAO.listarMateriales(request);
	}

	@Override
	public ListarProveedorResponse comboProveedor(ListarProveedorRequest request)
			throws Exception {
		
		return materialDAO.comboProveedor(request);
	}

	@Override
	public ListarMaterialResponse listarMaterialesAlerta(
			ListarMaterialRequest request) throws Exception {
		
		return materialDAO.listarMaterialesAlerta(request);
	}


}
