package pe.com.tintegro.sigs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.tintegro.sigs.constants.ResponseEstado;
import pe.com.tintegro.sigs.dao.AreaDAO;
import pe.com.tintegro.sigs.dto.request.EliminarAreaRequest;
import pe.com.tintegro.sigs.dto.request.InsertarAreaRequest;
import pe.com.tintegro.sigs.dto.request.ObtenerAreaRequest;
import pe.com.tintegro.sigs.dto.request.ObtieneAreaConsultaAmbulatoriaRequest;
import pe.com.tintegro.sigs.dto.request.ObtieneAreaRequest;
import pe.com.tintegro.sigs.dto.request.ObtieneAreasRequest;
import pe.com.tintegro.sigs.dto.request.ObtieneAreasSinAlmacenRequest;
import pe.com.tintegro.sigs.dto.response.EliminarAreaResponse;
import pe.com.tintegro.sigs.dto.response.InsertarAreaResponse;
import pe.com.tintegro.sigs.dto.response.ObtenerAreaResponse;
import pe.com.tintegro.sigs.dto.response.ObtieneAreaConsultaAmbulatoriaResponse;
import pe.com.tintegro.sigs.dto.response.ObtieneAreaResponse;
import pe.com.tintegro.sigs.dto.response.ObtieneAreasResponse;
import pe.com.tintegro.sigs.dto.response.ObtieneAreasSinAlmacenResponse;
import pe.com.tintegro.sigs.entidad.Area;
import pe.com.tintegro.sigs.entidad.general.Confirmacion;
import pe.com.tintegro.sigs.entidad.general.Item;
import pe.com.tintegro.sigs.service.AreaService;
import pe.com.tintegro.sigs.util.EncriptacionUtil;

@Service( "areaService" )
public class AreaServiceImpl implements AreaService
{
	@Autowired
	private AreaDAO areaDAO;
	
	@Override
	public ObtieneAreaResponse obtenerArea(ObtieneAreaRequest request) throws Exception
	{
		ObtieneAreaResponse response = new ObtieneAreaResponse();
		
		request.setIdIPRESS( EncriptacionUtil.desencriptar( request.getIdIPRESS() ) );
		
		List<Item> areasList = areaDAO.obtenerAreas( request.getIdIPRESS(), request.getIdArea(), request.getCodUsuario());
		
		Item area = areasList.isEmpty() ? null : areasList.get( 0 );
		
		if( area == null )
		{
			response.setEstado( ResponseEstado.ERROR_NEGOCIO );
			response.setMensaje( "Área no encontrada." );
		}
		else
		{
			response.setEstado( ResponseEstado.OK );
			response.setMensaje( "Área obtenida correctamente." );
		}
		
		response.setArea( area );
		
		return response;
	}
	
	@Override
	public ObtieneAreasResponse obtenerAreas(ObtieneAreasRequest request) throws Exception
	{
		ObtieneAreasResponse response = new ObtieneAreasResponse();
		
		request.setIdIPRESS( EncriptacionUtil.desencriptar( request.getIdIPRESS() ) );
		
		List<Item> areaList = areaDAO.obtenerAreas( request.getIdIPRESS(), null, request.getCodUsuario() );
		response.setAreaList( areaList );
		
		return response;
	}

	@Override
	public ObtieneAreasSinAlmacenResponse obtenerAreasSinAlmacen(ObtieneAreasSinAlmacenRequest request) throws Exception
	{
		request.setIdIPRESS( EncriptacionUtil.desencriptar( request.getIdIPRESS() ) );
		ObtieneAreasSinAlmacenResponse response = new ObtieneAreasSinAlmacenResponse();
		response = areaDAO.obtenerAreasSinAlmacen(request);
		if(response.getAreaList() == null)
		{
			response.setMensaje("No se encontraron áreas con los parámetros ingresados");
			response.setEstado(ResponseEstado.ERROR_NEGOCIO);
		}
		else 
		{
			response.setMensaje("Áreas obtenidas correctamente");
			response.setEstado(ResponseEstado.OK);
		}
		return response;
	}

	@Override
	public ObtenerAreaResponse obtenerAreas(ObtenerAreaRequest request)
			throws Exception {
		ObtenerAreaResponse response = areaDAO.obtenerAreas(request);
		List<Area> areaList= response.getAreaList();
		
		if( areaList == null)
		{
			response.setEstado( ResponseEstado.ERROR_NEGOCIO );
			response.setMensaje( "Area no encontrada." );
		}
		else
		{
			response.setEstado( ResponseEstado.OK );
			response.setMensaje( "Area obtenida correctamente." );
		}
		return response;
	}

	@Override
	public InsertarAreaResponse insertarArea(InsertarAreaRequest request)
			throws Exception {
		InsertarAreaResponse response = areaDAO.insertarArea(request);
		
		Confirmacion confirmacion = response.getConfirmacion();
		
		if(confirmacion.getId() == ResponseEstado.OK) {
			response.setEstado(ResponseEstado.OK);
			response.setMensaje("Area insertada correctamente.");
		} else {
			response.setEstado(ResponseEstado.ERROR_NEGOCIO);
			response.setMensaje("Ya existe un area con ese nombre");
		}
		return response;
	}

	@Override
	public EliminarAreaResponse eliminarArea(EliminarAreaRequest request)
			throws Exception {
		EliminarAreaResponse response = areaDAO.eliminarArea(request);
		
		Confirmacion confirmacion = response.getConfirmacion();
		
		if(confirmacion.getId() == ResponseEstado.OK) {
			response.setEstado(ResponseEstado.OK);
			response.setMensaje("Area eliminada correctamente");
		} else {
			response.setEstado(ResponseEstado.ERROR_NEGOCIO);
			response.setMensaje("Area no se pudo eliminar");
		}
		return response;
	}

	@Override
	public ObtieneAreaConsultaAmbulatoriaResponse obtenerAreasConsultaAmbulatoria(
			ObtieneAreaConsultaAmbulatoriaRequest request) throws Exception {
		ObtieneAreaConsultaAmbulatoriaResponse response = new ObtieneAreaConsultaAmbulatoriaResponse();
		request.setIdIPRESS(EncriptacionUtil.desencriptar(request.getIdIPRESS()));
		List<Item> li = areaDAO.obtenerAreasConsultaAmbulatoria(request.getIdIPRESS(),
				 											    null, 
				 											    request.getCodUsuario());
		response.setAreaList(li);
		return response;
	}
}
