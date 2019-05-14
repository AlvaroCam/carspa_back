package pe.com.tintegro.sigs.dto.request;

public class InsertarAreaRequest extends RequestBase{
	
	private String abreviaturaArea;
	private String descripcionArea;
	
	public String getAbreviaturaArea() {
		return abreviaturaArea;
	}
	public void setAbreviaturaArea(String abreviaturaArea) {
		this.abreviaturaArea = abreviaturaArea;
	}
	public String getDescripcionArea() {
		return descripcionArea;
	}
	public void setDescripcionArea(String descripcionArea) {
		this.descripcionArea = descripcionArea;
	}
	
}
