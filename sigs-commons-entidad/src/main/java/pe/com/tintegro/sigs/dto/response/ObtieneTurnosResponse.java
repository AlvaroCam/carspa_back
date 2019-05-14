/**
 * 
 */
package pe.com.tintegro.sigs.dto.response;

import java.util.List;

import pe.com.tintegro.sigs.entidad.general.Item;

/**
 * @author daniel - 14 set. 2017
 *
 */
public class ObtieneTurnosResponse extends ResponseBase
{
	private List<Item> turnoList;

	public List<Item> getTurnoList()
	{
		return turnoList;
	}

	public void setTurnoList(List<Item> turnoList)
	{
		this.turnoList = turnoList;
	}
}
