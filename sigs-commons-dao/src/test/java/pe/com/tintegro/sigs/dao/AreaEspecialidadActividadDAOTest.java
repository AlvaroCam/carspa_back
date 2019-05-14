package pe.com.tintegro.sigs.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pe.com.tintegro.sigs.config.ApplicationContextDAOConfig;
import pe.com.tintegro.sigs.dto.request.ObtenerAreaEspecialidadActividadRequest;
import pe.com.tintegro.sigs.dto.request.ObtenerAreaPorEspecialidadRequest;
import pe.com.tintegro.sigs.dto.response.ObtenerAreaEspecialidadActividadResponse;
import pe.com.tintegro.sigs.dto.response.ObtenerAreaPorEspecialidadResponse;

/**
 * @author daniel - 11 set. 2017
 *
 */
@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration( classes = { ApplicationContextDAOConfig.class } )
public class AreaEspecialidadActividadDAOTest
{
	@Autowired
	private AreaEspecialidadActividadDAO aeaDAO;
	@Autowired
	private AreaEspecialidadDAO aees;
	
	@Test
	@Ignore
	public void listaAreaEspAct() {
		ObtenerAreaEspecialidadActividadRequest request = new ObtenerAreaEspecialidadActividadRequest();
		ObtenerAreaEspecialidadActividadResponse response = new ObtenerAreaEspecialidadActividadResponse();
		request.setIdIPRESS("0000007733");
		request.setIdArea(2);
		request.setIdEspecialidad(null);
		request.setIdActividad(null);
		request.setNuPagina(1);
		request.setNuRegiMostrar(100);
		
		try {
			response = aeaDAO.obtenerAreaEspecialidadActividadResponse(request);
			
			for(int i = 0; i<response.getAreaEspecialidadActividadList().size(); i++) {
				//if(response.getAreaEspecialidadActividadList()!=null) {
					System.out.println("--------------------------------------------");
					System.out.println(response.getAreaEspecialidadActividadList().get(i).getIdArea());
					System.out.println(response.getAreaEspecialidadActividadList().get(i).getDescripcionArea());
					
					System.out.println(response.getAreaEspecialidadActividadList().get(i).getIdEspecialidad());
					System.out.println(response.getAreaEspecialidadActividadList().get(i).getDescripcionEspecialidad());

					System.out.println(response.getAreaEspecialidadActividadList().get(i).getIdActividad());	
					System.out.println(response.getAreaEspecialidadActividadList().get(i).getDescripcionActividad());

			//	}else {
			//		System.out.println("Area por Especialidad por Actividad no encontrada");
			//	}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
//	@Ignore
	public void obtenerAreaPorEspecialidadTest() {
		ObtenerAreaPorEspecialidadRequest request = new ObtenerAreaPorEspecialidadRequest();
		ObtenerAreaPorEspecialidadResponse response = new ObtenerAreaPorEspecialidadResponse();
		request.setIdArea(2);
		request.setIdEspecialidad(null);
		request.setNuPagina(null);
		request.setNuRegisMostrar(null);
		
		
		try {
			response = aees.obtenerAreaPorEspecialidad(request);
			
			for(int i = 0; i<response.getAreaEspecialidadList().size(); i++) {
				//if(response.getAreaEspecialidadActividadList()!=null) {
					System.out.println("--------------------------------------------");
//					System.out.println(response.getAreaEspecialidadList().get(i).getIdserapes());

					System.out.println(response.getAreaEspecialidadList().get(i).getArea().getID());
					System.out.println(response.getAreaEspecialidadList().get(i).getArea().getValor());
					System.out.println(response.getAreaEspecialidadList().get(i).getEspecialidad().getID());
					System.out.println(response.getAreaEspecialidadList().get(i).getEspecialidad().getValor());
					System.out.println(response.getAreaEspecialidadList().get(i).getRpct());
					System.out.println(response.getAreaEspecialidadList().get(i).getFlag_interconsulta());
					System.out.println(response.getAreaEspecialidadList().get(i).getNuTotalReg());
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
