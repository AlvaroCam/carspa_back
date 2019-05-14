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
public class ObtieneGradoInstruccionResponse extends ResponseBase
{
	private List<Item> gradoInstruccionList;

	public List<Item> getGradoInstruccionList() {
		return gradoInstruccionList;
	}

	public void setGradoInstruccionList(List<Item> gradoInstruccionList) {
		this.gradoInstruccionList = gradoInstruccionList;
	}
}
