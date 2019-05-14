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
import pe.com.tintegro.sigs.dto.request.ObtieneGradoInstruccionRequest;
import pe.com.tintegro.sigs.dto.response.ObtieneGradoInstruccionResponse;

/**
 * @author FReyes
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes =
{ ApplicationContextDAOConfig.class })
public class GradoInstruccionDAOTest 
{
	@Autowired
	private GradoInstruccionDAO gradoInstruccionDAO;
	
	@Test
	public void obtenerGradoInstruccionTest()
	{
		try
		{
			ObtieneGradoInstruccionRequest request = new ObtieneGradoInstruccionRequest();
			ObtieneGradoInstruccionResponse response = gradoInstruccionDAO.obtenerGradoInstruccion(request);
			response.getGradoInstruccionList().forEach(gradoInstruccion ->
			{
				System.out.print(gradoInstruccion.getID());
				System.out.println(gradoInstruccion.getValor());
			});
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
}
	

