/**
 * 
 */
package pe.com.tintegro.sigs.dto.request;

/**
 * @author daniel - 18 set. 2017
 *
 */
public class ObtienePersonalRequest extends RequestBase
{
	private Integer idArea;
	private Integer idEspecialidad;
	private Integer idActividad;
	private Integer idSubActividad;
	private String idPersonal;

	public Integer getIdArea()
	{
		return idArea;
	}

	public void setIdArea(Integer idArea)
	{
		this.idArea = idArea;
	}

	public Integer getIdEspecialidad()
	{
		return idEspecialidad;
	}

	public void setIdEspecialidad(Integer idEspecialidad)
	{
		this.idEspecialidad = idEspecialidad;
	}

	public Integer getIdActividad()
	{
		return idActividad;
	}

	public void setIdActividad(Integer idActividad)
	{
		this.idActividad = idActividad;
	}

	public Integer getIdSubActividad()
	{
		return idSubActividad;
	}

	public void setIdSubActividad(Integer idSubActividad)
	{
		this.idSubActividad = idSubActividad;
	}

	public String getIdPersonal()
	{
		return idPersonal;
	}

	public void setIdPersonal(String idPersonal)
	{
		this.idPersonal = idPersonal;
	}
}
