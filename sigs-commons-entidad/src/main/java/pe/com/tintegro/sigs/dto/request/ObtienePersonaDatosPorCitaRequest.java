package pe.com.tintegro.sigs.dto.request;

/**
 * @author Aldo Huamán
 *
 * 10 ene. 2018
 */
public class ObtienePersonaDatosPorCitaRequest extends RequestBase
{
	private String idCita;

	public String getIdCita()
	{
		return idCita;
	}

	public void setIdCita(String idCita)
	{
		this.idCita = idCita;
	}
	
	
}
