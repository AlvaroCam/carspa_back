package pe.com.tintegro.sigs.dto.response;

import java.util.List;

import pe.com.tintegro.sigs.entidad.general.Item;

public class ObtieneTipoDocumentoResponse extends ResponseBase{

	List<Item> tipoDocumentoList;

	public List<Item> getTipoDocumentoList() {
		return tipoDocumentoList;
	}

	public void setTipoDocumentoList(List<Item> tipoDocumentoList) {
		this.tipoDocumentoList = tipoDocumentoList;
	}


}
