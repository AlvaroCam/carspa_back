package pe.com.tintegro.sigs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.tintegro.sigs.constants.ResponseEstado;
import pe.com.tintegro.sigs.dao.AreaEspecialidadActividadGrupoOcupacionalDAO;
import pe.com.tintegro.sigs.dto.request.EliminarAreaEspecialidadActividadGrupoOcupacionalJRequest;
import pe.com.tintegro.sigs.dto.request.InsertarAreaEspecialidadActividadGrupoOcupacionalJRequest;
import pe.com.tintegro.sigs.dto.request.ObtenerAreaEspecialidadActividadGrupoOcupacionalJRequest;
import pe.com.tintegro.sigs.dto.response.EliminarAreaEspecialidadActividadGrupoOcupacionalJResponse;
import pe.com.tintegro.sigs.dto.response.InsertarAreaEspecialidadActividadGrupoOcupacionalJResponse;
import pe.com.tintegro.sigs.dto.response.ObtenerAreaEspecialidadActividadGrupoOcupacionalJResponse;
import pe.com.tintegro.sigs.entidad.AreaEspecialidadActividadGrupoOcupacional;
import pe.com.tintegro.sigs.entidad.general.Confirmacion;
import pe.com.tintegro.sigs.service.AreaEspecialidadActividadGrupoOcupacionalService;
import pe.com.tintegro.sigs.util.EncriptacionUtil;

@Service("areaEspecialidadActividadGrupoOcupacionalService")
public class AreaEspecialidadActividadGrupoOcupacionalServiceImpl implements AreaEspecialidadActividadGrupoOcupacionalService
{

	@Autowired
	private AreaEspecialidadActividadGrupoOcupacionalDAO areaEspecialidadActividadGrupoOcupacionalDAO;
	
	
	@Override
	public InsertarAreaEspecialidadActividadGrupoOcupacionalJResponse insertarAreaEspecialidadActividadGrupoOcupacionalJ(
			InsertarAreaEspecialidadActividadGrupoOcupacionalJRequest request)
			throws Exception {
		request.setIdIPRESS(EncriptacionUtil.desencriptar(request.getIdIPRESS()));
		InsertarAreaEspecialidadActividadGrupoOcupacionalJResponse response= areaEspecialidadActividadGrupoOcupacionalDAO.insertarAreaEspecialidadActividadGrupoOcupacionalJ(request);
		Confirmacion confirmacion = response.getConfirmacion();
		if(confirmacion.getId() == ResponseEstado.OK)
		{
			response.setMensaje("Se ingreso correctamente");
			response.setEstado(ResponseEstado.OK);
		}
		else 
		{
			response.setEstado(ResponseEstado.ERROR_NEGOCIO);
			response.setMensaje("No se pudo ingresar");
		}
		response.setConfirmacion(confirmacion);
		return response;
	}

	@Override
	public ObtenerAreaEspecialidadActividadGrupoOcupacionalJResponse obtenerAreaEspecialidadActividadGrupoOcupacionalJ(
			ObtenerAreaEspecialidadActividadGrupoOcupacionalJRequest request)
			throws Exception {
		request.setIdIPRESS(EncriptacionUtil.desencriptar(request.getIdIPRESS()));
		ObtenerAreaEspecialidadActividadGrupoOcupacionalJResponse response = new ObtenerAreaEspecialidadActividadGrupoOcupacionalJResponse();
		response = areaEspecialidadActividadGrupoOcupacionalDAO.obtenerAreaEspecialidadActividadGrupoOcupacionalJ(request);
		List<AreaEspecialidadActividadGrupoOcupacional> areaActEspGrList = response.getAreaEspecialidadActividadGrupoOcupacional();		
		if( areaActEspGrList == null && areaActEspGrList.size() == 0 )
		{
			response.setEstado( ResponseEstado.ERROR_NEGOCIO );
			response.setMensaje( "GrupoOcupacional no encontrada." );
		}
		else
		{
			response.setEstado( ResponseEstado.OK );
			response.setMensaje( "GrupoOcupacional obtenida correctamente." );
		}
		return response;
	}

	@Override
	public EliminarAreaEspecialidadActividadGrupoOcupacionalJResponse eliminarAreaEspecialidadActividadaGrupoOcupacionalJ(
			EliminarAreaEspecialidadActividadGrupoOcupacionalJRequest request)
			throws Exception {

		request.setIdIPRESS(EncriptacionUtil.desencriptar(request.getIdIPRESS()));
		EliminarAreaEspecialidadActividadGrupoOcupacionalJResponse response= areaEspecialidadActividadGrupoOcupacionalDAO.eliminarAreaEspecialidadActividadGrupoOcupacionalJ(request);
		Confirmacion confirmacion = response.getConfirmacion();
		if(response.getConfirmacion() == null)
		{
			response.setEstado(ResponseEstado.ERROR_NEGOCIO);
			response.setMensaje("No se ha eliminado correctamente");
		}
		else 
		{
			response.setMensaje("Se elimino correctamente");
			response.setEstado(ResponseEstado.OK);
		}
		response.setConfirmacion(confirmacion);
		
		return response;
	}

}
