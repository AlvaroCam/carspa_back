package pe.com.tintegro.sigs.dto.response;

import java.util.List;

import pe.com.tintegro.sigs.entidad.TipoProfesional;

public class ObtenerTipoProfesionalJResponse extends ResponseBase {

	private List<TipoProfesional> tipoProfesionalList;

	public List<TipoProfesional> getTipoProfesionalList()
	{
		return tipoProfesionalList;
	}

	public void setTipoProfesionalList(List<TipoProfesional> tipoProfesionalList)
	{
		this.tipoProfesionalList = tipoProfesionalList;
	}

}
