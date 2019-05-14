package pe.com.tintegro.sigs.dto.response;

import java.util.List;

import pe.com.tintegro.sigs.entidad.general.Item;

public class ObtenerActividadesConsultaAmbulatoriaResponse extends ResponseBase{
	
	private List<Item> actividadList;

	public List<Item> getActividadList() {
		return actividadList;
	}

	public void setActividadList(List<Item> actividadList) {
		this.actividadList = actividadList;
	}
	
	
}
