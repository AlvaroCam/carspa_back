package pe.com.tintegro.sigs.dto.request;

/**
 * @author Aldo Huamán
 *
 *         30 ene. 2018
 */
public class ObtienePersonaPorIdPersonaRequest extends RequestBase
{
	private String idPersona;

	public String getIdPersona()
	{
		return idPersona;
	}

	public void setIdPersona(String idPersona)
	{
		this.idPersona = idPersona;
	}

}
