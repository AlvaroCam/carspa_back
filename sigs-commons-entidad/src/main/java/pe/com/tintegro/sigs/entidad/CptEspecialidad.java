package pe.com.tintegro.sigs.entidad;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_NULL)
public class CptEspecialidad implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idEspecialidad;
	private String codigoCpt;
	private Integer nuTotalReg;
	private String jsonIdsCpt;
	private Integer idCpt; 
	private String descripcionEspecialidad; 
	private String descripcionCpt;

	public Integer getIdEspecialidad() {
		return idEspecialidad;
	}
	public void setIdEspecialidad(Integer idEspecialidad) {
		this.idEspecialidad = idEspecialidad;
	}
	public String getCodigoCpt() {
		return codigoCpt;
	}
	public void setCodigoCpt(String codigoCpt) {
		this.codigoCpt = codigoCpt;
	}
	public Integer getNuTotalReg() {
		return nuTotalReg;
	}
	public void setNuTotalReg(Integer nuTotalReg) {
		this.nuTotalReg = nuTotalReg;
	}
	public String getJsonIdsCpt() {
		return jsonIdsCpt;
	}
	public void setJsonIdsCpt(String jsonIdsCpt) {
		this.jsonIdsCpt = jsonIdsCpt;
	}
	public Integer getIdCpt() {
		return idCpt;
	}
	public void setIdCpt(Integer idCpt) {
		this.idCpt = idCpt;
	}
	public String getDescripcionEspecialidad() {
		return descripcionEspecialidad;
	}
	public void setDescripcionEspecialidad(String descripcionEspecialidad) {
		this.descripcionEspecialidad = descripcionEspecialidad;
	}
	public String getDescripcionCpt() {
		return descripcionCpt;
	}
	public void setDescripcionCpt(String descripcionCpt) {
		this.descripcionCpt = descripcionCpt;
	}
	
}
