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
import pe.com.tintegro.sigs.dto.request.ObtieneUbigeoRequest;
import pe.com.tintegro.sigs.dto.response.ObtieneUbigeoResponse;

/**
 * @author Carlos
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes =
{ ApplicationContextDAOConfig.class })
public class UbigeoServiceTest
{
	@Autowired
	private UbigeoService ubigeoService;

	@Test
	public void obtenerUbigeoTest()
	{
		try
		{
			ObtieneUbigeoRequest request = new ObtieneUbigeoRequest();
			request.setCodDepartamento("01");
			request.setCodProvincia("02");
			ObtieneUbigeoResponse ubigeoResponse = ubigeoService.obtenerUbigeo(request);
			System.out.print("ejecutado");
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
