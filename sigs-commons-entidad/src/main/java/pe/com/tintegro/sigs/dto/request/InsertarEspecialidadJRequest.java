package pe.com.tintegro.sigs.dto.request;

public class InsertarEspecialidadJRequest extends RequestBase
{
	private String descripcion_especialidad;
	private String abreviatura_espec;
	
	public String getDescripcion_especialidad() {
		return descripcion_especialidad;
	}
	public void setDescripcion_especialidad(String descripcion_especialidad) {
		this.descripcion_especialidad = descripcion_especialidad;
	}
	public String getAbreviatura_espec() {
		return abreviatura_espec;
	}
	public void setAbreviatura_espec(String abreviatura_espec) {
		this.abreviatura_espec = abreviatura_espec;
	}
	

}
