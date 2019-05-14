package pe.com.tintegro.sigs.dto.response;

import java.util.List;

import pe.com.tintegro.sigs.entidad.general.Item;

public class ObtieneExamenTiposResponse extends ResponseBase 
{
	private List<Item> examenTipoList;

	public List<Item> getExamenTipoList() 
	{
		return examenTipoList;
	}

	public void setExamenTipoList(List<Item> examenTipoList) 
	{
		this.examenTipoList = examenTipoList;
	}
}
