package pe.com.tintegro.sigs.dto.response;

import java.util.List;

import pe.com.tintegro.sigs.entidad.Especialidad;

public class ObtenerEspecialidadJResponse extends ResponseBase
{
	private List<Especialidad> especialidadList;
	private Integer nuTotalReg;
	
	public List<Especialidad> getEspecialidadList() {
		return especialidadList;
	}
	public void setEspecialidadList(List<Especialidad> especialidadList) {
		this.especialidadList = especialidadList;
	}
	public Integer getNuTotalReg() {
		return nuTotalReg;
	}
	public void setNuTotalReg(Integer nuTotalReg) {
		this.nuTotalReg = nuTotalReg;
	}	
}
