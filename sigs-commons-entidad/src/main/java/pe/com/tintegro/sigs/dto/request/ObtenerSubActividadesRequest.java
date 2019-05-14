package pe.com.tintegro.sigs.dto.request;

public class ObtenerSubActividadesRequest extends RequestBase {
		     
	private String descripcionSubActividad;
	private int numPagina;
	private int numRegisMostrar;
	
	
	public String getDescripcionSubActividad() {
		return descripcionSubActividad;
	}
	public void setDescripcionSubActividad(String descripcionSubActividad) {
		this.descripcionSubActividad = descripcionSubActividad;
	}
	public int getNumPagina() {
		return numPagina;
	}
	public void setNumPagina(int numPagina) {
		this.numPagina = numPagina;
	}
	public int getNumRegisMostrar() {
		return numRegisMostrar;
	}
	public void setNumRegisMostrar(int numRegisMostrar) {
		this.numRegisMostrar = numRegisMostrar;
	}
}
