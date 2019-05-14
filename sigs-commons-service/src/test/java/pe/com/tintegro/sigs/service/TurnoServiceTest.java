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
import pe.com.tintegro.sigs.dto.request.ObtieneTurnoRequest;
import pe.com.tintegro.sigs.dto.request.ObtieneTurnosRequest;
import pe.com.tintegro.sigs.dto.response.ObtieneTurnoResponse;
import pe.com.tintegro.sigs.dto.response.ObtieneTurnosResponse;
import pe.com.tintegro.sigs.entidad.general.Item;

/**
 * @author daniel - 15 set. 2017
 *
 */
@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration( classes = { ApplicationContextDAOConfig.class } )
public class TurnoServiceTest
{
	@Autowired
	private TurnoService turnoService;
	
	@Test
	@Ignore
	public void obtenerTurnosTest()
	{
		ObtieneTurnosRequest request = new ObtieneTurnosRequest();
		request.setIdIPRESS( "gONZnF9vN/bocT+JhfnMGw==" );
		
		ObtieneTurnosResponse response = new ObtieneTurnosResponse();
		
		try
		{
			response = turnoService.obtenerTurnos( request );
			List<Item> turnoList = response.getTurnoList();
			turnoList.forEach( turno -> {
				System.out.println( turno );
			});
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@Test
//	@Ignore
	public void obtenerTurnoTest()
	{
//		ObtieneTurnoRequest request = new ObtieneTurnoRequest();
//		request.setIdIPRESS( "gONZnF9vN/bocT+JhfnMGw==" );
//		request.setIdTurno( 1 );
//		request.setIdActividad(16);
//		
//		ObtieneTurnoResponse response = new ObtieneTurnoResponse();
//		
//		try
//		{
//			response = turnoService.obtenerTurno( request );
//			Item turno = response.getTurno();
//			
//			if( turno != null )
//			{
//				System.out.println( String.format( "%d %s", turno.getID(), turno.getValor() ) );
//			}
//		}
//		catch (Exception e)
//		{
//			e.printStackTrace();
//		}
	}
}
