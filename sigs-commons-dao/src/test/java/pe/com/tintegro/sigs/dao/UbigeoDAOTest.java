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
import pe.com.tintegro.sigs.dto.request.ObtieneUbigeoRequest;
import pe.com.tintegro.sigs.dto.response.ObtieneUbigeoResponse;

/**
 * @author Carlos
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes =
{ ApplicationContextDAOConfig.class })
public class UbigeoDAOTest
{
	@Autowired
	private UbigeoDAO ubigeoDAO;

	@Test
	public void obtenerUbigeoTest()
	{
		try
		{
			ObtieneUbigeoRequest request = new ObtieneUbigeoRequest();
			request.setCodDepartamento("15");
			request.setCodProvincia("01");
			ObtieneUbigeoResponse ubigeoResponse = ubigeoDAO.obtenerUbigeo(request);
			 
			ubigeoResponse.getUbigeoList().forEach(ubigeo ->
			{
				System.out.print(ubigeo.getId());
				System.out.println(ubigeo.getNombre());
			});
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
