/**
 * 
 */
package pe.com.tintegro.sigs.dao;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pe.com.tintegro.sigs.config.ApplicationContextDAOConfig;
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

/**
 * @author Carlos
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes =
{ ApplicationContextDAOConfig.class })
public class GrupoOcupacionalDAOTest
{
	@Autowired
	private GrupoOcupacionalDAO grupoOcupacionlaDAO;

	@Test
	//@Ignore
	public void obtenerTipoProfesionalTest(){

	try
	{
		ObtenerTipoProfesionalJRequest request = new ObtenerTipoProfesionalJRequest();
		ObtenerTipoProfesionalJResponse response = grupoOcupacionlaDAO.obtenerTipoProfesionalJ(request);
		System.out.println("--------------");
		System.out.println(response.getTipoProfesionalList().toString());
		for (int i = 0; i < response.getTipoProfesionalList().size(); i++) {
			System.out.print(response.getTipoProfesionalList().get(i).getId_tipo_profesional());
			System.out.println(response.getTipoProfesionalList().get(i).getDescripcionTipoProfesional());
		}
//		response.getTipoProfesionalList().forEach(tipoProfesional ->
//		{
//			
//		});

	}
	catch (Exception e)
	{
		e.printStackTrace();
		//e.getCause();
	}

	}
	
	@Test
	@Ignore
	public void obtenerGrupoOcupacionalTest()
	{
		try
		{
			ObtieneGrupoOcupacionalRequest request = new ObtieneGrupoOcupacionalRequest();
			ObtieneGrupoOcupacionalResponse response = grupoOcupacionlaDAO.obtenerGrupoOcupacional(request);
			response.getGrupoOcupacionalList().forEach(grupoOcupacional ->
			{
				System.out.print(grupoOcupacional.getID());
				System.out.println(grupoOcupacional.getValor());
			});
		}
		catch (Exception e)
		{
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	

	//Test Grupo Ocupacional Julio
	@Test
	@Ignore
	public void insertarGrupoOcupacionalJ (){
		InsertarGrupoOcupacionalJRequest request = new InsertarGrupoOcupacionalJRequest();
		InsertarGrupoOcupacionalJResponse response = new InsertarGrupoOcupacionalJResponse();
		
		request.setDescripcionGrupoOcupacional("Grupo Prueba3");
		request.setIdTipoProfesional(1);
		request.setAbreviatura("GP3");
		request.setEmitirReceta(1);
		request.setOtorgarSolicitarExamen(1);
		request.setEmitirCitt(1);
		request.setOtorgarMateriales(1);
		request.setEmitirReferencia(1);
		request.setRegularAntecedente(1);
		
		try {
			response = grupoOcupacionlaDAO.insertarGrupoOcupacionalJ(request);
			System.out.println(response.getConfirmacion().getId());
			System.out.println(response.getConfirmacion().getMensaje());
		} catch (Exception e) {
			//e.printStackTrace();
			System.out.println(e.getCause());
		}
	}
	
	@Test
	@Ignore
	public void obtenerGrupoOcupacionalJ(){
		ObtenerGrupoOcupacionalJRequest request = new ObtenerGrupoOcupacionalJRequest();
		ObtenerGrupoOcupacionalJResponse response = new ObtenerGrupoOcupacionalJResponse();
		
		request.setDescripcionGrupoOcupacional(null);
		request.setIdTipoProfesional(null);
		request.setNuPagina(1);
		request.setNuRegisMostrar(60);
		
		try {
			response = grupoOcupacionlaDAO.obtenerGrupoOcupacionalJ(request);
			
			for (int i = 0; i < response.getGrupoOcupacionalList().size(); i++) {
				//System.out.println(response.getAreaEspecialidadList().size());
				//if (response.getAreaEspecialidadList() != null) {
					
					System.out.println("id: "+response.getGrupoOcupacionalList().get(i).getIdGrupoOcupacional());
					
					System.out.println(response.getGrupoOcupacionalList().get(i).getDescripcionGrupoOcupacional());
					System.out.println(response.getGrupoOcupacionalList().get(i).getIdTipoProfesional());
					System.out.println(response.getGrupoOcupacionalList().get(i).getDescripcionTipoProfesional());
					System.out.println(response.getGrupoOcupacionalList().get(i).getAbreviatura());
					System.out.println(response.getGrupoOcupacionalList().get(i).getEmitirReceta());
					System.out.println(response.getGrupoOcupacionalList().get(i).getOtorgarSolicitarExamen());
					System.out.println(response.getGrupoOcupacionalList().get(i).getEmitirCitt());
					System.out.println(response.getGrupoOcupacionalList().get(i).getOtorgarMateriales());
					System.out.println(response.getGrupoOcupacionalList().get(i).getEmitirReferencia());
					System.out.println(response.getGrupoOcupacionalList().get(i).getRegularAntecedente());
					System.out.println(response.getGrupoOcupacionalList().get(i).getNuTotalReg());
					
					System.out.println("-----------------------------------------------------------------------------------------------------------------");
			
			}
		} catch (Exception e) {
			//e.printStackTrace();
			System.out.println(e.getCause());
		}
	}
	
	@Test
	@Ignore
	public void eliminarGrupoOcupacionalJ(){
		EliminarGrupoOcupacionalJRequest request = new EliminarGrupoOcupacionalJRequest();
		EliminarGrupoOcupacionalJResponse response = new EliminarGrupoOcupacionalJResponse();
		
		request.setIdGrupoOcupacional(40);
		
		try {
			response = grupoOcupacionlaDAO.eliminarGrupoOcupacionalJ(request);
			System.out.println(response.getConfirmacion().getId());
			System.out.println(response.getConfirmacion().getMensaje());
		} catch (Exception e) {
			//e.printStackTrace();
			System.out.println(e.getCause());
		}
	}
	
	@Test
	@Ignore
	public void actualizarGrupoOcupacionalJ(){
		ActualizarGrupoOcupacionalJRequest request = new ActualizarGrupoOcupacionalJRequest();
		ActualizarGrupoOcupacionalJResponse response = new ActualizarGrupoOcupacionalJResponse();
		
		request.setIdGrupoOcupacional(39);
		request.setDescripcionGrupoOcupacional("Grupo Prueba NEWs");
		request.setIdTipoProfesional(1);
		request.setAbreviatura("GP");
		request.setEmitirReceta(1);
		request.setOtorgarSolicitarExamen(2);
		request.setEmitirCitt(3);
		request.setOtorgarMateriales(4);
		request.setEmitirReferencia(5);
		request.setRegularAntecedente(6);
		
		
		try {
			response = grupoOcupacionlaDAO.actualizarGrupoOcupacionalJ(request);
			System.out.println(response.getConfirmacion().getId());
			System.out.println(response.getConfirmacion().getMensaje());
		} catch (Exception e) {
			//e.printStackTrace();
			System.out.println(e.getCause());
		}
	}
}
