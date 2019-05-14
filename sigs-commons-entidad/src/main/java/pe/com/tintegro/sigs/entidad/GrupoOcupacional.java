package pe.com.tintegro.sigs.entidad;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_NULL)

public class GrupoOcupacional implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int idGrupoOcupacional;
	private String descripcionGrupoOcupacional;
	private Integer idTipoProfesional;
	private String descripcionTipoProfesional;
	private String abreviatura;
	private Integer emitirReceta;
	private Integer otorgarSolicitarExamen;
	private Integer emitirCitt;
	private Integer otorgarMateriales;
	private Integer emitirReferencia;
	private Integer regularAntecedente;

	private int nuTotalReg;
	
	public int getIdGrupoOcupacional() {
		return idGrupoOcupacional;
	}
	public void setIdGrupoOcupacional(int idGrupoOcupacional) {
		this.idGrupoOcupacional = idGrupoOcupacional;
	}
	public String getDescripcionGrupoOcupacional() {
		return descripcionGrupoOcupacional;
	}
	public void setDescripcionGrupoOcupacional(String descripcionGrupoOcupacional) {
		this.descripcionGrupoOcupacional = descripcionGrupoOcupacional;
	}
	public Integer getIdTipoProfesional() {
		return idTipoProfesional;
	}
	public void setIdTipoProfesional(Integer idTipoProfesional) {
		this.idTipoProfesional = idTipoProfesional;
	}
	public String getDescripcionTipoProfesional() {
		return descripcionTipoProfesional;
	}
	public void setDescripcionTipoProfesional(String descripcionTipoProfesional) {
		this.descripcionTipoProfesional = descripcionTipoProfesional;
	}
	public String getAbreviatura() {
		return abreviatura;
	}
	public void setAbreviatura(String abreviatura) {
		this.abreviatura = abreviatura;
	}
	public Integer getEmitirReceta() {
		return emitirReceta;
	}
	public void setEmitirReceta(Integer emitirReceta) {
		this.emitirReceta = emitirReceta;
	}
	public Integer getOtorgarSolicitarExamen() {
		return otorgarSolicitarExamen;
	}
	public void setOtorgarSolicitarExamen(Integer otorgarSolicitarExamen) {
		this.otorgarSolicitarExamen = otorgarSolicitarExamen;
	}
	public Integer getEmitirCitt() {
		return emitirCitt;
	}
	public void setEmitirCitt(Integer emitirCitt) {
		this.emitirCitt = emitirCitt;
	}
	public Integer getOtorgarMateriales() {
		return otorgarMateriales;
	}
	public void setOtorgarMateriales(Integer otorgarMateriales) {
		this.otorgarMateriales = otorgarMateriales;
	}
	public Integer getEmitirReferencia() {
		return emitirReferencia;
	}
	public void setEmitirReferencia(Integer emitirReferencia) {
		this.emitirReferencia = emitirReferencia;
	}
	public Integer getRegularAntecedente() {
		return regularAntecedente;
	}
	public void setRegularAntecedente(Integer regularAntecedente) {
		this.regularAntecedente = regularAntecedente;
	}
	public int getNuTotalReg() {
		return nuTotalReg;
	}
	public void setNuTotalReg(int nuTotalReg) {
		this.nuTotalReg = nuTotalReg;
	}
	
	
	

}
