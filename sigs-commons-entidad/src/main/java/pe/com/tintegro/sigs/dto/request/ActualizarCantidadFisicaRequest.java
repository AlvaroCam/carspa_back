package pe.com.tintegro.sigs.dto.request;

import java.math.BigDecimal;

public class ActualizarCantidadFisicaRequest extends RequestBase {

	private Integer idAlmacenOrdenCompraMaterial;
	private Integer idAlmacenOrdenCompra;
	private Integer idMaterial;
	private BigDecimal cantidadFisica;

	public Integer getIdAlmacenOrdenCompraMaterial() {
		return idAlmacenOrdenCompraMaterial;
	}

	public void setIdAlmacenOrdenCompraMaterial(
			Integer idAlmacenOrdenCompraMaterial) {
		this.idAlmacenOrdenCompraMaterial = idAlmacenOrdenCompraMaterial;
	}

	public Integer getIdAlmacenOrdenCompra() {
		return idAlmacenOrdenCompra;
	}

	public void setIdAlmacenOrdenCompra(Integer idAlmacenOrdenCompra) {
		this.idAlmacenOrdenCompra = idAlmacenOrdenCompra;
	}

	public Integer getIdMaterial() {
		return idMaterial;
	}

	public void setIdMaterial(Integer idMaterial) {
		this.idMaterial = idMaterial;
	}

	public BigDecimal getCantidadFisica() {
		return cantidadFisica;
	}

	public void setCantidadFisica(BigDecimal cantidadFisica) {
		this.cantidadFisica = cantidadFisica;
	}
}
