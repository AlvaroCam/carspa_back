package pe.com.tintegro.sigs.entidad;

import java.io.Serializable;

/**
 * @author Aldo Huamán
 *
 * 27 dic. 2017
 */
public class Cobertura implements Serializable
{
	
	@Override
	public String toString()
	{
		return "\nCobertura [idCobertura=" + idCobertura + ", descripcionCobertura=" + descripcionCobertura + "]";
	}

	private static final long serialVersionUID = 1L;
	private int idCobertura;
	private String descripcionCobertura;

	public String getDescripcionCobertura()
	{
		return descripcionCobertura;
	}

	public void setDescripcionCobertura(String descripcionCobertura)
	{
		this.descripcionCobertura = descripcionCobertura;
	}

	public int getIdCobertura()
	{
		return idCobertura;
	}

	public void setIdCobertura(int idCobertura)
	{
		this.idCobertura = idCobertura;
	}
}
