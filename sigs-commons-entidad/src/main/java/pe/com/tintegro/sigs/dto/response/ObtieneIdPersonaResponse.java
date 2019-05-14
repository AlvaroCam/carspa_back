package pe.com.tintegro.sigs.dto.response;

import java.util.List;

import pe.com.tintegro.sigs.entidad.Persona;

/**
 * @author Aldo Huamán
 *
 *         30 ene. 2018
 */
public class ObtieneIdPersonaResponse extends ResponseBase
{
	private List<Persona> personaList;

	public List<Persona> getPersonaList()
	{
		return personaList;
	}

	public void setPersonaList(List<Persona> personaList)
	{
		this.personaList = personaList;
	}

}
