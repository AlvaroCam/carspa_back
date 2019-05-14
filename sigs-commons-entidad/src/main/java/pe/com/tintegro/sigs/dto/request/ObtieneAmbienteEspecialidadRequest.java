package pe.com.tintegro.sigs.dto.request;

public class ObtieneAmbienteEspecialidadRequest extends RequestBase{

	private Integer idArea;
	private String descripcionAmbiente;
	private Integer idEspecialidad;
	private Integer idActividad;
	private Integer nuPagina;
	private Integer nuRegisMostrar;
	
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
	public Integer getIdArea() {
		return idArea;
	}
	public void setIdArea(Integer idArea) {
		this.idArea = idArea;
	}
	public String getDescripcionAmbiente() {
		return descripcionAmbiente;
	}
	public void setDescripcionAmbiente(String descripcionAmbiente) {
		this.descripcionAmbiente = descripcionAmbiente;
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
