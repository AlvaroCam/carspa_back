package pe.com.tintegro.sigs.entidad;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * @author Miguel Mascco
 *
 *         12 ene. 2018
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_NULL)
public class ComboGeneral implements Serializable
{
	private static final long serialVersionUID = 1L;
	private Integer idGrupoOpcion;
	private String valorGrupoOpcion;
	private List<OpcionValorCombo> lsOpcionValorCombo;
	private Integer idTipoDocumento;
	private String descripcionTipoDocumento;
	private String codigoIeds;
	
	public String getCodigoIeds() {
		return codigoIeds;
	}

	public void setCodigoIeds(String codigoIeds) {
		this.codigoIeds = codigoIeds;
	}

	public Integer getIdTipoDocumento() {
		return idTipoDocumento;
	}

	public void setIdTipoDocumento(Integer idTipoDocumento) {
		this.idTipoDocumento = idTipoDocumento;
	}

	public String getDescripcionTipoDocumento() {
		return descripcionTipoDocumento;
	}

	public void setDescripcionTipoDocumento(String descripcionTipoDocumento) {
		this.descripcionTipoDocumento = descripcionTipoDocumento;
	}

	public Integer getIdGrupoOpcion()
	{
		return idGrupoOpcion;
	}

	public void setIdGrupoOpcion(Integer idGrupoOpcion)
	{
		this.idGrupoOpcion = idGrupoOpcion;
	}

	public String getValorGrupoOpcion()
	{
		return valorGrupoOpcion;
	}

	public void setValorGrupoOpcion(String valorGrupoOpcion)
	{
		this.valorGrupoOpcion = valorGrupoOpcion;
	}

	public List<OpcionValorCombo> getLsOpcionValorCombo()
	{
		return lsOpcionValorCombo;
	}

	public void setLsOpcionValorCombo(List<OpcionValorCombo> lsOpcionValorCombo)
	{
		this.lsOpcionValorCombo = lsOpcionValorCombo;
	}

}
