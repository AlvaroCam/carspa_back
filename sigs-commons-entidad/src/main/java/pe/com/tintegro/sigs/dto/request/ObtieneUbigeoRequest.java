/**
 * 
 */
package pe.com.tintegro.sigs.dto.request;

/**
 * @author Carlos
 *
 */
public class ObtieneUbigeoRequest extends RequestBase
{
	private String codDepartamento;
	private String codProvincia;

	public String getCodDepartamento()
	{
		return codDepartamento;
	}

	public void setCodDepartamento(String codDepartamento)
	{
		this.codDepartamento = codDepartamento;
		if (codDepartamento.equals("0"))
		{
			this.codDepartamento = null;
		}
	}

	public String getCodProvincia()
	{
		return codProvincia;
	}

	public void setCodProvincia(String codProvincia)
	{
		this.codProvincia = codProvincia;
		if (codProvincia.equals("0"))
		{
			this.codProvincia = null;
		}
		
	}

}
