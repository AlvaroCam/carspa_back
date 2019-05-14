package pe.com.tintegro.sigs.dto.request;

public class InsertarGrupoOcupacionalJRequest extends RequestBase{

	private String descripcionGrupoOcupacional;
	private Integer idTipoProfesional;
	private String abreviatura;
	private Integer emitirReceta;
	private Integer otorgarSolicitarExamen;
	private Integer emitirCitt;
	private Integer otorgarMateriales;
	private Integer emitirReferencia;
	private Integer regularAntecedente;
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
	
}
