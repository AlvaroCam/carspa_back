/**
 * 
 */
package pe.com.tintegro.sigs.dto.response;

import pe.com.tintegro.sigs.entidad.general.Item;

/**
 * @author daniel - 14 set. 2017
 *
 */
public class ObtieneAmbienteResponse extends ResponseBase
{
	private Item ambiente;

	public Item getAmbiente()
	{
		return ambiente;
	}

	public void setAmbiente(Item ambiente)
	{
		this.ambiente = ambiente;
	}
}
