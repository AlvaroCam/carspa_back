package pe.com.tintegro.sigs.entidad;

import java.io.Serializable;

import pe.com.tintegro.sigs.entidad.general.Item;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_NULL)
public class AreaEspecialidad implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Item area;
	private Item especialidad;
	private String rpct;
	private String flag_interconsulta;
	private Item sexo;
	private Integer edadMaxima;
	private Integer edadMinima;
	private Integer nuTotalReg;
	private String idserapes;
	
	
	public String getIdserapes() {
		return idserapes;
	}
	public void setIdserapes(String idserapes) {
		this.idserapes = idserapes;
	}
	public Item getArea() {
		return area;
	}
	public void setArea(Item area) {
		this.area = area;
	}
	public Item getEspecialidad() {
		return especialidad;
	}
	public void setEspecialidad(Item especialidad) {
		this.especialidad = especialidad;
	}
	public String getRpct() {
		return rpct;
	}
	public void setRpct(String rpct) {
		this.rpct = rpct;
	}
	public String getFlag_interconsulta() {
		return flag_interconsulta;
	}
	public void setFlag_interconsulta(String flag_interconsulta) {
		this.flag_interconsulta = flag_interconsulta;
	}
	public Item getSexo() {
		return sexo;
	}
	public void setSexo(Item sexo) {
		this.sexo = sexo;
	}
	public Integer getEdadMaxima() {
		return edadMaxima;
	}
	public void setEdadMaxima(Integer edadMaxima) {
		this.edadMaxima = edadMaxima;
	}
	public Integer getEdadMinima() {
		return edadMinima;
	}
	public void setEdadMinima(Integer edadMinima) {
		this.edadMinima = edadMinima;
	}
	public Integer getNuTotalReg() {
		return nuTotalReg;
	}
	public void setNuTotalReg(Integer nuTotalReg) {
		this.nuTotalReg = nuTotalReg;
	}
	
	
	
}
