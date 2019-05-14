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
import pe.com.tintegro.sigs.dto.request.ObtieneSexoRequest;
import pe.com.tintegro.sigs.dto.response.ObtieneSexoResponse;

/**
 * @author Carlos
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes =
{ ApplicationContextDAOConfig.class })
public class SexoServiceTest
{
	@Autowired
	private SexoService sexoSevice;

	@Test
	public void obtenerSexoTest()
	{
		try
		{
			ObtieneSexoRequest request = new ObtieneSexoRequest();
			ObtieneSexoResponse response = sexoSevice.obtenerSexo(request);
			response.getSexoList().forEach(sexo ->
			{
				System.out.print(sexo.getID());
				System.out.println(sexo.getValor());
			});

		}
		catch (Exception e)
		{
			// TODO: handle exception
			e.printStackTrace();
		}

	}
}
