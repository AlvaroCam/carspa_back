package pe.com.tintegro.sigs.dto.request;

public class ObtenerGrupoOcupacionalJRequest extends RequestBase{

	private String descripcionGrupoOcupacional;
	private Integer idTipoProfesional;
	private Integer nuPagina;
	private Integer nuRegisMostrar;
	
	public String getDescripcionGrupoOcupacional() {
		return descripcionGrupoOcupacional;
	}
	public void setDescripcionGrupoOcupacional(String descripcionGrupoOcupacional) {
		this.descripcionGrupoOcupacional = descripcionGrupoOcupacional;
	}
	public Integer getIdTipoProfesional() {
		return idTipoProfesional;
	}
	public void setIdTipoProfesional(Integer idTipoProfesional) {
		this.idTipoProfesional = idTipoProfesional;
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
