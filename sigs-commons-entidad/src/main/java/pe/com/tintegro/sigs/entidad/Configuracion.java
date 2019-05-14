package pe.com.tintegro.sigs.entidad;

import java.io.Serializable;

/**
 * @author Aldo Huamán
 *
 * 19 dic. 2017
 */
public class Configuracion implements Serializable
{
	private static final long serialVersionUID = 1L;
	private int idConfiguracion;
	private String itemConfiguracion;
	private String valor;

	public int getIdConfiguracion()
	{
		return idConfiguracion;
	}

	public void setIdConfiguracion(int idConfiguracion)
	{
		this.idConfiguracion = idConfiguracion;
	}

	public String getItemConfiguracion()
	{
		return itemConfiguracion;
	}

	public void setItemConfiguracion(String itemConfiguracion)
	{
		this.itemConfiguracion = itemConfiguracion;
	}

	public String getValor()
	{
		return valor;
	}

	public void setValor(String valor)
	{
		this.valor = valor;
	}
}
