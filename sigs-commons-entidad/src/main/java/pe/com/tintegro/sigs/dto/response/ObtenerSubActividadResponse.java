package pe.com.tintegro.sigs.dto.response;

import java.util.List;
import pe.com.tintegro.sigs.entidad.SubActividad;
import pe.com.tintegro.sigs.entidad.general.Item;

public class ObtenerSubActividadResponse extends ResponseBase {

	private List<SubActividad> subActividadList ;
	
	public List<SubActividad> getSubActividadList() {
		return subActividadList;
	}

	public void setSubActividadList(List<SubActividad> subActividadList) {
		this.subActividadList = subActividadList;
	}
}
