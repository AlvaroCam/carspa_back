package pe.com.tintegro.sigs.entidad;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_NULL)
public class TipoProfesional implements Serializable {

	@Override
	public String toString(){
		return "Tipo Profesional"
				+ " [id_tipo_profesional=" + id_tipo_profesional 
				+ ", descripcionTipoProfesional=" + descripcionTipoProfesional+ "]";
	}
	
	private static final long serialVersionUID = 1L;
	
	private int id_tipo_profesional;
	private String codigo;
	private String codigoIeds;
	private String descripcionTipoProfesional;
	
	public int getId_tipo_profesional() {
		return id_tipo_profesional;
	}
	public void setId_tipo_profesional(int id_tipo_profesional) {
		this.id_tipo_profesional = id_tipo_profesional;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getCodigoIeds() {
		return codigoIeds;
	}
	public void setCodigoIeds(String codigoIeds) {
		this.codigoIeds = codigoIeds;
	}
	public String getDescripcionTipoProfesional() {
		return descripcionTipoProfesional;
	}
	public void setDescripcionTipoProfesional(String descripcionTipoProfesional) {
		this.descripcionTipoProfesional = descripcionTipoProfesional;
	}
	

}
