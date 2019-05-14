package pe.com.tintegro.sigs.dto.request;

public class RequestBase
{
	private String codUsuario;
	private String idIPRESS;

	public String getCodUsuario()
	{
		return codUsuario;
	}

	public void setCodUsuario(String codUsuario)
	{
		this.codUsuario = codUsuario;
	}

	public String getIdIPRESS()
	{
		return idIPRESS;
	}

	public void setIdIPRESS(String idIPRESS)
	{
		this.idIPRESS = idIPRESS;
	}
}
