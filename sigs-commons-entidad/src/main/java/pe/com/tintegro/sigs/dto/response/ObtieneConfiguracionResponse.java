package pe.com.tintegro.sigs.dto.response;

import pe.com.tintegro.sigs.entidad.Configuracion;

/**
 * @author Aldo Huamán
 *
 * 19 dic. 2017
 */
public class ObtieneConfiguracionResponse extends ResponseBase
{
	private Configuracion configuracion;

	public Configuracion getConfiguracion()
	{
		return configuracion;
	}

	public void setConfiguracion(Configuracion configuracion)
	{
		this.configuracion = configuracion;
	}
}
