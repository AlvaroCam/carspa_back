package pe.com.tintegro.sigs.dto.request;

/**
 * @author Aldo Huamán
 *
 * 10 ene. 2018
 */
public class ObtieneActoMedicoPorCitaRequest extends RequestBase
{
	private int idCita;

	public int getIdCita()
	{
		return idCita;
	}

	public void setIdCita(int idCita)
	{
		this.idCita = idCita;
	}
}
