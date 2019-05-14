/**
 * 
 */
package pe.com.tintegro.sigs.service;

import java.util.List;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pe.com.tintegro.sigs.config.ApplicationContextDAOConfig;
import pe.com.tintegro.sigs.dto.request.ObtieneEspecialidadesRequest;
import pe.com.tintegro.sigs.dto.response.ObtieneEspecialidadesResponse;
import pe.com.tintegro.sigs.entidad.general.Item;

/**
 * @author daniel - 11 set. 2017
 *
 */
@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration( classes = { ApplicationContextDAOConfig.class } )
public class EspecialidadServiceTest
{
	@Autowired
	private EspecialidadService especialidadService;
	
	public void obtenerEspecialidadesTest()
	{
		ObtieneEspecialidadesRequest request = new ObtieneEspecialidadesRequest();
		request.setIdIPRESS( "0000007733" );
		
		ObtieneEspecialidadesResponse response = new ObtieneEspecialidadesResponse();
		
		try
		{
			response = especialidadService.obtenerEspecialidades( request );
			List<Item> especialidadList = response.getEspecialidadList();
			
			especialidadList.forEach( especialidad -> {
				System.out.println( String.format( "%d %s", especialidad.getID(), especialidad.getValor()) );
			});
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
