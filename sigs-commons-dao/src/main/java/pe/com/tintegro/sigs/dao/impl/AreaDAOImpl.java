package pe.com.tintegro.sigs.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.com.tintegro.sigs.dao.AreaDAO;
import pe.com.tintegro.sigs.dto.request.EliminarAreaRequest;
import pe.com.tintegro.sigs.dto.request.InsertarAreaRequest;
import pe.com.tintegro.sigs.dto.request.ObtenerAreaRequest;
import pe.com.tintegro.sigs.dto.request.ObtieneAreasSinAlmacenRequest;
import pe.com.tintegro.sigs.dto.response.EliminarAreaResponse;
import pe.com.tintegro.sigs.dto.response.InsertarAreaResponse;
import pe.com.tintegro.sigs.dto.response.ObtenerAreaResponse;
import pe.com.tintegro.sigs.dto.response.ObtieneAreasSinAlmacenResponse;
import pe.com.tintegro.sigs.entidad.Area;
import pe.com.tintegro.sigs.entidad.general.Confirmacion;
import pe.com.tintegro.sigs.entidad.general.Item;
import pe.com.tintegro.sigs.mapper.AreaMapper;

@Repository( "areaDAO" )
@Transactional
public class AreaDAOImpl implements AreaDAO
{
	@Autowired
	private AreaMapper areaMapper;
	
	@Override
	public List<Item> obtenerAreas(String idIPRESS, Integer idArea, String codUsuario) throws Exception
	{
		return areaMapper.obtenerAreas( idIPRESS, idArea, codUsuario);
	}

	@Override
	public ObtieneAreasSinAlmacenResponse obtenerAreasSinAlmacen(ObtieneAreasSinAlmacenRequest request) throws Exception
	{
		ObtieneAreasSinAlmacenResponse response = new ObtieneAreasSinAlmacenResponse();
		List<Item> areaList = areaMapper.obtenerAreasSinAlmacen(request.getIdArea(), request.getIdIPRESS(), request.getCodUsuario());
		response.setAreaList(areaList);
		return response;
	}

	@Override
	public ObtenerAreaResponse obtenerAreas(ObtenerAreaRequest request)
			throws Exception {
		ObtenerAreaResponse response = new ObtenerAreaResponse();
		List<Area> areaList = areaMapper.obtenerAreasMaestra(request.getDescripcionArea(),
												 	  request.getNumPagina(),
													  request.getNumRegisMostrar());
		response.setAreaList(areaList);
		return response;
	}

	@Override
	public InsertarAreaResponse insertarArea(InsertarAreaRequest request)
			throws Exception {
		InsertarAreaResponse response = new InsertarAreaResponse();
		Confirmacion confirmar = areaMapper.insertarArea(request.getDescripcionArea(), request.getAbreviaturaArea());
		response.setConfirmacion(confirmar);
		return response;
	}

	@Override
	public EliminarAreaResponse eliminarArea(EliminarAreaRequest request)
			throws Exception {
		EliminarAreaResponse response = new EliminarAreaResponse();
		Confirmacion confirmar = areaMapper.eliminarArea(request.getIdArea());
		response.setConfirmacion(confirmar);
		return response;
	}

	@Override
	public List<Item> obtenerAreasConsultaAmbulatoria(String idIPRESS,
			Integer idArea, String codUsuario) throws Exception {
		return areaMapper.obtenerAreasConsultaAmbulatoria(idIPRESS, idArea, codUsuario);
	}

}
