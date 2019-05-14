package pe.com.tintegro.sigs.dto.response;

import java.util.List;

import pe.com.tintegro.sigs.entidad.general.Item;


public class ObtieneTipoSangreResponse extends ResponseBase{
	
	List<Item> tipoSangre;

	public List<Item> getTipoSangre() {
		return tipoSangre;
	}

	public void setTipoSangre(List<Item> tipoSangre) {
		this.tipoSangre = tipoSangre;
	}
	
}
