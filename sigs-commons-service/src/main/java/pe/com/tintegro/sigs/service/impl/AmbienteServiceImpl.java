/**
 * 
 */
package pe.com.tintegro.sigs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.tintegro.sigs.constants.ResponseEstado;
import pe.com.tintegro.sigs.dao.AmbienteDAO;
import pe.com.tintegro.sigs.dto.request.ActualizarAmbienteRequest;
import pe.com.tintegro.sigs.dto.request.EliminarAmbienteRequest;
import pe.com.tintegro.sigs.dto.request.InsertarAmbienteRequest;
import pe.com.tintegro.sigs.dto.request.ObtieneActividadAmbienteRequest;
import pe.com.tintegro.sigs.dto.request.ObtieneAmbienteEspecialidadRequest;
import pe.com.tintegro.sigs.dto.request.ObtieneAmbienteRequest;
import pe.com.tintegro.sigs.dto.request.ObtieneAmbientesRequest;
import pe.com.tintegro.sigs.dto.response.ActualizarAmbienteResponse;
import pe.com.tintegro.sigs.dto.response.EliminarAmbienteResponse;
import pe.com.tintegro.sigs.dto.response.InsertarAmbienteResponse;
import pe.com.tintegro.sigs.dto.response.ObtieneActividadAmbienteResponse;
import pe.com.tintegro.sigs.dto.response.ObtieneActoMedicoPorCitaResponse;
import pe.com.tintegro.sigs.dto.response.ObtieneAmbienteEspecialidadResponse;
import pe.com.tintegro.sigs.dto.response.ObtieneAmbienteResponse;
import pe.com.tintegro.sigs.dto.response.ObtieneAmbientesResponse;
import pe.com.tintegro.sigs.entidad.general.Confirmacion;
import pe.com.tintegro.sigs.service.AmbienteService;
import pe.com.tintegro.sigs.util.EncriptacionUtil;

/**
 * @author daniel - 15 set. 2017
 *
 */
@Service( "ambienteService" )
public class AmbienteServiceImpl implements AmbienteService
{
	@Autowired
	private AmbienteDAO ambienteDAO;
	
	@Override
	public ObtieneAmbientesResponse obtenerAmbientes(ObtieneAmbientesRequest request) throws Exception
	{
		request.setIdIPRESS( EncriptacionUtil.desencriptar( request.getIdIPRESS() ) );
		return ambienteDAO.obtenerAmbientes(request);
	}

	@Override
	public ObtieneAmbienteResponse obtenerAmbiente(ObtieneAmbienteRequest request) throws Exception
	{
//		ObtieneAmbienteResponse response = new ObtieneAmbienteResponse();
//		
//		request.setIdIPRESS( EncriptacionUtil.desencriptar( request.getIdIPRESS() ) );
//		
//		List<Item> ambienteList = ambienteDAO.obtenerAmbientes( request.getIdIPRESS(), request.getIdAmbiente() );
//		Item ambiente = ambienteList.isEmpty() ? null : ambienteList.get( 0 );
//		
//		if( ambiente != null )
//		{
//			response.setEstado( ResponseEstado.OK );
//			response.setMensaje( "Ambiente obtenido correctamente." );
//		}
//		else
//		{
//			response.setEstado( ResponseEstado.ERROR_NEGOCIO );
//			response.setMensaje( "Ambiente no encontrado." );
//		}
//		
//		response.setAmbiente( ambiente ); 
//		
		return null;
	}

	@Override
	public ObtieneAmbienteEspecialidadResponse obtenerAmbienteEspecialidad(
			ObtieneAmbienteEspecialidadRequest request) throws Exception {
		ObtieneAmbienteEspecialidadResponse response = new ObtieneAmbienteEspecialidadResponse();
		response = ambienteDAO.obtenerAmbienteEspecialidad(request);
		if (response.getAmbienteList() == null)
		{
			response.setEstado(ResponseEstado.ERROR_NEGOCIO);
			response.setMensaje("No se encontró ambientes");
		} else
		{
			response.setEstado(ResponseEstado.OK);
			response.setMensaje("Se obtuvo los ambientes correctamente");
		}
		return response;
	}

	@Override
	public InsertarAmbienteResponse insertaAmbiente(
			InsertarAmbienteRequest request) throws Exception {
		request.setIdIPRESS( EncriptacionUtil.desencriptar( request.getIdIPRESS() ) );
		InsertarAmbienteResponse response = ambienteDAO.insertaAmbiente(request);
		if (response.getConfirmacion() != null) {
			if (response.getConfirmacion().getId() == ResponseEstado.ERROR_NEGOCIO) {
				response.setEstado(ResponseEstado.ERROR_NEGOCIO);
				response.setMensaje(response.getConfirmacion().getMensaje());
			} else if (response.getConfirmacion().getId() > 0) {
				response.setEstado(ResponseEstado.OK);
				response.setMensaje("Ambiente Insertado correctamente.");
			}
		}
		return response;
	}

	@Override
	public ObtieneActividadAmbienteResponse obtenerActividadAmbiente(
			ObtieneActividadAmbienteRequest request) throws Exception {
		request.setIdIPRESS( EncriptacionUtil.desencriptar( request.getIdIPRESS() ) );
		ObtieneActividadAmbienteResponse response = new ObtieneActividadAmbienteResponse();
		response = ambienteDAO.obtenerActividadAmbiente(request);
		if (response.getAmbienteList() == null)
		{
			response.setEstado(ResponseEstado.ERROR_NEGOCIO);
			response.setMensaje("No se encontró actividad");
		} else
		{
			response.setEstado(ResponseEstado.OK);
			response.setMensaje("Se obtuvo las actividades correctamente");
		}
		return response;
	}

	@Override
	public EliminarAmbienteResponse eliminaAmbiente(
			EliminarAmbienteRequest request) throws Exception {
		EliminarAmbienteResponse response = ambienteDAO.eliminaAmbiente(request);
		if (response.getConfirmacion() != null) {
			if (response.getConfirmacion().getId() == ResponseEstado.ERROR_NEGOCIO) {
				response.setEstado(ResponseEstado.ERROR_NEGOCIO);
				response.setMensaje(response.getConfirmacion().getMensaje());
			} else if (response.getConfirmacion().getId() > 0) {
				response.setEstado(ResponseEstado.OK);
				response.setMensaje("Ambiente Eliminado correctamente.");
			}
		}
		return response;
	}

	@Override
	public ActualizarAmbienteResponse actualizarAmbiente(
			ActualizarAmbienteRequest request) throws Exception {
		request.setIdIPRESS( EncriptacionUtil.desencriptar( request.getIdIPRESS() ) );
		ActualizarAmbienteResponse response = ambienteDAO.actualizarAmbiente(request);
		if (response.getConfirmacion() != null) {
			if (response.getConfirmacion().getId() == ResponseEstado.ERROR_NEGOCIO) {
				response.setEstado(ResponseEstado.ERROR_NEGOCIO);
				response.setMensaje(response.getConfirmacion().getMensaje());
			} else if (response.getConfirmacion().getId() > 0) {
				response.setEstado(ResponseEstado.OK);
				response.setMensaje("Ambiente actualizado correctamente.");
			}
		}
		return response;
	}
}
