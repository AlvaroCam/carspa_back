package pe.com.tintegro.sigs.dto.request;

public class ObtenerActividadDescripcionRequest extends RequestBase {

	private String descripcionActividad;
	private Integer nuPagina;
	private Integer nuRegisMostrar;
	
	public String getDescripcionActividad() {
		return descripcionActividad;
	}

	public void setDescripcionActividad(String descripcionActividad) {
		this.descripcionActividad = descripcionActividad;
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
