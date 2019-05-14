/**
 * 
 */
package pe.com.tintegro.sigs.dto.request;

/**
 * @author daniel - 14 set. 2017
 *
 */
public class ObtieneTurnoRequest extends RequestBase
{
	private Integer idTurno;
	private Integer idActividad;
	
	

	public Integer getIdActividad() {
		return idActividad;
	}

	public void setIdActividad(Integer idActividad) {
		this.idActividad = idActividad;
	}

	public Integer getIdTurno()
	{
		return idTurno;
	}

	public void setIdTurno(Integer idTurno)
	{
		this.idTurno = idTurno;
	}
}
