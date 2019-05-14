package pe.com.tintegro.sigs.entidad;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_NULL)
public class AreaEspecialidadActividadGrupoOcupacional implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int idArea;
	private String descripcionArea;
	private int idEspecialidad;
	private String descripcionEspecialidad;
	private int idActividad;
	private String descripcionActividad;
	private int idGrupoOcupacional;
	private String descripcion_form_impre;
	private Integer nuTotalReg;
	
	
	public int getIdArea() {
		return idArea;
	}
	public void setIdArea(int idArea) {
		this.idArea = idArea;
	}
	public String getDescripcionArea() {
		return descripcionArea;
	}
	public void setDescripcionArea(String descripcionArea) {
		this.descripcionArea = descripcionArea;
	}
	public int getIdEspecialidad() {
		return idEspecialidad;
	}
	public void setIdEspecialidad(int idEspecialidad) {
		this.idEspecialidad = idEspecialidad;
	}
	public String getDescripcionEspecialidad() {
		return descripcionEspecialidad;
	}
	public void setDescripcionEspecialidad(String descripcionEspecialidad) {
		this.descripcionEspecialidad = descripcionEspecialidad;
	}
	public int getIdActividad() {
		return idActividad;
	}
	public void setIdActividad(int idActividad) {
		this.idActividad = idActividad;
	}
	public String getDescripcionActividad() {
		return descripcionActividad;
	}
	public void setDescripcionActividad(String descripcionActividad) {
		this.descripcionActividad = descripcionActividad;
	}
	public int getIdGrupoOcupacional() {
		return idGrupoOcupacional;
	}
	public void setIdGrupoOcupacional(int idGrupoOcupacional) {
		this.idGrupoOcupacional = idGrupoOcupacional;
	}
	public String getDescripcionGrupoOcupacional() {
		return descripcion_form_impre;
	}
	public void setDescripcionGrupoOcupacional(String descripcionGrupoOcupacional) {
		this.descripcion_form_impre = descripcionGrupoOcupacional;
	}

	public Integer getNuTotalReg() {
		return nuTotalReg;
	}
	public void setNuTotalReg(Integer nuTotalReg) {
		this.nuTotalReg = nuTotalReg;
	}
}
