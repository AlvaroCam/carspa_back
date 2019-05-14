/**
 * 
 */
package pe.com.tintegro.sigs.dto.request;

public class ObtieneAmbientesRequest extends RequestBase
{
	private Integer idAmbiente;
	private Integer idArea;
	private Integer idEspecialidad;
	private Integer idActividad;
	
	public Integer getIdAmbiente() {
		return idAmbiente;
	}
	public void setIdAmbiente(Integer idAmbiente) {
		this.idAmbiente = idAmbiente;
	}
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
	public Integer getIdActividad() {
		return idActividad;
	}
	public void setIdActividad(Integer idActividad) {
		this.idActividad = idActividad;
	}
	
	
}
