package pe.com.tintegro.sigs.dto.request;

public class ObtenerAreaPorEspecialidadRequest extends RequestBase{
	
	private Integer idArea;
	private Integer idEspecialidad;
	private Integer nuPagina;
	private Integer nuRegisMostrar;
	
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
	public Integer getNuPagina() {
		return nuPagina;
	}
	public void setNuPagina(Integer nuPagina) {
		this.nuPagina = nuPagina;
	}
	public Integer getNuRegisMostrar() {
		return nuRegisMostrar;
	}
	public void setNuRegisMostrar(Integer nuRegisMostrar) {
		this.nuRegisMostrar = nuRegisMostrar;
	}
	
	
}
