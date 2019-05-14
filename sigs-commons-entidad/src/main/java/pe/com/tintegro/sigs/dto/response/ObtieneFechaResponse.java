package pe.com.tintegro.sigs.dto.response;

import java.util.List;

import pe.com.tintegro.sigs.entidad.general.Item;

public class ObtieneFechaResponse extends ResponseBase 
{
	private  List<Item> lsFechaGeneradas;

	public List<Item> getLsFechaGeneradas()
	{
		return lsFechaGeneradas;
	}

	public void setLsFechaGeneradas(List<Item> lsFechaGeneradas)
	{
		this.lsFechaGeneradas = lsFechaGeneradas;
	}
	
}
