package pe.com.tintegro.sigs.dto.response;

import java.util.List;

import pe.com.tintegro.sigs.entidad.AreaEspecialidad;

public class ObtenerAreaPorEspecialidadResponse extends ResponseBase{
	
	private List<AreaEspecialidad> areaEspecialidadList;

	public List<AreaEspecialidad> getAreaEspecialidadList() {
		return areaEspecialidadList;
	}

	public void setAreaEspecialidadList(List<AreaEspecialidad> areaEspecialidadList) {
		this.areaEspecialidadList = areaEspecialidadList;
	}
	
	
}
