package pe.com.tintegro.sigs.dto.request;

/**
 * @author Aldo Huamán
 *
 * 19 dic. 2017
 */
public class ObtieneConfiguracionRequest extends RequestBase
{
	private int idConfiguracion;

	public int getIdConfiguracion()
	{
		return idConfiguracion;
	}

	public void setIdConfiguracion(int idConfiguracion)
	{
		this.idConfiguracion = idConfiguracion;
	}
}
