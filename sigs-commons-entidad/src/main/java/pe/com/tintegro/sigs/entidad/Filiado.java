package pe.com.tintegro.sigs.entidad;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import pe.com.tintegro.sigs.entidad.general.Item;

/**
 * @author Aldo Huamán
 *
 * 27 dic. 2017
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_NULL)
public class Filiado implements Serializable
{
	
	@Override
	public String toString()
	{
		return "Filiado [domicilioActual=" + domicilioActual + ", tipoPaciente=" + tipoPaciente + ", telefonoFijo="
				+ telefonoFijo + ", telefonoMovil=" + telefonoMovil + ", parentescoAcompañante=" + parentescoAcompanante
				+ ", ubigeo=" + ubigeo + ", ipress=" + ipress + "]";
	}

	private static final long serialVersionUID = 1L;
	private String domicilioActual;
	private String tipoPaciente;
	private String telefonoFijo;
	private String telefonoMovil;
	private Item parentescoAcompanante;
	private Ubigeo ubigeo;
	private Ipress ipress;
	
	public String getDomicilioActual()
	{
		return domicilioActual;
	}

	public void setDomicilioActual(String domicilioActual)
	{
		this.domicilioActual = domicilioActual;
	}

	public Ubigeo getUbigeo()
	{
		return ubigeo;
	}

	public void setUbigeo(Ubigeo ubigeo)
	{
		this.ubigeo = ubigeo;
	}

	public String getTelefonoFijo()
	{
		return telefonoFijo;
	}

	public void setTelefonoFijo(String telefonoFijo)
	{
		this.telefonoFijo = telefonoFijo;
	}

	public String getTelefonoMovil()
	{
		return telefonoMovil;
	}

	public void setTelefonoMovil(String telefonoMovil)
	{
		this.telefonoMovil = telefonoMovil;
	}

	public Item getParentescoAcompanante()
	{
		return parentescoAcompanante;
	}

	public void setParentescoAcompanante(Item parentescoAcompanante)
	{
		this.parentescoAcompanante = parentescoAcompanante;
	}

	public String getTipoPaciente()
	{
		return tipoPaciente;
	}

	public void setTipoPaciente(String tipoPaciente)
	{
		this.tipoPaciente = tipoPaciente;
	}

	public Ipress getIpress()
	{
		return ipress;
	}

	public void setIpress(Ipress ipress)
	{
		this.ipress = ipress;
	}

}
