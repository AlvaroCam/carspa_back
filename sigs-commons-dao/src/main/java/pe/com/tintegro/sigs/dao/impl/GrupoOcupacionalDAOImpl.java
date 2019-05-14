/**
 * 
 */
package pe.com.tintegro.sigs.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.com.tintegro.sigs.dao.GrupoOcupacionalDAO;
import pe.com.tintegro.sigs.dto.request.ActualizarGrupoOcupacionalJRequest;
import pe.com.tintegro.sigs.dto.request.EliminarGrupoOcupacionalJRequest;
import pe.com.tintegro.sigs.dto.request.InsertarGrupoOcupacionalJRequest;
import pe.com.tintegro.sigs.dto.request.ObtenerGrupoOcupacionalJRequest;
import pe.com.tintegro.sigs.dto.request.ObtenerTipoProfesionalJRequest;
import pe.com.tintegro.sigs.dto.request.ObtieneGrupoOcupacionalRequest;
import pe.com.tintegro.sigs.dto.response.ActualizarGrupoOcupacionalJResponse;
import pe.com.tintegro.sigs.dto.response.EliminarGrupoOcupacionalJResponse;
import pe.com.tintegro.sigs.dto.response.InsertarGrupoOcupacionalJResponse;
import pe.com.tintegro.sigs.dto.response.ObtenerGrupoOcupacionalJResponse;
import pe.com.tintegro.sigs.dto.response.ObtenerTipoProfesionalJResponse;
import pe.com.tintegro.sigs.dto.response.ObtieneGrupoOcupacionalResponse;
import pe.com.tintegro.sigs.entidad.GrupoOcupacional;
import pe.com.tintegro.sigs.entidad.TipoProfesional;
import pe.com.tintegro.sigs.entidad.general.Confirmacion;
import pe.com.tintegro.sigs.entidad.general.Item;
import pe.com.tintegro.sigs.mapper.GrupoOcupacionalMapper;

/**
 * @author Carlos
 *
 */
@Repository("grupoOcupacionalDAO")
@Transactional
public class GrupoOcupacionalDAOImpl implements GrupoOcupacionalDAO
{
	@Autowired
	private GrupoOcupacionalMapper grupoOcupacionalMapper;

	@Override
	public ObtieneGrupoOcupacionalResponse obtenerGrupoOcupacional(ObtieneGrupoOcupacionalRequest request) throws Exception
	{
		// TODO Auto-generated method stub
		ObtieneGrupoOcupacionalResponse response = new ObtieneGrupoOcupacionalResponse();

		List<Item> grupoOcupacionalList = grupoOcupacionalMapper.obtenerGrupoOcupacional(
				request.getCodigoIeds());
		if (grupoOcupacionalList.size() != 0)
		{
			response.setGrupoOcupacionalList(grupoOcupacionalList);
		}

		return response;
	}

	@Override
	public ObtenerGrupoOcupacionalJResponse obtenerGrupoOcupacionalJ(ObtenerGrupoOcupacionalJRequest request) throws Exception {
		ObtenerGrupoOcupacionalJResponse response = new ObtenerGrupoOcupacionalJResponse();
		List<GrupoOcupacional> grupoOcupacionalList = grupoOcupacionalMapper.obtenerGrupoOcupacionalJ(
				request.getDescripcionGrupoOcupacional(),
				request.getIdTipoProfesional(),
				request.getNuPagina(),
				request.getNuRegisMostrar());
		response.setGrupoOcupacionalList(grupoOcupacionalList);
		return response;
	}

	@Override
	public InsertarGrupoOcupacionalJResponse insertarGrupoOcupacionalJ(InsertarGrupoOcupacionalJRequest request) throws Exception {
		
		InsertarGrupoOcupacionalJResponse response = new InsertarGrupoOcupacionalJResponse();
		Confirmacion confirmacion = grupoOcupacionalMapper.insertarGrupoOcupacionalJ(
				request.getDescripcionGrupoOcupacional(),
				request.getIdTipoProfesional(),
				request.getAbreviatura(),
				request.getEmitirReceta(),
				request.getOtorgarSolicitarExamen(),
				request.getEmitirCitt(),
				request.getOtorgarMateriales(),
				request.getEmitirReferencia(),
				request.getRegularAntecedente());
		
		response.setConfirmacion(confirmacion);
		return response;
	}

	@Override
	public ActualizarGrupoOcupacionalJResponse actualizarGrupoOcupacionalJ(ActualizarGrupoOcupacionalJRequest request) throws Exception {
		ActualizarGrupoOcupacionalJResponse response = new ActualizarGrupoOcupacionalJResponse();
		Confirmacion confirmacion = grupoOcupacionalMapper.actualizarGrupoOcupacionalJ(
				request.getIdGrupoOcupacional(),
				request.getDescripcionGrupoOcupacional(),
				request.getIdTipoProfesional(),
				request.getAbreviatura(),
				request.getEmitirReceta(),
				request.getOtorgarSolicitarExamen(),
				request.getEmitirCitt(),
				request.getOtorgarMateriales(),
				request.getEmitirReferencia(),
				request.getRegularAntecedente());
		response.setConfirmacion(confirmacion);
		return response;
	}

	@Override
	public EliminarGrupoOcupacionalJResponse eliminarGrupoOcupacionalJ(EliminarGrupoOcupacionalJRequest request) throws Exception {
		EliminarGrupoOcupacionalJResponse response = new EliminarGrupoOcupacionalJResponse();
		Confirmacion confirmacion = grupoOcupacionalMapper.eliminarGrupoOcupacionalJ(
				request.getIdGrupoOcupacional());
		response.setConfirmacion(confirmacion);
		return response;
	}

	@Override
	public ObtenerTipoProfesionalJResponse obtenerTipoProfesionalJ(ObtenerTipoProfesionalJRequest request) throws Exception {
		ObtenerTipoProfesionalJResponse response = new ObtenerTipoProfesionalJResponse();
		List<TipoProfesional> tipoProfesionalList = grupoOcupacionalMapper.obtenerTipoProfesionalJ();
//		if(tipoProfesionalList.size() !=0)
//		{
			response.setTipoProfesionalList(tipoProfesionalList);
		
		return response;
		
	}

}
