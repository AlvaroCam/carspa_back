package pe.com.tintegro.sigs.dto.request;

public class InsertarTurnoRequest extends RequestBase{
	
	private String ho_inicio;
	private String ho_final;
	private Integer idActividad;
	public String getHo_inicio() {
		return ho_inicio;
	}
	public void setHo_inicio(String ho_inicio) {
		this.ho_inicio = ho_inicio;
	}
	public String getHo_final() {
		return ho_final;
	}
	public void setHo_final(String ho_final) {
		this.ho_final = ho_final;
	}
	public Integer getIdActividad() {
		return idActividad;
	}
	public void setIdActividad(Integer idActividad) {
		this.idActividad = idActividad;
	}

}
