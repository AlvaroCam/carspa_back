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
import pe.com.tintegro.sigs.dto.request.ObtieneParentescoRequest;
import pe.com.tintegro.sigs.dto.response.ObtieneParentescoResponse;

/**
 * @author FReyes
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes =
{ ApplicationContextDAOConfig.class })
public class ParentescoDAOTest 
{
	@Autowired
	private ParentescoDAO parentescoDAO;
	
	@Test
	public void obtenerParentesco()
	{
		try
		{
			ObtieneParentescoRequest request = new ObtieneParentescoRequest();
			ObtieneParentescoResponse response = parentescoDAO.obtenerParentesco(request);
			response.getParentescoList().forEach(parentesco ->
			{
				System.out.print(parentesco.getID());
				System.out.println(parentesco.getValor());
			});
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
