package pe.com.tintegro.sigs.dto.request;

public class ActualizarAreaPorEspecialidadRequest extends RequestBase{
	
	private Integer idArea;
	private Integer idEspecialidad;
	private Integer rpct;
	private Integer flag_interconsulta;
	private Integer idSexo;
	private Integer edadMaxima;
	private Integer edadMinima;
	
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
	public Integer getRpct() {
		return rpct;
	}
	public void setRpct(Integer rpct) {
		this.rpct = rpct;
	}
	public Integer getFlag_interconsulta() {
		return flag_interconsulta;
	}
	public void setFlag_interconsulta(Integer flag_interconsulta) {
		this.flag_interconsulta = flag_interconsulta;
	}
	public Integer getIdSexo() {
		return idSexo;
	}
	public void setIdSexo(Integer idSexo) {
		this.idSexo = idSexo;
	}
	public Integer getEdadMaxima() {
		return edadMaxima;
	}
	public void setEdadMaxima(Integer edadMaxima) {
		this.edadMaxima = edadMaxima;
	}
	public Integer getEdadMinima() {
		return edadMinima;
	}
	public void setEdadMinima(Integer edadMinima) {
		this.edadMinima = edadMinima;
	}
	
	
	
}
