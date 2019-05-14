package pe.com.tintegro.sigs.dto.response;

import pe.com.tintegro.sigs.entidad.Persona;

/**
 * @author Aldo Huamán
 *
 * 10 ene. 2018
 */
public class ObtienePersonaDatosPorCitaResponse extends ResponseBase
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
