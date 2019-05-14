package pe.com.tintegro.sigs.dto.request;

/**
 * @author Miguel Mascco
 *
 */
public class ObtieneFechaRequest extends RequestBase
{
	private int inferiorFecha;

	public int getInferiorFecha()
	{
		return inferiorFecha;
	}

	public void setInferiorFecha(int inferiorFecha)
	{
		this.inferiorFecha = inferiorFecha;
	}
	
}
