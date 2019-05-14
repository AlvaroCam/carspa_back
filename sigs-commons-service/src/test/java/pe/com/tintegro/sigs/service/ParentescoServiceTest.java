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
import pe.com.tintegro.sigs.dto.request.ObtieneParentescoRequest;
import pe.com.tintegro.sigs.dto.response.ObtieneParentescoResponse;

/**
 * @author FReyes
 *
 */

@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration( classes = { ApplicationContextDAOConfig.class } )
public class ParentescoServiceTest {
	
	@Autowired
	private ParentescoService parentescoService;
	
	@Test
	public void obtenerParentescoTest()
	{		
		try
		{
			ObtieneParentescoRequest request = new ObtieneParentescoRequest();
			ObtieneParentescoResponse response = parentescoService.obtenerParentesco(request);
			response.getParentescoList().forEach(parentesco ->
			{
				System.out.print(parentesco.getID() + " ");
				System.out.println(parentesco.getValor());				
			});

		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
