package pe.com.tintegro.sigs.entidad;

import java.io.Serializable;

/**
 * @author Miguel Mascco
 *
 *         12 ene. 2018
 */
public class OpcionValorCombo implements Serializable
{
	private static final long serialVersionUID = 1L;
	private int idOpcion;
	private String valorOpcion;
	public String getValorOpcion()
	{
		return valorOpcion;
	}
	public void setValorOpcion(String valorOpcion)
	{
		this.valorOpcion = valorOpcion;
	}
	public int getIdOpcion()
	{
		return idOpcion;
	}
	public void setIdOpcion(int idOpcion)
	{
		this.idOpcion = idOpcion;
	}
	
}
