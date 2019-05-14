/**
 * 
 */
package pe.com.tintegro.sigs.dto.response;

import pe.com.tintegro.sigs.entidad.general.Item;

/**
 * @author daniel - 12 set. 2017
 *
 */
public class ObtieneSubActividadResponse extends ResponseBase
{
	private Item subActividad;

	public Item getSubActividad()
	{
		return subActividad;
	}

	public void setSubActividad(Item subActividad)
	{
		this.subActividad = subActividad;
	}
}
