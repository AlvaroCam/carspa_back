/**
 * 
 */
package pe.com.tintegro.sigs.dto.response;

import java.util.List;

import pe.com.tintegro.sigs.entidad.general.Item;

/**
 * @author FReyes
 *
 */
public class ObtieneParentescoResponse extends ResponseBase
{
	private List<Item> parentescoList;

	public List<Item> getParentescoList() {
		return parentescoList;
	}

	public void setParentescoList(List<Item> parentescoList) {
		this.parentescoList = parentescoList;
	}
}
