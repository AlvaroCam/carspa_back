/**
 * 
 */
package pe.com.tintegro.sigs.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pe.com.tintegro.sigs.config.ApplicationContextDAOConfig;
import pe.com.tintegro.sigs.dto.request.EliminarEspecialidadJRequest;
import pe.com.tintegro.sigs.dto.request.InsertarEspecialidadJRequest;
import pe.com.tintegro.sigs.dto.request.ObtenerEspecialidadJRequest;
import pe.com.tintegro.sigs.dto.request.ObtieneEspecialidadRequest;
import pe.com.tintegro.sigs.dto.request.ObtieneEspecialidadesRequest;
import pe.com.tintegro.sigs.dto.response.EliminarEspecialidadJResponse;
import pe.com.tintegro.sigs.dto.response.InsertarEspecialidadJResponse;
import pe.com.tintegro.sigs.dto.response.ObtenerEspecialidadJResponse;
import pe.com.tintegro.sigs.entidad.general.Item;

/**
 * @author daniel - 11 set. 2017
 *
 */
@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration( classes = { ApplicationContextDAOConfig.class } )
public class EspecialidadDAOTest
{
	@Autowired
	private EspecialidadDAO especialidadDAO;
	
	@Test
	@Ignore
	public void obtenerEspecialidadesTest()
	{
		ObtieneEspecialidadesRequest request = new ObtieneEspecialidadesRequest();
		request.setIdIPRESS( "0000007733" );
		request.setIdArea( 1 );
		
		try
		{
			List<Item> especialidadList = especialidadDAO.obtenerEspecialidades( request.getIdIPRESS(), request.getIdArea(), null, request.getCodUsuario());
			especialidadList.forEach( especialidad -> {
				System.out.println( String.format( "%d %s", especialidad.getID(), especialidad.getValor() ) );
			});
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@Test
	@Ignore
	public void obtenerEspecialidadTest()
	{
		ObtieneEspecialidadRequest request = new ObtieneEspecialidadRequest();
		request.setIdIPRESS( "0000007733" );
		request.setIdArea( 1 );
		request.setIdEspecialidad( 1 );
		
		try
		{
			List<Item> especialidadList = especialidadDAO.obtenerEspecialidades( request.getIdIPRESS(), request.getIdArea(), request.getIdEspecialidad(), request.getCodUsuario() );
			
			Item especialidad = especialidadList.isEmpty() ? null : especialidadList.get( 0 );
			
			if ( especialidad != null )
			{
				String.format( "%d %s", especialidad.getID(), especialidad.getValor() );
			}
			else
			{
				System.out.println( "Especialidad no encontrada." );
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@Test
	@Ignore
	public void obtenerEspecialidadJ()
	{
		ObtenerEspecialidadJRequest request = new ObtenerEspecialidadJRequest();
		ObtenerEspecialidadJResponse response = new ObtenerEspecialidadJResponse();
		
		request.setDescripcion_especialidad(null);
		request.setNumPagina(1);
		request.setNumMostrarPagina(100);
		
		try {
			response = especialidadDAO.obtenerEspecialidadJ(request);
			
			for(int i = 0; i< response.getEspecialidadList().size(); i++){
				System.out.println(response.getEspecialidadList().get(i).getIdEspecialidad());
				System.out.println(response.getEspecialidadList().get(i).getDescripcionEspecialidad());
				System.out.println(response.getEspecialidadList().get(i).getAbreviatura_espec());
				
			}
			
		}catch  (Exception e){
			System.out.println(e.getCause());
		}
		
	}
	
	@Test
	@Ignore
	public void insertarEspecialidadJ()
	{
		InsertarEspecialidadJRequest request = new InsertarEspecialidadJRequest();
		InsertarEspecialidadJResponse response = new InsertarEspecialidadJResponse();
		
		request.setDescripcion_especialidad("EspecialidadPruebaxd");
		request.setAbreviatura_espec("EPxd");
		
		try{
			response = especialidadDAO.insertaEspecialidadJ(request);
			System.out.println(response.getConfirmacion().toString());
			System.out.println(response.getConfirmacion().getId());
			System.out.println(response.getConfirmacion().getMensaje());
			
		}catch (Exception e){
			e.printStackTrace();
		}
		
	}
	
	@Test
	//@Ignore
	public void eliminarEspecialidadJ()
	{
		EliminarEspecialidadJRequest request = new EliminarEspecialidadJRequest();
		EliminarEspecialidadJResponse response = new EliminarEspecialidadJResponse();
		
		request.setIdEspecialidad(109);
		
		try{
			response = especialidadDAO.eliminarEspecialidadJ(request);
			System.out.println(response.getConfirmacion().getId());
			System.out.println(response.getConfirmacion().getMensaje());
			
		}catch (Exception e){
			e.printStackTrace();
			System.out.println(e.getCause());
		}
		
	}
	
	
	
	
}