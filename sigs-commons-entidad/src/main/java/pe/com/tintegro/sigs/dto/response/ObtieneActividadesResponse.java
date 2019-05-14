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
public class ObtieneActividadesResponse extends ResponseBase
{
	private List<Item> actividadList;

	public List<Item> getActividadList()
	{
		return actividadList;
	}

	public void setActividadList(List<Item> actividadList)
	{
		this.actividadList = actividadList;
	}
}
