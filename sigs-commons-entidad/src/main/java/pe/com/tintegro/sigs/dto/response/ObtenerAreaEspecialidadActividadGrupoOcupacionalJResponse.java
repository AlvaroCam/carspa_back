package pe.com.tintegro.sigs.dto.response;

import java.util.List;

import pe.com.tintegro.sigs.entidad.AreaEspecialidadActividadGrupoOcupacional;

public class ObtenerAreaEspecialidadActividadGrupoOcupacionalJResponse extends ResponseBase {

	private List<AreaEspecialidadActividadGrupoOcupacional> areaEspecialidadActividadGrupoOcupacionalList;

	public List<AreaEspecialidadActividadGrupoOcupacional> getAreaEspecialidadActividadGrupoOcupacional() {
		return areaEspecialidadActividadGrupoOcupacionalList;
	}

	public void setAreaEspecialidadActividadGrupoOcupacional(List<AreaEspecialidadActividadGrupoOcupacional> areaEspecialidadActividadGrupoOcupacional) {
		this.areaEspecialidadActividadGrupoOcupacionalList = areaEspecialidadActividadGrupoOcupacional;
	}
}
