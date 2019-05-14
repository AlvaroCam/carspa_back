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
public class ObtieneGrupoOcupacionalResponse extends ResponseBase
{
	private List<Item> grupoOcupacionalList;

	public List<Item> getGrupoOcupacionalList()
	{
		return grupoOcupacionalList;
	}

	public void setGrupoOcupacionalList(List<Item> grupoOcupacionalList)
	{
		this.grupoOcupacionalList = grupoOcupacionalList;
	}

}
