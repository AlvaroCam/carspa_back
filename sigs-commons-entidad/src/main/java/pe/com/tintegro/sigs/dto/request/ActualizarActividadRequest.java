package pe.com.tintegro.sigs.dto.request;

public class ActualizarActividadRequest extends RequestBase{
private Integer idActividad;
private String descripcionActividad;
private String abreviatura;
private Integer tipoProgramacion;
private Integer tipoActividad;
private Integer ambiente;
public Integer getIdActividad() {
	return idActividad;
}
public void setIdActividad(Integer idActividad) {
	this.idActividad = idActividad;
}
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
public Integer getAmbiente() {
	return ambiente;
}
public void setAmbiente(Integer ambiente) {
	this.ambiente = ambiente;
}

}
