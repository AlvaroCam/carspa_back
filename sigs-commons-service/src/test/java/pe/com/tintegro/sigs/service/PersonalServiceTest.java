/**
 * 
 */
package pe.com.tintegro.sigs.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pe.com.tintegro.sigs.config.ApplicationContextDAOConfig;
import pe.com.tintegro.sigs.dto.request.ObtienePersonalesRequest;
import pe.com.tintegro.sigs.dto.response.ObtienePersonalesResponse;
import pe.com.tintegro.sigs.entidad.Personal;

/**
 * @author daniel - 18 set. 2017
 *
 */
@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration( classes = { ApplicationContextDAOConfig.class } )
public class PersonalServiceTest
{
	@Autowired
	private PersonalService personalService;
	
	@Test
	public void obtenerPersonales()
	{
		ObtienePersonalesRequest request = new ObtienePersonalesRequest();
		request.setIdArea( 1 );
		request.setIdEspecialidad( 17 );
		request.setIdActividad( 17 );
		request.setIdSubActividad( 4 );
		request.setIdIPRESS("gONZnF9vN/bocT+JhfnMGw==");
		
		ObtienePersonalesResponse response = new ObtienePersonalesResponse();
		
		try
		{
			response = personalService.obtenerPersonales( request );
			List<Personal> personalList = response.getPersonalList();
			personalList.forEach( personal -> {
				System.out.println( "Personal: " + personal.getNombre() );
			});
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
