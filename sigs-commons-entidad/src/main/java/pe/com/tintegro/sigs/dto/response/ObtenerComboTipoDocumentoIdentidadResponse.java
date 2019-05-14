package pe.com.tintegro.sigs.dto.response;

import java.util.List;

import pe.com.tintegro.sigs.entidad.ComboGeneral;

public class ObtenerComboTipoDocumentoIdentidadResponse extends ResponseBase{

	private List<ComboGeneral> lsComboTipoDoc;

	public List<ComboGeneral> getLsComboTipoDoc() {
		return lsComboTipoDoc;
	}

	public void setLsComboTipoDoc(List<ComboGeneral> lsComboTipoDoc) {
		this.lsComboTipoDoc = lsComboTipoDoc;
	}
	
}
