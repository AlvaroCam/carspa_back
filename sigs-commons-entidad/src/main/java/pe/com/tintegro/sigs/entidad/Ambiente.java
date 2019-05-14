package pe.com.tintegro.sigs.entidad;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_NULL)
public class Ambiente implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer idAmbiente;
	private String descripcionAmbiente;
	private Integer fisico;
	private Integer funcional;
	private Integer flEstado;
	private String fhIns;
	private String usuarioMod;
	private String fhMod;
	private String idIPRESS;
	private Integer idArea;
	private String descripcionArea;
	private String abreviaturaAmbiente;
	private Integer idEspecialidad;
	private Integer idActividad;
	private String descripcionEspecialidadActividad;
	private String descripcionActividad;
	private Integer nuTotalReg;
	private String jsonDetalleEspecialidadActividad;
	
	public String getJsonDetalleEspecialidadActividad() {
		return jsonDetalleEspecialidadActividad;
	}
	public void setJsonDetalleEspecialidadActividad(
			String jsonDetalleEspecialidadActividad) {
		this.jsonDetalleEspecialidadActividad = jsonDetalleEspecialidadActividad;
	}
	public Integer getNuTotalReg() {
		return nuTotalReg;
	}
	public void setNuTotalReg(Integer nuTotalReg) {
		this.nuTotalReg = nuTotalReg;
	}
	public Integer getIdAmbiente() {
		return idAmbiente;
	}
	public void setIdAmbiente(Integer idAmbiente) {
		this.idAmbiente = idAmbiente;
	}
	public String getDescripcionAmbiente() {
		return descripcionAmbiente;
	}
	public void setDescripcionAmbiente(String descripcionAmbiente) {
		this.descripcionAmbiente = descripcionAmbiente;
	}
	public Integer getFisico() {
		return fisico;
	}
	public void setFisico(Integer fisico) {
		this.fisico = fisico;
	}
	public Integer getFuncional() {
		return funcional;
	}
	public void setFuncional(Integer funcional) {
		this.funcional = funcional;
	}
	public Integer getFlEstado() {
		return flEstado;
	}
	public void setFlEstado(Integer flEstado) {
		this.flEstado = flEstado;
	}
	public String getFhIns() {
		return fhIns;
	}
	public void setFhIns(String fhIns) {
		this.fhIns = fhIns;
	}
	public String getUsuarioMod() {
		return usuarioMod;
	}
	public void setUsuarioMod(String usuarioMod) {
		this.usuarioMod = usuarioMod;
	}
	public String getFhMod() {
		return fhMod;
	}
	public void setFhMod(String fhMod) {
		this.fhMod = fhMod;
	}
	public String getIdIPRESS() {
		return idIPRESS;
	}
	public void setIdIPRESS(String idIPRESS) {
		this.idIPRESS = idIPRESS;
	}
	public Integer getIdArea() {
		return idArea;
	}
	public void setIdArea(Integer idArea) {
		this.idArea = idArea;
	}
	public String getAbreviaturaAmbiente() {
		return abreviaturaAmbiente;
	}
	public void setAbreviaturaAmbiente(String abreviaturaAmbiente) {
		this.abreviaturaAmbiente = abreviaturaAmbiente;
	}
	public Integer getIdEspecialidad() {
		return idEspecialidad;
	}
	public void setIdEspecialidad(Integer idEspecialidad) {
		this.idEspecialidad = idEspecialidad;
	}
	public Integer getIdActividad() {
		return idActividad;
	}
	public void setIdActividad(Integer idActividad) {
		this.idActividad = idActividad;
	}
	public String getDescripcionArea() {
		return descripcionArea;
	}
	public void setDescripcionArea(String descripcionArea) {
		this.descripcionArea = descripcionArea;
	}
	public String getDescripcionEspecialidadActividad() {
		return descripcionEspecialidadActividad;
	}
	public void setDescripcionEspecialidadActividad(
			String descripcionEspecialidadActividad) {
		this.descripcionEspecialidadActividad = descripcionEspecialidadActividad;
	}
	public String getDescripcionActividad() {
		return descripcionActividad;
	}
	public void setDescripcionActividad(String descripcionActividad) {
		this.descripcionActividad = descripcionActividad;
	}

}
