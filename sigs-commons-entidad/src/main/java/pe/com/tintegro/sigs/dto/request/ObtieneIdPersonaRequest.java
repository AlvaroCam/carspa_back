package pe.com.tintegro.sigs.dto.request;

/**
 * @author Aldo Huamán
 *
 *         30 ene. 2018
 */
public class ObtieneIdPersonaRequest extends RequestBase
{
	private int idTipoDocumentoIdentidad;
	private String numeroDocumento;

	public int getIdTipoDocumentoIdentidad()
	{
		return idTipoDocumentoIdentidad;
	}

	public void setIdTipoDocumentoIdentidad(int idTipoDocumentoIdentidad)
	{
		this.idTipoDocumentoIdentidad = idTipoDocumentoIdentidad;
	}

	public String getNumeroDocumento()
	{
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento)
	{
		this.numeroDocumento = numeroDocumento;
	}

}
