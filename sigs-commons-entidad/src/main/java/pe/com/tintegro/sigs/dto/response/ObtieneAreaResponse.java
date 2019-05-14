/**
 * 
 */
package pe.com.tintegro.sigs.dto.response;

import pe.com.tintegro.sigs.entidad.general.Item;

/**
 * @author daniel - 11 set. 2017
 *
 */
public class ObtieneAreaResponse extends ResponseBase
{
	private Item area;

	public Item getArea()
	{
		return area;
	}

	public void setArea(Item area)
	{
		this.area = area;
	}
}
