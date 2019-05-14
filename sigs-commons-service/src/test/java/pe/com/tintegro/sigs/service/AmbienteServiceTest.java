/**
 * 
 */
package pe.com.tintegro.sigs.service;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pe.com.tintegro.sigs.config.ApplicationContextDAOConfig;
import pe.com.tintegro.sigs.dto.request.ObtieneAmbienteRequest;
import pe.com.tintegro.sigs.dto.request.ObtieneAmbientesRequest;
import pe.com.tintegro.sigs.dto.response.ObtieneAmbienteResponse;
import pe.com.tintegro.sigs.dto.response.ObtieneAmbientesResponse;
import pe.com.tintegro.sigs.entidad.general.Item;

/**
 * @author daniel - 15 set. 2017
 *
 */
@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration( classes = { ApplicationContextDAOConfig.class } )
public class AmbienteServiceTest
{
	@Autowired
	private AmbienteService ambienteService;
	
	@Test
	public void obtenerAmbientes()
	{
		ObtieneAmbientesRequest request = new ObtieneAmbientesRequest();
		ObtieneAmbientesResponse response = new ObtieneAmbientesResponse();
		request.setIdIPRESS("gONZnF9vN/bocT+JhfnMGw==");
		request.setIdArea(1);
		request.setIdEspecialidad(17);
		request.setIdActividad(17);
		try
		{
			response = ambienteService.obtenerAmbientes( request );
			response.getAmbienteList().forEach( ambiente -> {
				System.out.println( String.format( "%d %s", ambiente.getID(), ambiente.getValor() ) );
			});
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@Test
	@Ignore
	public void obtenerAmbiente()
	{
		ObtieneAmbienteRequest request = new ObtieneAmbienteRequest();
		ObtieneAmbienteResponse response = new ObtieneAmbienteResponse();
		
		try
		{
			response = ambienteService.obtenerAmbiente( request );
			Item ambiente = response.getAmbiente();
			
			if( ambiente != null )
			{
				System.out.println( String.format( "%d %s", ambiente.getID(), ambiente.getValor() ) );
			}
			else
			{
				System.out.println( "Ambiente no encontrado." );
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
