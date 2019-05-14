package pe.com.tintegro.sigs.entidad;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_NULL)
public class Historia implements Serializable
{
	
	@Override
	public String toString()
	{
		return "\nHistoria [idHistoria=" + idHistoria + "]";
	}

	private static final long serialVersionUID = 1L;
	
	private int idHistoria;

	public int getIdHistoria()
	{
		return idHistoria;
	}

	public void setIdHistoria(int idHistoria)
	{
		this.idHistoria = idHistoria;
	}
}
