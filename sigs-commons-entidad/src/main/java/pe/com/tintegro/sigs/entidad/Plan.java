package pe.com.tintegro.sigs.entidad;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * @author Aldo Huamán
 *
 * 27 dic. 2017
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_NULL)
public class Plan implements Serializable
{
	
	@Override
	public String toString()
	{
		return "Plan [iafas=" + iafas + ", cobertura=" + cobertura + ", feVigencia=" + feVigencia + "]";
	}
	private static final long serialVersionUID = 1L;

	private Iafas iafas;
	private Cobertura cobertura;
	private String feVigencia;

	public String getFeVigencia()
	{
		return feVigencia;
	}
	public void setFeVigencia(String feVigencia)
	{
		this.feVigencia = feVigencia;
	}
	public Iafas getIafas()
	{
		return iafas;
	}
	public void setIafas(Iafas iafas)
	{
		this.iafas = iafas;
	}
	public Cobertura getCobertura()
	{
		return cobertura;
	}
	public void setCobertura(Cobertura cobertura)
	{
		this.cobertura = cobertura;
	}
	
}
