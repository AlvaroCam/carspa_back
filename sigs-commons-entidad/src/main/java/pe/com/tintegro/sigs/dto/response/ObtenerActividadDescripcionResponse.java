package pe.com.tintegro.sigs.dto.response;

import java.util.List;
import pe.com.tintegro.sigs.entidad.Actividad;

public class ObtenerActividadDescripcionResponse extends ResponseBase{

	private List<Actividad> actividadList;
	private Integer nuTotalReg;
	
	public List<Actividad> getActividadList() {
		return actividadList;
	}

	public void setActividadList(List<Actividad> actividadList) {
		this.actividadList = actividadList;
	}

	public Integer getNuTotalReg() {
		return nuTotalReg;
	}

	public void setNuTotalReg(Integer nuTotalReg) {
		this.nuTotalReg = nuTotalReg;
	}
}
