package pe.com.tintegro.sigs.dto.request;

/**
 * @author Aldo Huamán
 *
 * 10 ene. 2018
 */
public class ObtienePersonaDatosPorActoMedicoRequest extends RequestBase
{
	private Integer idActoMedico;

	public Integer getIdActoMedico()
	{
		return idActoMedico;
	}

	public void setIdActoMedico(Integer idActoMedico)
	{
		this.idActoMedico = idActoMedico;
	}
}
