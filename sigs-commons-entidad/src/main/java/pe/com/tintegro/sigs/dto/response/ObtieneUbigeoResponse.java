/**
 * 
 */
package pe.com.tintegro.sigs.dto.response;

import java.util.List;

import pe.com.tintegro.sigs.entidad.Ubigeo;
/**
 * @author Carlos
 *
 */
public class ObtieneUbigeoResponse extends ResponseBase
{
	private List<Ubigeo> ubigeoList;

	public List<Ubigeo> getUbigeoList()
	{
		return ubigeoList;
	}

	public void setUbigeoList(List<Ubigeo> ubigeoList)
	{
		this.ubigeoList = ubigeoList;
	}

}
