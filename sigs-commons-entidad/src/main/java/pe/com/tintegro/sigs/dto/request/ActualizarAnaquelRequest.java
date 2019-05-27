package pe.com.tintegro.sigs.dto.request;

public class ActualizarAnaquelRequest extends RequestBase {

	private Integer idAlmacenOrdenCompraMaterial;
	private Integer idAnaquel;

	public Integer getIdAlmacenOrdenCompraMaterial() {
		return idAlmacenOrdenCompraMaterial;
	}

	public void setIdAlmacenOrdenCompraMaterial(Integer idAlmacenOrdenCompraMaterial) {
		this.idAlmacenOrdenCompraMaterial = idAlmacenOrdenCompraMaterial;
	}

	public Integer getIdAnaquel() {
		return idAnaquel;
	}

	public void setIdAnaquel(Integer idAnaquel) {
		this.idAnaquel = idAnaquel;
	}

}
