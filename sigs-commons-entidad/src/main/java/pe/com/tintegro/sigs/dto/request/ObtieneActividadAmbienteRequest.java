package pe.com.tintegro.sigs.dto.request;

public class ObtieneActividadAmbienteRequest extends RequestBase{

	private Integer idArea;
	private Integer idEspecialidad;
//	private String idIPRESS;
//	
//	public String getIdIPRESS() {
//		return idIPRESS;
//	}
//	public void setIdIPRESS(String idIPRESS) {
//		this.idIPRESS = idIPRESS;
//	}
	public Integer getIdArea() {
		return idArea;
	}
	public void setIdArea(Integer idArea) {
		this.idArea = idArea;
	}
	public Integer getIdEspecialidad() {
		return idEspecialidad;
	}
	public void setIdEspecialidad(Integer idEspecialidad) {
		this.idEspecialidad = idEspecialidad;
	}
	
}
