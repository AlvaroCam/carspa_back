/**
 * 
 */
package pe.com.tintegro.sigs.dto.request;

/**
 * @author daniel - 12 set. 2017
 *
 */
public class ObtieneEspecialidadRequest extends RequestBase
{
	private Integer idArea;
	private Integer idEspecialidad;

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
}
