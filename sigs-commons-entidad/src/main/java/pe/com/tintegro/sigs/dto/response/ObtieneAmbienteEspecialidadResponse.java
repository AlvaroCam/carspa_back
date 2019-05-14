package pe.com.tintegro.sigs.dto.response;

import java.util.List;

import pe.com.tintegro.sigs.entidad.Ambiente;

public class ObtieneAmbienteEspecialidadResponse extends ResponseBase{
	
	private List<Ambiente> ambienteList;

	public List<Ambiente> getAmbienteList() {
		return ambienteList;
	}

	public void setAmbienteList(List<Ambiente> ambienteList) {
		this.ambienteList = ambienteList;
	}
	

}
