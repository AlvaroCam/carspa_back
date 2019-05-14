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
public class Programacion implements Serializable
{

	@Override
	public String toString()
	{
		return "Programacion [idProgramacion=" + idProgramacion + ", subActividad=" + subActividad + "]";
	}

	private static final long serialVersionUID = 1L;
	private int idProgramacion;
	private SubActividad subActividad;
	private Especialidad especialidad;
	
	
	public Especialidad getEspecialidad()
	{
		return especialidad;
	}

	public void setEspecialidad(Especialidad especialidad)
	{
		this.especialidad = especialidad;
	}

	public int getIdProgramacion()
	{
		return idProgramacion;
	}

	public void setIdProgramacion(int idProgramacion)
	{
		this.idProgramacion = idProgramacion;
	}

	public SubActividad getSubActividad()
	{
		return subActividad;
	}

	public void setSubActividad(SubActividad subActividad)
	{
		this.subActividad = subActividad;
	}

}
