/**
 * 
 */
package pe.com.tintegro.sigs.dto.response;

import pe.com.tintegro.sigs.entidad.general.Item;

/**
 * @author daniel - 12 set. 2017
 *
 */
public class ObtieneActividadResponse extends ResponseBase
{
	private Item actividad;

	public Item getActividad()
	{
		return actividad;
	}

	public void setActividad(Item actividad)
	{
		this.actividad = actividad;
	}
}
