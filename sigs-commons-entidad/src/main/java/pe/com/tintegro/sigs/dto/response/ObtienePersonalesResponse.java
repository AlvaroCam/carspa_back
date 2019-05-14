/**
 * 
 */
package pe.com.tintegro.sigs.dto.response;

import java.util.List;

import pe.com.tintegro.sigs.entidad.Personal;

/**
 * @author daniel - 18 set. 2017
 *
 */
public class ObtienePersonalesResponse extends ResponseBase
{
	private List<Personal> personalList;

	public List<Personal> getPersonalList()
	{
		return personalList;
	}

	public void setPersonalList(List<Personal> personalList)
	{
		this.personalList = personalList;
	}
}
