package pe.com.tintegro.sigs.dto.request;

public class ListarCptEspecialidadRequest  extends RequestBase{
	private Integer idEspecialidad;
	private Integer idCpt;
	private Integer nuPagina;
	private Integer nuRegisMostrar;
	
	public Integer getIdEspecialidad() {
		return idEspecialidad;
	}
	public void setIdEspecialidad(Integer idEspecialidad) {
		this.idEspecialidad = idEspecialidad;
	}
	public Integer getIdCpt() {
		return idCpt;
	}
	public void setIdCpt(Integer idCpt) {
		this.idCpt = idCpt;
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
