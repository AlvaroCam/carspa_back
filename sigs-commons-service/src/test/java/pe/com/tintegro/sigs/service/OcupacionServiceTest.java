/**
 * 
 */
package pe.com.tintegro.sigs.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pe.com.tintegro.sigs.config.ApplicationContextDAOConfig;
import pe.com.tintegro.sigs.dto.request.ObtieneOcupacionRequest;
import pe.com.tintegro.sigs.dto.response.ObtieneOcupacionResponse;

/**
 * @author FReyes
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes =
{ ApplicationContextDAOConfig.class })
public class OcupacionServiceTest 
{
	@Autowired
	private OcupacionService ocupacionService;
	
	@Test
	public void obtenerOcupacionTest()
	{
		try
		{
			ObtieneOcupacionRequest request = new ObtieneOcupacionRequest();
			ObtieneOcupacionResponse response = ocupacionService.obtenerOcupacion(request);
			response.getOcupacionList().forEach(ocupacion ->
			{
				System.out.print(ocupacion.getID());
				System.out.println(ocupacion.getValor());
			});
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
