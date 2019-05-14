package pe.com.tintegro.sigs.entidad;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * @author Aldo Huamán
 *
 *         10 ene. 2018
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_NULL)
public class Actividad implements Serializable
{

	@Override
	public String toString()
	{
		return "Actividad [idActividad=" + idActividad 
				+ ", descripcionActividad=" + descripcionActividad 
				+ ", abreviatura= " + abreviatura 
				+ ", tipoProgramacion= " + tipoProgramacion
				+ ", tipoActividad = "+ tipoActividad
				+ ",ambiente ="+ambiente
				
				+"]";
	}

	private static final long serialVersionUID = 1L;
	private int idActividad;
	private String descripcionActividad;
	private String abreviatura;
	private Integer tipoProgramacion;
	private Integer nuTotalReg;
	private Integer tipoActividad;
	//////////////////////////////

	private Integer ambiente;
	//////////////////////////
	
  
	
	public Integer getAmbiente() {
		return ambiente;
	}

	public void setAmbiente(Integer ambiente) {
		this.ambiente = ambiente;
	}

	public String getAbreviatura() {
		return abreviatura;
	}

	public void setAbreviatura(String abreviatura) {
		this.abreviatura = abreviatura;
	}

	public Integer getTipoProgramacion() {
		return tipoProgramacion;
	}

	public void setTipoProgramacion(Integer tipoProgramacion) {
		this.tipoProgramacion = tipoProgramacion;
	}

	public Integer getNuTotalReg() {
		return nuTotalReg;
	}

	public void setNuTotalReg(Integer nuTotalReg) {
		this.nuTotalReg = nuTotalReg;
	}

	public Integer getTipoActividad() {
		return tipoActividad;
	}

	public void setTipoActividad(Integer tipoActividad) {
		this.tipoActividad = tipoActividad;
	}


	public int getIdActividad()
	{
		return idActividad;
	}

	public void setIdActividad(int idActividad)
	{
		this.idActividad = idActividad;
	}

	public String getDescripcionActividad()
	{
		return descripcionActividad;
	}

	public void setDescripcionActividad(String descripcionActividad)
	{
		this.descripcionActividad = descripcionActividad;
	}

}
