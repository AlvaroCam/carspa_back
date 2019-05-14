package pe.com.tintegro.sigs.dto.response;

import java.util.List;

import pe.com.tintegro.sigs.entidad.CptEspecialidad;

public class ListarCptEspecialidadResponse extends ResponseBase{
	private List<CptEspecialidad> listaCptEspecialidad;

	public List<CptEspecialidad> getListaCptEspecialidad() {
		return listaCptEspecialidad;
	}

	public void setListaCptEspecialidad(List<CptEspecialidad> listaCptEspecialidad) {
		this.listaCptEspecialidad = listaCptEspecialidad;
	}
}
