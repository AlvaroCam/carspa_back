package pe.com.tintegro.sigs.dto.request;

public class ObtenerEspecialidadJRequest extends RequestBase
{
	private String descripcion_especialidad;
	private int numPagina;
	private int numMostrarPagina;
	
	
	public String getDescripcion_especialidad() {
		return descripcion_especialidad;
	}
	public void setDescripcion_especialidad(String descripcion_especialidad) {
		this.descripcion_especialidad = descripcion_especialidad;
	}
	public int getNumPagina() {
		return numPagina;
	}
	public void setNumPagina(int numPagina) {
		this.numPagina = numPagina;
	}
	public int getNumMostrarPagina() {
		return numMostrarPagina;
	}
	public void setNumMostrarPagina(int numMostrarPagina) {
		this.numMostrarPagina = numMostrarPagina;
	}
	
	
	

}
