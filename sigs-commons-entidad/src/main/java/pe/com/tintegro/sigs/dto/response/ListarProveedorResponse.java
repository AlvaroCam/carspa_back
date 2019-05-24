package pe.com.tintegro.sigs.dto.response;

import java.util.List;

import pe.com.tintegro.sigs.entidad.Proveedor;;

public class ListarProveedorResponse extends ResponseBase {

	private List<Proveedor> proveedorList;

	public List<Proveedor> getProveedorList() {
		return proveedorList;
	}

	public void setProveedorList(List<Proveedor> proveedorList) {
		this.proveedorList = proveedorList;
	}
}
