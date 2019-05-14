package pe.com.tintegro.sigs.entidad;

import java.io.Serializable;

/**
 * @author Aldo Huamán
 *
 * 27 dic. 2017
 */
public class Iafas implements Serializable
{
	
	@Override
	public String toString()
	{
		return "\nIafas [idIafas=" + idIafas + ", descripcionIafas=" + descripcionIafas + "]";
	}

	private static final long serialVersionUID = 1L;
	private int idIafas;
	private String descripcionIafas;

	public int getIdIafas()
	{
		return idIafas;
	}

	public void setIdIafas(int idIafas)
	{
		this.idIafas = idIafas;
	}

	public String getDescripcionIafas()
	{
		return descripcionIafas;
	}

	public void setDescripcionIafas(String descripcionIafas)
	{
		this.descripcionIafas = descripcionIafas;
	}
}
