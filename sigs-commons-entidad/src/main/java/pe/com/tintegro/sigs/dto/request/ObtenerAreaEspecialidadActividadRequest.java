package pe.com.tintegro.sigs.dto.request;

public class ObtenerAreaEspecialidadActividadRequest extends RequestBase{
	
	private Integer idArea;
	private Integer idEspecialidad;
	private Integer idActividad;
	private Integer nuPagina;
	private Integer nuRegiMostrar;
	
	public Integer getIdArea() {
		return idArea;
	}
	public void setIdArea(Integer idArea) {
		this.idArea = idArea;
	}
	public Integer getIdEspecialidad() {
		return idEspecialidad;
	}
	public void setIdEspecialidad(Integer idEspecialidad) {
		this.idEspecialidad = idEspecialidad;
	}
	public Integer getIdActividad() {
		return idActividad;
	}
	public void setIdActividad(Integer idActividad) {
		this.idActividad = idActividad;
	}
	public Integer getNuPagina() {
		return nuPagina;
	}
	public void setNuPagina(Integer nuPagina) {
		this.nuPagina = nuPagina;
	}
	public Integer getNuRegiMostrar() {
		return nuRegiMostrar;
	}
	public void setNuRegiMostrar(Integer nuRegiMostrar) {
		this.nuRegiMostrar = nuRegiMostrar;
	}

}
