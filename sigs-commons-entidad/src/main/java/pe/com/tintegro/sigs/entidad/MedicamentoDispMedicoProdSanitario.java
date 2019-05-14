package pe.com.tintegro.sigs.entidad;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


/**
 * @author Aldo Huamán
 *
 * 1 feb. 2018
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_NULL)
public class MedicamentoDispMedicoProdSanitario implements Serializable
{

	@Override
	public String toString()
	{
		return "MedicamentoDispMedicoProdSanitario [idMedicamento=" + idMedicamento + ", dispositivoMedicamento="
				+ dispositivoMedicamento + ", marca=" + marca + ", laboratorio=" + laboratorio + ", codigo=" + codigo
				+ ", formaFarmaceutica=" + formaFarmaceutica + ", concentracion=" + concentracion + ", nombreComercial="
				+ nombreComercial + ", fiTipo=" + fiTipo + ", anaquel=" + anaquel + "]";
	}

	private static final long serialVersionUID = 1L;
	private int idMedicamento;
	private String dispositivoMedicamento;
	private String marca;
	private String laboratorio;
	private String codigo;
	private String formaFarmaceutica;
	private String concentracion;
	private String nombreComercial;
	private String fiTipo;
	private String anaquel;

	public String getAnaquel()
	{
		return anaquel;
	}

	public void setAnaquel(String anaquel)
	{
		this.anaquel = anaquel;
	}

	public String getFiTipo()
	{
		return fiTipo;
	}

	public void setFiTipo(String fiTipo)
	{
		this.fiTipo = fiTipo;
	}

	public String getDispositivoMedicamento()
	{
		return dispositivoMedicamento;
	}

	public void setDispositivoMedicamento(String dispositivoMedicamento)
	{
		this.dispositivoMedicamento = dispositivoMedicamento;
	}

	public String getConcentracion()
	{
		return concentracion;
	}

	public void setConcentracion(String concentracion)
	{
		this.concentracion = concentracion;
	}

	public String getNombreComercial()
	{
		return nombreComercial;
	}

	public void setNombreComercial(String nombreComercial)
	{
		this.nombreComercial = nombreComercial;
	}

	public String getMarca()
	{
		return marca;
	}

	public void setMarca(String marca)
	{
		this.marca = marca;
	}

	public String getLaboratorio()
	{
		return laboratorio;
	}

	public void setLaboratorio(String laboratorio)
	{
		this.laboratorio = laboratorio;
	}

	public String getFormaFarmaceutica()
	{
		return formaFarmaceutica;
	}

	public void setFormaFarmaceutica(String formaFarmaceutica)
	{
		this.formaFarmaceutica = formaFarmaceutica;
	}

	public int getIdMedicamento()
	{
		return idMedicamento;
	}

	public void setIdMedicamento(int idMedicamento)
	{
		this.idMedicamento = idMedicamento;
	}

	public String getCodigo()
	{
		return codigo;
	}

	public void setCodigo(String codigo)
	{
		this.codigo = codigo;
	}

}
