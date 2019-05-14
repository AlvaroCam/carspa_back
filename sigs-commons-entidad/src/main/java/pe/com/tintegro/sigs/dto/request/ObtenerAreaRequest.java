package pe.com.tintegro.sigs.dto.request;

public class ObtenerAreaRequest extends RequestBase{
	
	private String descripcionArea;
	private int numPagina;
	private int numRegisMostrar;
	
	public String getDescripcionArea() {
		return descripcionArea;
	}
	public void setDescripcionArea(String descripcionArea) {
		this.descripcionArea = descripcionArea;
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
