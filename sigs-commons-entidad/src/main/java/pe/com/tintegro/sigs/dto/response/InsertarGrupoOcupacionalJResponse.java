package pe.com.tintegro.sigs.dto.response;

import pe.com.tintegro.sigs.entidad.general.Confirmacion;

public class InsertarGrupoOcupacionalJResponse extends ResponseBase{

private Confirmacion confirmacion;
	
	//Gets & Sets
	public Confirmacion getConfirmacion() {
		return confirmacion;
	}

	public void setConfirmacion(Confirmacion confirmacion) {
		this.confirmacion = confirmacion;
	}

}
