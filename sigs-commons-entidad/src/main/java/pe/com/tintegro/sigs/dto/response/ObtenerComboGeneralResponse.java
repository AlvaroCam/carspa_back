package pe.com.tintegro.sigs.dto.response;

import java.util.List;

import pe.com.tintegro.sigs.entidad.ComboGeneral;

/**
 * @author Miguel - 12 ene. 2018
 *
 */
public class ObtenerComboGeneralResponse extends ResponseBase
{
	private List<ComboGeneral> lsComboGeneral;

	public List<ComboGeneral> getLsComboGeneral()
	{
		return lsComboGeneral;
	}

	public void setLsComboGeneral(List<ComboGeneral> lsComboGeneral)
	{
		this.lsComboGeneral = lsComboGeneral;
	}

}
