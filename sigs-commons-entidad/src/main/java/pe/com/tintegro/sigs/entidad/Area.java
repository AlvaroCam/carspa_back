package pe.com.tintegro.sigs.entidad;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_NULL)
public class Area implements Serializable{
	
	@Override
	
	public String toString() {
		return "Area [idArea="+ idArea +", descripcionArea="+descripcionArea+", abreviaturaArea="+abreviaturaArea+"]";
		
	}

	private static final long serialVersionUID = 1L;
	private int idArea;
	private String descripcionArea;
	private String abreviaturaArea;
	private int nuTotalReg;
	
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
	public String getAbreviaturaArea() {
		return abreviaturaArea;
	}
	public void setAbreviaturaArea(String abreviaturaArea) {
		this.abreviaturaArea = abreviaturaArea;
	}
	public int getNuTotalReg() {
		return nuTotalReg;
	}
	public void setNuTotalReg(int nuTotalReg) {
		this.nuTotalReg = nuTotalReg;
	}

}
