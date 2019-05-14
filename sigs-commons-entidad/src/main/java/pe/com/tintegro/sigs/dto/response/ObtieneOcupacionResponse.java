/**
 * 
 */
package pe.com.tintegro.sigs.dto.response;

import pe.com.tintegro.sigs.entidad.general.Item;

import java.util.List;

/**
 * @author FReyes
 *
 */
public class ObtieneOcupacionResponse extends ResponseBase
{
	private List<Item> ocupacionList;

	public List<Item> getOcupacionList() {
		return ocupacionList;
	}

	public void setOcupacionList(List<Item> ocupacionList) {
		this.ocupacionList = ocupacionList;
	}
	
}

