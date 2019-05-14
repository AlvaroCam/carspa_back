package pe.com.tintegro.sigs.dto.request;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fasterxml.jackson.databind.ObjectMapper;

import pe.com.tintegro.sigs.entidad.Ambiente;

public class InsertarAmbienteRequest extends RequestBase{
	
	private String descripcionAmbiente;
	private String abreviaturaAmbiente;
	private Integer idArea;
	private List<Ambiente> AmbienteList;
	private String jsonAmbiente;
	
	public String getDescripcionAmbiente() {
		return descripcionAmbiente;
	}
	public void setDescripcionAmbiente(String descripcionAmbiente) {
		this.descripcionAmbiente = descripcionAmbiente;
	}
	public String getAbreviaturaAmbiente() {
		return abreviaturaAmbiente;
	}
	public void setAbreviaturaAmbiente(String abreviaturaAmbiente) {
		this.abreviaturaAmbiente = abreviaturaAmbiente;
	}
	public Integer getIdArea() {
		return idArea;
	}
	public void setIdArea(Integer idArea) {
		this.idArea = idArea;
	}
	public String getJsonAmbiente() {
		return jsonAmbiente;
	}
	public void setJsonAmbiente(String jsonAmbiente) {
		this.jsonAmbiente = jsonAmbiente;
	}
	public List<Ambiente> getAmbienteList() {
		return AmbienteList;
	}
	public void setAmbienteList(List<Ambiente> ambienteList) {
		this.AmbienteList = ambienteList;
		ObjectMapper mapper = new ObjectMapper();
		try {
			String json = mapper.writeValueAsString(ambienteList);
			String a = json.replaceAll(Pattern.quote("\\"), Matcher.quoteReplacement(""));
			String b = a.replaceAll(Pattern.quote("\"["), Matcher.quoteReplacement("["));
			String c = b.replaceAll(Pattern.quote("]\""), Matcher.quoteReplacement("]"));
			setJsonAmbiente(c);
		} catch (Exception e) {

		}
	}
}
