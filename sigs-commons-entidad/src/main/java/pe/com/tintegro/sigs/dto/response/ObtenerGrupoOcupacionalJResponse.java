package pe.com.tintegro.sigs.dto.response;

import java.util.List;

import pe.com.tintegro.sigs.entidad.GrupoOcupacional;

public class ObtenerGrupoOcupacionalJResponse extends ResponseBase {
	
	private List<GrupoOcupacional> grupoOcupacionalList;
	private Integer nuTotalReg;

	public Integer getNuTotalReg() {
		return nuTotalReg;
	}

	public void setNuTotalReg(Integer nuTotalReg) {
		this.nuTotalReg = nuTotalReg;
	}

	public List<GrupoOcupacional> getGrupoOcupacionalList() {
		return grupoOcupacionalList;
	}

	public void setGrupoOcupacionalList(List<GrupoOcupacional> grupoOcupacionalList) {
		this.grupoOcupacionalList = grupoOcupacionalList;
	}

}
