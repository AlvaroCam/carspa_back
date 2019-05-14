package pe.com.tintegro.sigs.dto.response;

import java.util.List;

import pe.com.tintegro.sigs.entidad.general.Item;

public class ObtieneOrigenesResponse extends ResponseBase
{
	private List<Item> origenList;

	public List<Item> getOrigenList() 
	{
		return origenList;
	}

	public void setOrigenList(List<Item> origenList) 
	{
		this.origenList = origenList;
	}
}
