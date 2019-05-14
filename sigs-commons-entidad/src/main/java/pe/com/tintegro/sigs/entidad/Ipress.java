package pe.com.tintegro.sigs.entidad;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_NULL)
public class Ipress implements Serializable
{
	private static final long serialVersionUID = 1L;
	private String idIPRESS;
	private String razonSocial;
	private String idPersonal;
	private String subAc;
	private Integer idNivel;
	private String descripcionNivel;
	
	public Integer getIdNivel() {
		return idNivel;
	}

	public void setIdNivel(Integer idNivel) {
		this.idNivel = idNivel;
	}

	public String getDescripcionNivel() {
		return descripcionNivel;
	}

	public void setDescripcionNivel(String descripcionNivel) {
		this.descripcionNivel = descripcionNivel;
	}

	public String getSubAc() {
		return subAc;
	}

	public void setSubAc(String subAc) {
		this.subAc = subAc;
	}

	public String getIdIPRESS()
	{
		return idIPRESS;
	}

	public void setIdIPRESS(String idIPRESS)
	{
		this.idIPRESS = idIPRESS;
	}

	public String getRazonSocial()
	{
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial)
	{
		this.razonSocial = razonSocial;
	}

	public String getIdPersonal() {
		return idPersonal;
	}

	public void setIdPersonal(String idPersonal) {
		this.idPersonal = idPersonal;
	}
	
}
