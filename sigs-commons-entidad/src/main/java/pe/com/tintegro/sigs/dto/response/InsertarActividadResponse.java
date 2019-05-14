package pe.com.tintegro.sigs.dto.response;

import pe.com.tintegro.sigs.entidad.general.Confirmacion;

public class InsertarActividadResponse extends ResponseBase{

	Confirmacion confirmacion;

	public Confirmacion getConfirmacion() {
		return confirmacion;
	}

	public void setConfirmacion(Confirmacion confirmacion) {
		this.confirmacion = confirmacion;
	}
}
