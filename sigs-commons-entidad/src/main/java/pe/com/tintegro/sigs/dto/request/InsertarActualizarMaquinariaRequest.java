package pe.com.tintegro.sigs.dto.request;

import pe.com.tintegro.sigs.entidad.Maquinaria;


public class InsertarActualizarMaquinariaRequest {
	private Maquinaria maquinaria;

	public Maquinaria getMaquinaria() {
		return maquinaria;
	}

	public void setMaquinaria(Maquinaria maquinaria) {
		this.maquinaria = maquinaria;
	}

}
