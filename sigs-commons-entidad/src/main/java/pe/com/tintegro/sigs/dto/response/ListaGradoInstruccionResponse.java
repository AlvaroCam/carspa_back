package pe.com.tintegro.sigs.dto.response;

import java.util.List;

import pe.com.tintegro.sigs.entidad.GradoInstruccion;

public class ListaGradoInstruccionResponse {
private List<GradoInstruccion> listadoGradoInstruccion;

public List<GradoInstruccion> getListadoGradoInstruccion() {
	return listadoGradoInstruccion;
}

public void setListadoGradoInstruccion(
		List<GradoInstruccion> listadoGradoInstruccion) {
	this.listadoGradoInstruccion = listadoGradoInstruccion;
}

 
}
