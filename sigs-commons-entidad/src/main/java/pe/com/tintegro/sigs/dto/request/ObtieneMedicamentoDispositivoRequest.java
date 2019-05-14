package pe.com.tintegro.sigs.dto.request;

/**
 * @author Aldo Huamán
 *
 *         1 feb. 2018
 */
public class ObtieneMedicamentoDispositivoRequest extends RequestBase
{
	private int idAlmacen;
	private Integer idMedicamento;
	private String anaquel;
	private String fiTipo;

	public int getIdAlmacen()
	{
		return idAlmacen;
	}

	public void setIdAlmacen(int idAlmacen)
	{
		this.idAlmacen = idAlmacen;
	}

	public Integer getIdMedicamento()
	{
		return idMedicamento;
	}

	public void setIdMedicamento(Integer idMedicamento)
	{
		this.idMedicamento = idMedicamento;
	}

	public String getAnaquel()
	{
		return anaquel;
	}

	public void setAnaquel(String anaquel)
	{
		this.anaquel = anaquel;
	}

	public String getFiTipo()
	{
		return fiTipo;
	}

	public void setFiTipo(String fiTipo)
	{
		this.fiTipo = fiTipo;
	}

}
