package pe.com.tintegro.sigs.dto.response;

import java.util.List;

import pe.com.tintegro.sigs.entidad.general.Item;

public class ObtieneExamenAreasResponse extends ResponseBase
{
	private List<Item> examenAreaList;

	public List<Item> getExamenAreaList() 
	{
		return examenAreaList;
	}

	public void setExamenAreaList(List<Item> examenAreaList) 
	{
		this.examenAreaList = examenAreaList;
	}
}
