/**
 * 
 */
package pe.com.tintegro.sigs.dto.response;

import java.util.List;

import pe.com.tintegro.sigs.entidad.general.Item;

/**
 * @author Carlos
 *
 */
public class ObtieneEstadoCivilResponse extends ResponseBase
{
	private List<Item> estadoCivilList;

	public List<Item> getEstadoCivilList()
	{
		return estadoCivilList;
	}

	public void setEstadoCivilList(List<Item> estadoCivilList)
	{
		this.estadoCivilList = estadoCivilList;
	}

}
