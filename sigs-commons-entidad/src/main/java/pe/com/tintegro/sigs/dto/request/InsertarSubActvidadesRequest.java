package pe.com.tintegro.sigs.dto.request;

import pe.com.tintegro.sigs.entidad.Actividad;

public class InsertarSubActvidadesRequest extends RequestBase{

	private String descripcionSubActividad;
	private String abreviatura;
	private Actividad actividad;
//	private Integer idActividad;

//	public Integer getIdActividad() {
//		return idActividad;
//	}
//	public void setIdActividad(Integer idActividad) {
//		this.idActividad = idActividad;
//	}
	public String getDescripcionSubActividad() {
		return descripcionSubActividad;
	}
	public void setDescripcionSubActividad(String descripcionSubActividad) {
		this.descripcionSubActividad = descripcionSubActividad;
	}
	public String getAbreviatura() {
		return abreviatura;
	}
	public void setAbreviatura(String abreviatura) {
		this.abreviatura = abreviatura;
	}
	public Actividad getActividad() {
		return actividad;
	}
	public void setActividad(Actividad actividad) {
		this.actividad = actividad;
	}

}
