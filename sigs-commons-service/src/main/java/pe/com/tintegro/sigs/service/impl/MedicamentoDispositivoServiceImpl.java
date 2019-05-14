package pe.com.tintegro.sigs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.tintegro.sigs.constants.ResponseEstado;
import pe.com.tintegro.sigs.dao.MedicamentoDispositivoDAO;
import pe.com.tintegro.sigs.dto.request.ObtieneMedicamentoDispositivoRequest;
import pe.com.tintegro.sigs.dto.response.ObtieneMedicamentoDispositivoResponse;
import pe.com.tintegro.sigs.service.MedicamentoDispositivoService;
import pe.com.tintegro.sigs.util.EncriptacionUtil;

/**
 * @author Aldo Huamán
 *
 * 12 ene. 2018
 */
@Service("medicamentoDispositivoService")
public class MedicamentoDispositivoServiceImpl implements MedicamentoDispositivoService
{
	@Autowired
	private MedicamentoDispositivoDAO medicamentoDispositivoDAO;
	
	@Override
	public ObtieneMedicamentoDispositivoResponse obtenerMedicamentoDispMedicoProdSanitario(
			ObtieneMedicamentoDispositivoRequest request) throws Exception
	{
		request.setIdIPRESS(EncriptacionUtil.desencriptar(request.getIdIPRESS()));
		ObtieneMedicamentoDispositivoResponse response = medicamentoDispositivoDAO.obtenerMedicamentoDispMedicoProdSanitario(request);
		if(response.getMedicamentoDispositivoList() == null)
		{
			response.setEstado(ResponseEstado.ERROR_NEGOCIO);
			response.setMensaje("No se encontraron medicamentos con los parametros ingresados");
		}
		else 
		{
			response.setMensaje("Medicamentos obtenidos correctamente");
			response.setEstado(ResponseEstado.OK);
		}
		return response;
	}	
}
