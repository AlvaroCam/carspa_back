package pe.com.tintegro.sigs.dto.response;

import java.util.List;

import pe.com.tintegro.sigs.entidad.MedicamentoDispMedicoProdSanitario;

/**
 * @author Aldo Huamán
 *
 *         1 feb. 2018
 */
public class ObtieneMedicamentoDispositivoResponse extends ResponseBase
{
	private List<MedicamentoDispMedicoProdSanitario> medicamentoDispositivoList;

	public List<MedicamentoDispMedicoProdSanitario> getMedicamentoDispositivoList()
	{
		return medicamentoDispositivoList;
	}

	public void setMedicamentoDispositivoList(List<MedicamentoDispMedicoProdSanitario> medicamentoDispositivoList)
	{
		this.medicamentoDispositivoList = medicamentoDispositivoList;
	}

}
