/**
 * 
 */
package pe.com.tintegro.sigs.dto.request;

/**
 * @author daniel - 12 set. 2017
 *
 */
public class ObtieneSubActividadesRequest extends RequestBase
{
	private Integer idArea;
	private Integer idEspecialidad;
	private Integer idActividad;

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
}
