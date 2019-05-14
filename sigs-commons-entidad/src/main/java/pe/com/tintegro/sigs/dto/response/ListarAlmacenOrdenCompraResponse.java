package pe.com.tintegro.sigs.dto.response;

import java.util.List;

import pe.com.tintegro.sigs.entidad.AlmacenOrdenCompra;

public class ListarAlmacenOrdenCompraResponse extends ResponseBase {

	private List<AlmacenOrdenCompra> almacenOrdenCompraList;

	public List<AlmacenOrdenCompra> getAlmacenOrdenCompraList() {
		return almacenOrdenCompraList;
	}

	public void setAlmacenOrdenCompraList(
			List<AlmacenOrdenCompra> almacenOrdenCompraList) {
		this.almacenOrdenCompraList = almacenOrdenCompraList;
	}

}
