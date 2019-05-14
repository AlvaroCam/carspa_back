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
public class ObtieneAmbientesResponse extends ResponseBase
{
	private List<Item> ambienteList;

	public List<Item> getAmbienteList()
	{
		return ambienteList;
	}

	public void setAmbienteList(List<Item> ambienteList)
	{
		this.ambienteList = ambienteList;
	}
}
