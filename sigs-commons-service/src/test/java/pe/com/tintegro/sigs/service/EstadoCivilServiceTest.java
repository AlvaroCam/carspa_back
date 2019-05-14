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
import pe.com.tintegro.sigs.dto.request.ObtieneEstadoCivilRequest;
import pe.com.tintegro.sigs.dto.response.ObtieneEstadoCivilResponse;

/**
 * @author Carlos
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes =
{ ApplicationContextDAOConfig.class })
public class EstadoCivilServiceTest
{
	@Autowired
	private EstadoCivilService estadoCivilService;

	@Test
	public void obtenerEstadoCivilTest()
	{
		try
		{
			ObtieneEstadoCivilRequest request = new ObtieneEstadoCivilRequest();
			ObtieneEstadoCivilResponse response = estadoCivilService.obtenerEstadoCivil(request);
			response.getEstadoCivilList().forEach(estadoCivil ->
			{
				System.out.print(estadoCivil.getID()+ " ");
				System.out.println(estadoCivil.getValor());
			});
		}
		catch (Exception e)
		{
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
