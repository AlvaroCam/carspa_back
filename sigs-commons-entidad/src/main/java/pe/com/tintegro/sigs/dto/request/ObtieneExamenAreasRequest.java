package pe.com.tintegro.sigs.dto.request;

public class ObtieneExamenAreasRequest extends RequestBase
{
	private Integer idExamenArea;
	private Integer idExamenTipo;

	public Integer getIdExamenTipo() 
	{
		return idExamenTipo;
	}

	public void setIdExamenTipo(Integer idExamenTipo) 
	{
		this.idExamenTipo = idExamenTipo;
	}

	public Integer getIdExamenArea() 
	{
		return idExamenArea;
	}

	public void setIdExamenArea(Integer idExamenArea) 
	{
		this.idExamenArea = idExamenArea;
	}
}
