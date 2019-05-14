/**
 * 
 */
package pe.com.tintegro.sigs.dto.response;

import java.util.List;

import pe.com.tintegro.sigs.entidad.general.Item;

/**
 * @author daniel - 11 set. 2017
 *
 */
public class ObtieneEspecialidadesResponse extends ResponseBase
{
	private List<Item> especialidadList;

	public List<Item> getEspecialidadList()
	{
		return especialidadList;
	}

	public void setEspecialidadList(List<Item> especialidadList)
	{
		this.especialidadList = especialidadList;
	}
}
