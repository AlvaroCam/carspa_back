package pe.com.tintegro.sigs.entidad;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_NULL)
public class AreaEspecialidadActividad implements Serializable{
	
	public String toString() {
		return "AreaEspAct ["
				+ "idArea="+ idArea
				+", idEspecialidad="+idEspecialidad
				+", idActividad="+idActividad
				+", actMedica="+actMedica
				+", pacienteHora="+pacienteHora
				+", ambiente="+ambiente
				+", cupoVol="+cCitasVoluntarias
				+", cupoRec="+cRecitas
				+", cupoInter"+cInterconsultas
				+", cupoRefe"+cCitarReferido
				+", cupoDias"+cCitasDias
				+", topeNuevos="+tCuposNuevos
				+", topeAdic="+tCuposAdicionales
				+", diasAdel="+dAdeLiberaCupos+"]";
	}

	private static final long serialVersionUID = 1L;
	
	private Integer idArea;
	private String descripcionArea;
	private Integer idEspecialidad;
	private String descripcionEspecialidad;
	private Integer idActividad;
	private String descripcionActividad;
	private Integer actMedica;
	private Integer pacienteHora;
	private Integer ambiente;
	private Integer cCitasVoluntarias;
	private Integer cRecitas;
	private Integer cInterconsultas;
	private Integer cCitarReferido;
	private Integer cCitasDias;
	private Integer tCuposNuevos;
	private Integer tCuposAdicionales;
	private Integer dAdeLiberaCupos;
	private Integer idFormImpre;
	private String descripcionFormImpre;
	private Integer prioVolu;
	private Integer prioRecita;
	private Integer prioInter;
	private Integer prioReferidos;
	private Integer prioDias;
	private Integer flgAmb;
	private Integer nuTotalReg;
	private Integer tipoProgramacion;
	
	
	
	public Integer getTipoProgramacion() {
		return tipoProgramacion;
	}
	public void setTipoProgramacion(Integer tipoProgramacion) {
		this.tipoProgramacion = tipoProgramacion;
	}
	public Integer getActMedica() {
		return actMedica;
	}
	public void setActMedica(Integer actMedica) {
		this.actMedica = actMedica;
	}
	public Integer getPacienteHora() {
		return pacienteHora;
	}
	public void setPacienteHora(Integer pacienteHora) {
		this.pacienteHora = pacienteHora;
	}
	public Integer getAmbiente() {
		return ambiente;
	}
	public void setAmbiente(Integer ambiente) {
		this.ambiente = ambiente;
	}
	public Integer getcCitasVoluntarias() {
		return cCitasVoluntarias;
	}
	public void setcCitasVoluntarias(Integer cCitasVoluntarias) {
		this.cCitasVoluntarias = cCitasVoluntarias;
	}
	public Integer getcRecitas() {
		return cRecitas;
	}
	public void setcRecitas(Integer cRecitas) {
		this.cRecitas = cRecitas;
	}
	public Integer getcInterconsultas() {
		return cInterconsultas;
	}
	public void setcInterconsultas(Integer cInterconsultas) {
		this.cInterconsultas = cInterconsultas;
	}
	public Integer getcCitarReferido() {
		return cCitarReferido;
	}
	public void setcCitarReferido(Integer cCitarReferido) {
		this.cCitarReferido = cCitarReferido;
	}
	public Integer getcCitasDias() {
		return cCitasDias;
	}
	public void setcCitasDias(Integer cCitasDias) {
		this.cCitasDias = cCitasDias;
	}
	public Integer gettCuposNuevos() {
		return tCuposNuevos;
	}
	public void settCuposNuevos(Integer tCuposNuevos) {
		this.tCuposNuevos = tCuposNuevos;
	}
	public Integer gettCuposAdicionales() {
		return tCuposAdicionales;
	}
	public void settCuposAdicionales(Integer tCuposAdicionales) {
		this.tCuposAdicionales = tCuposAdicionales;
	}
	public Integer getdAdeLiberaCupos() {
		return dAdeLiberaCupos;
	}
	public void setdAdeLiberaCupos(Integer dAdeLiberaCupos) {
		this.dAdeLiberaCupos = dAdeLiberaCupos;
	}
	public Integer getPrioVolu() {
		return prioVolu;
	}
	public void setPrioVolu(Integer prioVolu) {
		this.prioVolu = prioVolu;
	}
	public Integer getPrioRecita() {
		return prioRecita;
	}
	public void setPrioRecita(Integer prioRecita) {
		this.prioRecita = prioRecita;
	}
	public Integer getPrioInter() {
		return prioInter;
	}
	public void setPrioInter(Integer prioInter) {
		this.prioInter = prioInter;
	}
	public Integer getPrioReferidos() {
		return prioReferidos;
	}
	public void setPrioReferidos(Integer prioReferidos) {
		this.prioReferidos = prioReferidos;
	}
	public Integer getPrioDias() {
		return prioDias;
	}
	public void setPrioDias(Integer prioDias) {
		this.prioDias = prioDias;
	}
	public Integer getNuTotalReg() {
		return nuTotalReg;
	}
	public void setNuTotalReg(Integer nuTotalReg) {
		this.nuTotalReg = nuTotalReg;
	}
	public Integer getIdArea() {
		return idArea;
	}
	public void setIdArea(Integer idArea) {
		this.idArea = idArea;
	}
	public String getDescripcionArea() {
		return descripcionArea;
	}
	public void setDescripcionArea(String descripcionArea) {
		this.descripcionArea = descripcionArea;
	}
	public Integer getIdEspecialidad() {
		return idEspecialidad;
	}
	public void setIdEspecialidad(Integer idEspecialidad) {
		this.idEspecialidad = idEspecialidad;
	}
	public String getDescripcionEspecialidad() {
		return descripcionEspecialidad;
	}
	public void setDescripcionEspecialidad(String descripcionEspecialidad) {
		this.descripcionEspecialidad = descripcionEspecialidad;
	}
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
	public Integer getIdFormImpre() {
		return idFormImpre;
	}
	public void setIdFormImpre(Integer idFormImpre) {
		this.idFormImpre = idFormImpre;
	}
	public String getDescripcionFormImpre() {
		return descripcionFormImpre;
	}
	public void setDescripcionFormImpre(String descripcionFormImpre) {
		this.descripcionFormImpre = descripcionFormImpre;
	}
	public Integer getFlgAmb() {
		return flgAmb;
	}
	public void setFlgAmb(Integer flgAmb) {
		this.flgAmb = flgAmb;
	}
	

}
