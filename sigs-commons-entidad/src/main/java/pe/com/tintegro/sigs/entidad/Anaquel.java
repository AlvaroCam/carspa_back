package pe.com.tintegro.sigs.entidad;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class Anaquel implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer idAnaquel;
	private String nombreAnaquel;
	private Double cantidadTotal;
	private Double cantidadActual;

	public Integer getIdAnaquel() {
		return idAnaquel;
	}

	public void setIdAnaquel(Integer idAnaquel) {
		this.idAnaquel = idAnaquel;
	}

	public String getNombreAnaquel() {
		return nombreAnaquel;
	}

	public void setNombreAnaquel(String nombreAnaquel) {
		this.nombreAnaquel = nombreAnaquel;
	}

	public Double getCantidadTotal() {
		return cantidadTotal;
	}

	public void setCantidadTotal(Double cantidadTotal) {
		this.cantidadTotal = cantidadTotal;
	}

	public Double getCantidadActual() {
		return cantidadActual;
	}

	public void setCantidadActual(Double cantidadActual) {
		this.cantidadActual = cantidadActual;
	}

}
