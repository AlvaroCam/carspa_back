/**
 * 
 */
package pe.com.tintegro.sigs.dto.response;

import java.util.List;

import pe.com.tintegro.sigs.entidad.general.Item;

/**
 * @author daniel - 12 set. 2017
 *
 */
public class ObtieneSubActividadesResponse extends ResponseBase
{
	private List<Item> subActividadList;

	public List<Item> getSubActividadList()
	{
		return subActividadList;
	}

	public void setSubActividadList(List<Item> subActividadList)
	{
		this.subActividadList = subActividadList;
	}
}
