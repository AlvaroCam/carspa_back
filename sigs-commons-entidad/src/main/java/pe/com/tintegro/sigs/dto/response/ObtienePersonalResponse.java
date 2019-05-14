/**
 * 
 */
package pe.com.tintegro.sigs.dto.response;

import pe.com.tintegro.sigs.entidad.Personal;

/**
 * @author daniel - 18 set. 2017
 *
 */
public class ObtienePersonalResponse extends ResponseBase
{
	private Personal personal;

	public Personal getPersonal()
	{
		return personal;
	}

	public void setPersonal(Personal personal)
	{
		this.personal = personal;
	}
}
