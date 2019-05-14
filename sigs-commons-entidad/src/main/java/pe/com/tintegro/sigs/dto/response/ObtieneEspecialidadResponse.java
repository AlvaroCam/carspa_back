/**
 * 
 */
package pe.com.tintegro.sigs.dto.response;

import pe.com.tintegro.sigs.entidad.general.Item;

/**
 * @author daniel - 12 set. 2017
 *
 */
public class ObtieneEspecialidadResponse extends ResponseBase
{
	private Item especialidad;

	public Item getEspecialidad()
	{
		return especialidad;
	}

	public void setEspecialidad(Item especialidad)
	{
		this.especialidad = especialidad;
	}
}
