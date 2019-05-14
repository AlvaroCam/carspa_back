/**
 * 
 */
package pe.com.tintegro.sigs.dao;

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
public class OcupacionDAOTest 
{
	@Autowired
	private OcupacionDAO ocupacionDAO;
	
	@Test
	public void obtenerOcupacionTest()
	{
		try
		{
			ObtieneOcupacionRequest request = new ObtieneOcupacionRequest();
			ObtieneOcupacionResponse response = ocupacionDAO.obtenerOcupacion(request);
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
