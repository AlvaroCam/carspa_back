package pe.com.tintegro.sigs.dto.response;

import java.util.List;

import pe.com.tintegro.sigs.entidad.Ipress;

public class ObtenerComboIpressByUsuarioResponse extends ResponseBase{
	private List<Ipress> ipress ;

	public List<Ipress> getIpress() {
		return ipress;
	}

	public void setIpress(List<Ipress> ipress) {
		this.ipress = ipress;
	}
	
}
