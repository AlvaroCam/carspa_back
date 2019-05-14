package pe.com.tintegro.sigs.dto.response;

import java.util.List;

import pe.com.tintegro.sigs.entidad.AlmacenOrdenCompraMaterial;

public class ListarAlmacenOrdenCompraMaterialResponse extends ResponseBase {

	private List<AlmacenOrdenCompraMaterial> almacenOrdenCompraMaterialList;

	public List<AlmacenOrdenCompraMaterial> getAlmacenOrdenCompraMaterialList() {
		return almacenOrdenCompraMaterialList;
	}

	public void setAlmacenOrdenCompraMaterialList(
			List<AlmacenOrdenCompraMaterial> almacenOrdenCompraMaterialList) {
		this.almacenOrdenCompraMaterialList = almacenOrdenCompraMaterialList;
	}

}
