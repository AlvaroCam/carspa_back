package pe.com.tintegro.sigs.dto.response;

import java.util.List;

import pe.com.tintegro.sigs.entidad.general.Item;

public class ObtieneEspecialidadesConsultaAmbulatoriaResponse extends ResponseBase{
	
	private List<Item> especialidadList;

	public List<Item> getEspecialidadList() {
		return especialidadList;
	}

	public void setEspecialidadList(List<Item> especialidadList) {
		this.especialidadList = especialidadList;
	}
	
	
}
