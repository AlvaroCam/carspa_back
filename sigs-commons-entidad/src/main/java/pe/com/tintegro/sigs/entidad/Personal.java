/**
 * 
 */
package pe.com.tintegro.sigs.entidad;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import pe.com.tintegro.sigs.entidad.general.Item;

/**
 * @author daniel - 18 set. 2017
 *
 */

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_NULL)
public class Personal implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8323003513846445681L;

	private String idPersonal;
	private String codigoPersonal;
	private String apePaterno;
	private String apeMaterno;
	private String nombre;
	private String feNacimiento;
	private Integer maxHorasNormales;
	private Integer maxHorasExtras;
	private Integer maxHorasExtrasDia;
	private String tipoStaff;
	private String email;
	private String ruc;
	private Integer cuposAdicionales;
	private String codigoUbigeo;
	private Item sexo;
	private Item estadoCivil;
	private Item tipoDocumentoIdentidad;
	private Item grupoOcupacional;

	public String getIdPersonal()
	{
		return idPersonal;
	}

	public void setIdPersonal(String idPersonal)
	{
		this.idPersonal = idPersonal;
	}

	public String getCodigoPersonal()
	{
		return codigoPersonal;
	}

	public void setCodigoPersonal(String codigoPersonal)
	{
		this.codigoPersonal = codigoPersonal;
	}

	public String getApePaterno()
	{
		return apePaterno;
	}

	public void setApePaterno(String apePaterno)
	{
		this.apePaterno = apePaterno;
	}

	public String getApeMaterno()
	{
		return apeMaterno;
	}

	public void setApeMaterno(String apeMaterno)
	{
		this.apeMaterno = apeMaterno;
	}

	public String getNombre()
	{
		return nombre;
	}

	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}

	public String getFeNacimiento()
	{
		return feNacimiento;
	}

	public void setFeNacimiento(String feNacimiento)
	{
		this.feNacimiento = feNacimiento;
	}
	
	public Integer getMaxHorasNormales()
	{
		return maxHorasNormales;
	}

	public void setMaxHorasNormales(Integer maxHorasNormales)
	{
		this.maxHorasNormales = maxHorasNormales;
	}

	public Integer getMaxHorasExtras()
	{
		return maxHorasExtras;
	}

	public void setMaxHorasExtras(Integer maxHorasExtras)
	{
		this.maxHorasExtras = maxHorasExtras;
	}

	public Integer getMaxHorasExtrasDia()
	{
		return maxHorasExtrasDia;
	}

	public void setMaxHorasExtrasDia(Integer maxHorasExtrasDia)
	{
		this.maxHorasExtrasDia = maxHorasExtrasDia;
	}

	public String getTipoStaff()
	{
		return tipoStaff;
	}

	public void setTipoStaff(String tipoStaff)
	{
		this.tipoStaff = tipoStaff;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getRuc()
	{
		return ruc;
	}

	public void setRuc(String ruc)
	{
		this.ruc = ruc;
	}

	public Integer getCuposAdicionales()
	{
		return cuposAdicionales;
	}

	public void setCuposAdicionales(Integer cuposAdicionales)
	{
		this.cuposAdicionales = cuposAdicionales;
	}
	
	public String getCodigoUbigeo()
	{
		return codigoUbigeo;
	}

	public void setCodigoUbigeo(String codigoUbigeo)
	{
		this.codigoUbigeo = codigoUbigeo;
	}

	public Item getSexo()
	{
		return sexo;
	}

	public void setSexo(Item sexo)
	{
		this.sexo = sexo;
	}

	public Item getEstadoCivil()
	{
		return estadoCivil;
	}

	public void setEstadoCivil(Item estadoCivil)
	{
		this.estadoCivil = estadoCivil;
	}

	public Item getTipoDocumentoIdentidad()
	{
		return tipoDocumentoIdentidad;
	}

	public void setTipoDocumentoIdentidad(Item tipoDocumentoIdentidad)
	{
		this.tipoDocumentoIdentidad = tipoDocumentoIdentidad;
	}

	public Item getGrupoOcupacional()
	{
		return grupoOcupacional;
	}

	public void setGrupoOcupacional(Item grupoOcupacional)
	{
		this.grupoOcupacional = grupoOcupacional;
	}
}
