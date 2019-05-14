package pe.com.tintegro.sigs.entidad;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import pe.com.tintegro.sigs.entidad.general.Item;

/**
 * @author Aldo Huamán
 *
 *         22 dic. 2017
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_NULL)
public class Persona implements Serializable
{
	

	@Override
	public String toString() {
		return "Persona [idPersona=" + idPersona + ", nombres=" + nombres
				+ ", apellidoPaterno=" + apellidoPaterno + ", apellidoMaterno="
				+ apellidoMaterno + ", edad=" + edad
				+ ", numeroDocumentoIdentidad=" + numeroDocumentoIdentidad
				+ ", edadLetra=" + edadLetra + ", feNacimiento=" + feNacimiento
				+ ", sexo=" + sexo + ", tipoSangre=" + tipoSangre
				+ ", gradoInstruccion=" + gradoInstruccion + ", estadoCivil="
				+ estadoCivil + ", ocupacion=" + ocupacion
				+ ", tipoDocumentoIdentidad=" + tipoDocumentoIdentidad
				+ ", filiadoList=" + filiadoList + ", historiaList="
				+ historiaList + ", planList=" + planList
				+ ", distritoNacimiento=" + distritoNacimiento
				+ ", idTipoDocumentoAcompanante=" + idTipoDocumentoAcompanante
				+ ", nombreAcompanante=" + nombreAcompanante
				+ ", diAcompanante=" + diAcompanante + ", edadAcompanante="
				+ edadAcompanante + ", idGrupoEtareo=" + idGrupoEtareo
				+ ", descripcionGrupoEtareo=" + descripcionGrupoEtareo
				+ ", cobertura=" + cobertura + "]";
	}

	private static final long serialVersionUID = 1L;
	private String idPersona;
	private String nombres;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private Integer edad;
	private String numeroDocumentoIdentidad;
	private String edadLetra;
	private String feNacimiento;
	private Item sexo;
	private Item tipoSangre;
	private Item gradoInstruccion;
	private Item estadoCivil;
	private Item ocupacion;
	private TipoDocumento tipoDocumentoIdentidad;
	private List<Filiado> filiadoList;
	private List<Historia> historiaList;
	private List<Plan> planList;
	private String distritoNacimiento;
	private Integer idTipoDocumentoAcompanante;
	private String nombreAcompanante;
	private String diAcompanante;
	private String edadAcompanante;
	private Integer idGrupoEtareo;
	private String descripcionGrupoEtareo;
	private Cobertura cobertura;
	
	
	public Integer getIdTipoDocumentoAcompanante() {
		return idTipoDocumentoAcompanante;
	}

	public void setIdTipoDocumentoAcompanante(Integer idTipoDocumentoAcompanante) {
		this.idTipoDocumentoAcompanante = idTipoDocumentoAcompanante;
	}

	public Cobertura getCobertura()
	{
		return cobertura;
	}

	public void setCobertura(Cobertura cobertura)
	{
		this.cobertura = cobertura;
	}

	public String getFeNacimiento()
	{
		return feNacimiento;
	}

	public void setFeNacimiento(String feNacimiento)
	{
		this.feNacimiento = feNacimiento;
	}

	public Item getTipoSangre()
	{
		return tipoSangre;
	}

	public void setTipoSangre(Item tipoSangre)
	{
		this.tipoSangre = tipoSangre;
	}

	public Item getGradoInstruccion()
	{
		return gradoInstruccion;
	}

	public void setGradoInstruccion(Item gradoInstruccion)
	{
		this.gradoInstruccion = gradoInstruccion;
	}

	public Item getEstadoCivil()
	{
		return estadoCivil;
	}

	public void setEstadoCivil(Item estadoCivil)
	{
		this.estadoCivil = estadoCivil;
	}

	public Item getOcupacion()
	{
		return ocupacion;
	}

	public void setOcupacion(Item ocupacion)
	{
		this.ocupacion = ocupacion;
	}

	public String getEdadLetra()
	{
		return edadLetra;
	}

	public void setEdadLetra(String edadLetra)
	{
		this.edadLetra = edadLetra;
	}

	public String getIdPersona()
	{
		return idPersona;
	}

	public void setIdPersona(String idPersona)
	{
		this.idPersona = idPersona;
	}

	public String getNombres()
	{
		return nombres;
	}

	public void setNombres(String nombres)
	{
		this.nombres = nombres;
	}

	public String getApellidoPaterno()
	{
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno)
	{
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno()
	{
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno)
	{
		this.apellidoMaterno = apellidoMaterno;
	}

	public Integer getEdad()
	{
		return edad;
	}

	public void setEdad(Integer edad)
	{
		this.edad = edad;
	}

	public Item getSexo()
	{
		return sexo;
	}

	public void setSexo(Item sexo)
	{
		this.sexo = sexo;
	}

	public String getNumeroDocumentoIdentidad()
	{
		return numeroDocumentoIdentidad;
	}

	public void setNumeroDocumentoIdentidad(String numeroDocumentoIdentidad)
	{
		this.numeroDocumentoIdentidad = numeroDocumentoIdentidad;
	}

	public TipoDocumento getTipoDocumentoIdentidad()
	{
		return tipoDocumentoIdentidad;
	}

	public void setTipoDocumentoIdentidad(TipoDocumento tipoDocumentoIdentidad)
	{
		this.tipoDocumentoIdentidad = tipoDocumentoIdentidad;
	}

	public List<Filiado> getFiliadoList()
	{
		return filiadoList;
	}

	public void setFiliadoList(List<Filiado> filiadoList)
	{
		this.filiadoList = filiadoList;
	}

	public List<Historia> getHistoriaList()
	{
		return historiaList;
	}

	public void setHistoriaList(List<Historia> historiaList)
	{
		this.historiaList = historiaList;
	}

	public List<Plan> getPlanList()
	{
		return planList;
	}

	public void setPlanList(List<Plan> planList)
	{
		this.planList = planList;
	}

	public String getDistritoNacimiento()
	{
		return distritoNacimiento;
	}

	public void setDistritoNacimiento(String distritoNacimiento)
	{
		this.distritoNacimiento = distritoNacimiento;
	}

	public String getNombreAcompanante()
	{
		return nombreAcompanante;
	}

	public void setNombreAcompanante(String nombreAcompanante)
	{
		this.nombreAcompanante = nombreAcompanante;
	}

	public String getDiAcompanante()
	{
		return diAcompanante;
	}

	public void setDiAcompanante(String diAcompanante)
	{
		this.diAcompanante = diAcompanante;
	}

	public String getEdadAcompanante()
	{
		return edadAcompanante;
	}

	public void setEdadAcompanante(String edadAcompanante)
	{
		this.edadAcompanante = edadAcompanante;
	}

	public Integer getIdGrupoEtareo()
	{
		return idGrupoEtareo;
	}

	public void setIdGrupoEtareo(Integer idGrupoEtareo)
	{
		this.idGrupoEtareo = idGrupoEtareo;
	}

	public String getDescripcionGrupoEtareo()
	{
		return descripcionGrupoEtareo;
	}

	public void setDescripcionGrupoEtareo(String descripcionGrupoEtareo)
	{
		this.descripcionGrupoEtareo = descripcionGrupoEtareo;
	}

}
