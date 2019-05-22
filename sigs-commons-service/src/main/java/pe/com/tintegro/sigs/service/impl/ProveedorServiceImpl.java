package pe.com.tintegro.sigs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.tintegro.sigs.constants.ResponseEstado;
import pe.com.tintegro.sigs.dao.ProveedorDAO;
import pe.com.tintegro.sigs.dto.request.ListarProveedorRequest;
import pe.com.tintegro.sigs.dto.response.ListarProveedorResponse;
import pe.com.tintegro.sigs.service.ProveedorService;

@Service("proveedorService")
public class ProveedorServiceImpl  implements ProveedorService{
	@Autowired
	private ProveedorDAO proveedorDAO;

	@Override
	public ListarProveedorResponse listarProveedor(
			ListarProveedorRequest request) throws Exception {
		ListarProveedorResponse response = new ListarProveedorResponse();
		response = proveedorDAO.listarProveedor(request);
		if (response.getProveedorList().size() == 0) {
			response.setMensaje("No se encuentran ordenes de compra");
			response.setEstado(ResponseEstado.ERROR_NEGOCIO);
		} else {
			response.setMensaje("Se listo correctamente");
			response.setEstado(ResponseEstado.OK);
		}
		return response;
	}
}
