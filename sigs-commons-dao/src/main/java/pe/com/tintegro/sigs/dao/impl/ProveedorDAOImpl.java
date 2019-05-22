package pe.com.tintegro.sigs.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.com.tintegro.sigs.dao.ProveedorDAO;
import pe.com.tintegro.sigs.dto.request.ActualizarProveedorRequest;

import pe.com.tintegro.sigs.dto.request.ListarProveedorRequest;

import pe.com.tintegro.sigs.dto.response.ActualizarProveedorResponse;
import pe.com.tintegro.sigs.dto.response.ListarProveedorResponse;

import pe.com.tintegro.sigs.entidad.Proveedor;

import pe.com.tintegro.sigs.entidad.general.Confirmacion;
import pe.com.tintegro.sigs.mapper.ProveedorMapper;

@Repository("proveedorDAO")
@Transactional
public class ProveedorDAOImpl implements ProveedorDAO {
	@Autowired
	private ProveedorMapper proveedorMapper;

	@Override
	public ListarProveedorResponse listarProveedor(ListarProveedorRequest request) throws Exception {
		ListarProveedorResponse response = new ListarProveedorResponse();
		List<Proveedor> proveedorList = proveedorMapper.listarProveedor(request.getIdProveedor(),
				request.getNombreProveedor(), request.getNuPagina(), request.getNuRegisMostrar());

		response.setProveedorList(proveedorList);
		System.out.println(request.getIdProveedor());
		return response;
	}

}
