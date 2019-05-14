package pe.com.tintegro.sigs.dto.request;

/**
 * @author Miguel - 12 ene. 2018
 *
 */
public class ObtenerComboGeneralRequest extends RequestBase
{
	private String idGrupoOpcion;

	public String getIdGrupoOpcion()
	{
		return idGrupoOpcion;
	}

	public void setIdGrupoOpcion(String idGrupoOpcion)
	{
		this.idGrupoOpcion = idGrupoOpcion;
	}
	
}
