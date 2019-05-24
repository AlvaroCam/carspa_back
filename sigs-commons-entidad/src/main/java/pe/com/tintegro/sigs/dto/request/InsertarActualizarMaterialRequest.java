package pe.com.tintegro.sigs.dto.request;

import pe.com.tintegro.sigs.entidad.Material;

public class InsertarActualizarMaterialRequest {
	private Material material;

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

}
