/**
 * 
 */
package pe.com.tintegro.sigs.dto.response;

import java.util.List;

import pe.com.tintegro.sigs.entidad.general.Item;

/**
 * @author daniel - 14 set. 2017
 *
 */
public class ObtieneTurnoResponse extends ResponseBase
{
	private List<Item> turno;

	public List<Item> getTurno() {
		return turno;
	}

	public void setTurno(List<Item> turno) {
		this.turno = turno;
	}


}
