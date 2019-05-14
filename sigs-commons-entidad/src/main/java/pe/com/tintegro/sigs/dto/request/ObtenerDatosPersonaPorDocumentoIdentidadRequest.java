package pe.com.tintegro.sigs.dto.request;

public class ObtenerDatosPersonaPorDocumentoIdentidadRequest extends RequestBase{
	
	private String nuDocumento;

	public String getNuDocumento() {
		return nuDocumento;
	}

	public void setNuDocumento(String nuDocumento) {
		this.nuDocumento = nuDocumento;
	}
}
