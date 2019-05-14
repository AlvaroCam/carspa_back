package pe.com.tintegro.sigs.dto.response;

import java.util.List;

import pe.com.tintegro.sigs.entidad.general.Item;

public class ObtenerComboDestinosAtencionResponse extends ResponseBase{
	List<Item> listDestinos;

	public List<Item> getListDestinos() {
		return listDestinos;
	}

	public void setListDestinos(List<Item> listDestinos) {
		this.listDestinos = listDestinos;
	}
	
	
}
