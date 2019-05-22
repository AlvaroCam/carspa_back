package pe.com.tintegro.sigs.dto.request;

public class ListarProveedorRequest extends RequestBase {

	
	private Integer idProveedor;
	private String nombreProveedor;
	private Integer nuPagina;
	private Integer nuRegisMostrar;

	public Integer getIdProveedor() {
		return idProveedor;
	}

	public void setIdProveedor(Integer idProveedor) {
		this.idProveedor = idProveedor;
	}

	public String getNombreProveedor() {
		return nombreProveedor;
	}

	public void setNombreProveedor(String nombreProveedor) {
		this.nombreProveedor = nombreProveedor;
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
