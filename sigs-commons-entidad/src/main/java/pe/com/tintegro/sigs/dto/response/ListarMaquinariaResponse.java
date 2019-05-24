package pe.com.tintegro.sigs.dto.response;
import java.util.List;

import pe.com.tintegro.sigs.entidad.Maquinaria;

public class ListarMaquinariaResponse extends ResponseBase{
	private List <Maquinaria> maquinarias;

	public List <Maquinaria> getMaquinarias() {
		return maquinarias;
	}

	public void setMaquinarias(List <Maquinaria> maquinarias) {
		this.maquinarias = maquinarias;
	}
}

