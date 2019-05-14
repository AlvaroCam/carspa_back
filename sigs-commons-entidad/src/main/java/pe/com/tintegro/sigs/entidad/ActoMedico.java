package pe.com.tintegro.sigs.entidad;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import pe.com.tintegro.sigs.entidad.general.Item;

/**
 * @author Aldo Huamán
 *
 *         27 dic. 2017
 */

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_NULL)
public class ActoMedico implements Serializable
{

	@Override
	public String toString()
	{
		return "ActoMedico [idActoMedico=" + idActoMedico + ", feAtencion=" + feAtencion + ", edadAtencion="
				+ edadAtencion + ", hoAtencion=" + hoAtencion + ", area=" + area + ", personal=" + personal
				+ ", programacion=" + programacion + "]";
	}

	private static final long serialVersionUID = 1L;
	private Integer idActoMedico;
	private String feAtencion;
	private String edadAtencion;
	private String hoAtencion;
	private Item area;
	private Personal personal;
	private Programacion programacion;

	public String getEdadAtencion()
	{
		return edadAtencion;
	}

	public void setEdadAtencion(String edadAtencion)
	{
		this.edadAtencion = edadAtencion;
	}

	public String getHoAtencion()
	{
		return hoAtencion;
	}

	public void setHoAtencion(String hoAtencion)
	{
		this.hoAtencion = hoAtencion;
	}

	public String getFeAtencion()
	{
		return feAtencion;
	}

	public void setFeAtencion(String feAtencion)
	{
		this.feAtencion = feAtencion;
	}

	public Item getArea()
	{
		return area;
	}

	public void setArea(Item area)
	{
		this.area = area;
	}

	public Personal getPersonal()
	{
		return personal;
	}

	public void setPersonal(Personal personal)
	{
		this.personal = personal;
	}

	public Programacion getProgramacion()
	{
		return programacion;
	}

	public void setProgramacion(Programacion programacion)
	{
		this.programacion = programacion;
	}

	public Integer getIdActoMedico()
	{
		return idActoMedico;
	}

	public void setIdActoMedico(Integer idActoMedico)
	{
		this.idActoMedico = idActoMedico;
	}
}
