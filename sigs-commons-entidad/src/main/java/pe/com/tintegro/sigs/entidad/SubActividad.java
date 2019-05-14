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
public class SubActividad implements Serializable
{
	@Override
	public String toString()
	{
		return "SubActividad [idSubActividad=" + idSubActividad + ", descripcionSubActividad=" + descripcionSubActividad
				+ ", actividad=" + actividad + "]";
	}

	private static final long serialVersionUID = 1L;
	private int idSubActividad;
	private String descripcionSubActividad;
	private Actividad actividad;
	private int nuTotalReg;
	private String abreviatura;

	public int getNuTotalReg() {
		return nuTotalReg;
	}

	public void setNuTotalReg(int nuTotalReg) {
		this.nuTotalReg = nuTotalReg;
	}

	public String getAbreviatura() {
		return abreviatura;
	}

	public void setAbreviatura(String abreviatura) {
		this.abreviatura = abreviatura;
	}


	public Actividad getActividad()
	{
		return actividad;
	}

	public void setActividad(Actividad actividad)
	{
		this.actividad = actividad;
	}

	public int getIdSubActividad()
	{
		return idSubActividad;
	}

	public void setIdSubActividad(int idSubActividad)
	{
		this.idSubActividad = idSubActividad;
	}

	public String getDescripcionSubActividad()
	{
		return descripcionSubActividad;
	}

	public void setDescripcionSubActividad(String descripcionSubActividad)
	{
		this.descripcionSubActividad = descripcionSubActividad;
	}

}
