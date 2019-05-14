package pe.com.tintegro.sigs.dto.response;

import java.util.List;

import pe.com.tintegro.sigs.entidad.general.Item;

/**
 * @author Aldo Huamán
 *
 * 24 ene. 2018
 */
public class ObtieneAreasSinAlmacenResponse extends ResponseBase
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
