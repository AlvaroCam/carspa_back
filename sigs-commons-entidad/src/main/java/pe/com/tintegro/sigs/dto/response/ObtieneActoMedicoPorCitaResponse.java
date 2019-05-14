package pe.com.tintegro.sigs.dto.response;

import pe.com.tintegro.sigs.entidad.ActoMedico;

/**
 * @author Aldo Huamán
 *
 * 10 ene. 2018
 */
public class ObtieneActoMedicoPorCitaResponse extends ResponseBase
{
	private ActoMedico actoMedico;

	public ActoMedico getActoMedico()
	{
		return actoMedico;
	}

	public void setActoMedico(ActoMedico actoMedico)
	{
		this.actoMedico = actoMedico;
	}
	
}
