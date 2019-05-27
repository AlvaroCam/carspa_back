package pe.com.tintegro.sigs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.tintegro.sigs.constants.ResponseEstado;
import pe.com.tintegro.sigs.dao.AlmacenOrdenCompraDAO;
import pe.com.tintegro.sigs.dao.AnaquelDAO;
import pe.com.tintegro.sigs.dto.request.ActualizarAnaquelRequest;
import pe.com.tintegro.sigs.dto.response.ActualizarAnaquelResponse;
import pe.com.tintegro.sigs.dto.response.ActualizarCantidadFisicaResponse;
import pe.com.tintegro.sigs.entidad.general.Confirmacion;
import pe.com.tintegro.sigs.service.AnaquelService;

@Service("anaquelService")
public class AnaquelServiceImpl implements AnaquelService {

	@Autowired
	private AnaquelDAO anaquelDAO;

	@Override
	public ActualizarAnaquelResponse actualizarAnaquel(ActualizarAnaquelRequest request) throws Exception {

		ActualizarAnaquelResponse response = anaquelDAO.actualizarAnaquel(request);

		Confirmacion confirmacion = response.getConfirmacion();

		if (confirmacion.getId() == ResponseEstado.OK) {
			response.setEstado(ResponseEstado.OK);
			response.setMensaje("Cantidad Física actualizada correctamente.");
		} else {
			response.setEstado(ResponseEstado.ERROR_NEGOCIO);
			response.setMensaje("No se ingreso la cantidad física");
		}
		return response;
	}

}
