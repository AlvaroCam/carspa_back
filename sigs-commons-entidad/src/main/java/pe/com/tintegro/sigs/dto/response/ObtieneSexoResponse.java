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
public class ObtieneSexoResponse extends ResponseBase
{
	private List<Item> sexoList;

	public List<Item> getSexoList()
	{
		return sexoList;
	}

	public void setSexoList(List<Item> sexoList)
	{
		this.sexoList = sexoList;
	}

}
