package pe.com.tintegro.sigs.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.com.tintegro.sigs.dao.MedicamentoDispositivoDAO;
import pe.com.tintegro.sigs.dto.request.ObtieneMedicamentoDispositivoRequest;
import pe.com.tintegro.sigs.dto.response.ObtieneMedicamentoDispositivoResponse;
import pe.com.tintegro.sigs.entidad.MedicamentoDispMedicoProdSanitario;
import pe.com.tintegro.sigs.mapper.MedicamentoDispositivoMapper;

/**
 * @author Aldo Huamán
 *
 *         1 feb. 2018
 */
@Transactional
@Repository("medicamentoDispositivoDAO")
public class MedicamentoDispositivoDAOImpl implements MedicamentoDispositivoDAO
{
	@Autowired
	private MedicamentoDispositivoMapper medicamentoDispositivoMapper;

	@Override
	public ObtieneMedicamentoDispositivoResponse obtenerMedicamentoDispMedicoProdSanitario(
			ObtieneMedicamentoDispositivoRequest request) throws Exception
	{
		ObtieneMedicamentoDispositivoResponse response = new ObtieneMedicamentoDispositivoResponse();
		List<MedicamentoDispMedicoProdSanitario> medicamentoDispositivoList = medicamentoDispositivoMapper
				.obtenerMedicamentoDispMedicoProdSanitario(request.getIdAlmacen(), request.getIdIPRESS());
		response.setMedicamentoDispositivoList(medicamentoDispositivoList);
		return response;
	}
}
