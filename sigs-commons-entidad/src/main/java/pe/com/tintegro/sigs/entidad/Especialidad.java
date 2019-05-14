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

public class Especialidad implements Serializable
{

	@Override
	public String toString()
	{
		return "Especialidad [idEspecialidad=" + idEspecialidad + ", descripcionEspecialidad=" + descripcionEspecialidad
				+ "]";
	}

	private static final long serialVersionUID = 1L;
	private int idEspecialidad;
	private String descripcionEspecialidad;
	private String abreviatura_espec;
	private int nuTotalReg;

	public String getAbreviatura_espec() {
		return abreviatura_espec;
	}

	public void setAbreviatura_espec(String abreviatura_espec) {
		this.abreviatura_espec = abreviatura_espec;
	}

	public int getNuTotalReg() {
		return nuTotalReg;
	}

	public void setNuTotalReg(int nuTotalReg) {
		this.nuTotalReg = nuTotalReg;
	}

	public int getIdEspecialidad()
	{
		return idEspecialidad;
	}

	public void setIdEspecialidad(int idEspecialidad)
	{
		this.idEspecialidad = idEspecialidad;
	}

	public String getDescripcionEspecialidad()
	{
		return descripcionEspecialidad;
	}

	public void setDescripcionEspecialidad(String descripcionEspecialidad)
	{
		this.descripcionEspecialidad = descripcionEspecialidad;
	}

}
