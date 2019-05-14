package pe.com.tintegro.sigs.entidad;

import java.io.Serializable;

public class GradoInstruccion implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int idGradoInstruccion;
	private String descripcionGradoInstruccion;
	private int flEstado;
	private String usuarioIns;
	private String fhIns;
	private String usuarioMod;
	private String fhMod;
	
	public int getIdGradoInstruccion() {
		return idGradoInstruccion;
	}
	public void setIdGradoInstruccion(int idGradoInstruccion) {
		this.idGradoInstruccion = idGradoInstruccion;
	}
	public String getDescripcionGradoInstruccion() {
		return descripcionGradoInstruccion;
	}
	public void setDescripcionGradoInstruccion(String descripcionGradoInstruccion) {
		this.descripcionGradoInstruccion = descripcionGradoInstruccion;
	}
	public int getFlEstado() {
		return flEstado;
	}
	public void setFlEstado(int flEstado) {
		this.flEstado = flEstado;
	}
	public String getUsuarioIns() {
		return usuarioIns;
	}
	public void setUsuarioIns(String usuarioIns) {
		this.usuarioIns = usuarioIns;
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
	
}
