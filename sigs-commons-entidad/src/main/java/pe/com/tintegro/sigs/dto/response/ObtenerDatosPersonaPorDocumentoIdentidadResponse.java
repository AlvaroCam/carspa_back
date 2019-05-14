package pe.com.tintegro.sigs.dto.response;

import pe.com.tintegro.sigs.entidad.Persona;

public class ObtenerDatosPersonaPorDocumentoIdentidadResponse extends ResponseBase{

	private Persona datosPersona;

	public Persona getDatosPersona() {
		return datosPersona;
	}

	public void setDatosPersona(Persona datosPersona) {
		this.datosPersona = datosPersona;
	}
}
