package pe.com.tintegro.sigs.dto.response;

import pe.com.tintegro.sigs.entidad.Persona;

/**
 * @author Aldo Huamán
 *
 * 27 dic. 2017
 */
public class ObtienePersonaDatosPorActoMedicoResponse extends ResponseBase
{
	private Persona persona;

	public Persona getPersona()
	{
		return persona;
	}

	public void setPersona(Persona persona)
	{
		this.persona = persona;
	}
}
