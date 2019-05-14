package pe.com.tintegro.sigs.dto.request;

public class InsertarActividadRequest extends RequestBase{

	private String descripcionActividad;
	private String abreviatura;
	private Integer tipoProgramacion;
	private Integer tipoActividad;
	private String ambiente;


	public String getDescripcionActividad() {
		return descripcionActividad;
	}
	public void setDescripcionActividad(String descripcionActividad) {
		this.descripcionActividad = descripcionActividad;
	}
	
	public String getAbreviatura() {
		return abreviatura;
	}
	public void setAbreviatura(String abreviatura) {
		this.abreviatura = abreviatura;
	}
	
	public Integer getTipoProgramacion() {
		return tipoProgramacion;
	}
	public void setTipoProgramacion(Integer tipoProgramacion) {
		this.tipoProgramacion = tipoProgramacion;
	}
	
	public Integer getTipoActividad() {
		return tipoActividad;
	}
	public void setTipoActividad(Integer tipoActividad) {
		this.tipoActividad = tipoActividad;
	}
	public String getAmbiente() {
		return ambiente;
	}
	public void setAmbiente(String ambiente) {
		this.ambiente = ambiente;
	}
	
}
