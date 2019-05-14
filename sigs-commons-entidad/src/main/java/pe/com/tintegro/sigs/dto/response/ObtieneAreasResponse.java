/**
 * 
 */
package pe.com.tintegro.sigs.dto.response;

import java.util.List;

import pe.com.tintegro.sigs.entidad.general.Item;

/**
 * @author daniel - 11 set. 2017
 *
 */
public class ObtieneAreasResponse extends ResponseBase
{
	private List<Item> areaList;

	public List<Item> getAreaList()
	{
		return areaList;
	}

	public void setAreaList(List<Item> areaList)
	{
		this.areaList = areaList;
	}
}
