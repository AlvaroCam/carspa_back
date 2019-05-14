package pe.com.tintegro.sigs.dto.response;

import java.util.List;

import pe.com.tintegro.sigs.entidad.AreaEspecialidadActividad;

public class ObtenerAreaEspecialidadActividadResponse extends ResponseBase{
	
	List<AreaEspecialidadActividad> areaEspecialidadActividadList;

	public List<AreaEspecialidadActividad> getAreaEspecialidadActividadList() {
		return areaEspecialidadActividadList;
	}

	public void setAreaEspecialidadActividadList(
			List<AreaEspecialidadActividad> areaEspecialidadActividadList) {
		this.areaEspecialidadActividadList = areaEspecialidadActividadList;
	}

}
