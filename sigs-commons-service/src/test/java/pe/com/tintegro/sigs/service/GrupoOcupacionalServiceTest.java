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
import pe.com.tintegro.sigs.dto.request.ObtieneGrupoOcupacionalRequest;
import pe.com.tintegro.sigs.dto.response.ObtieneGrupoOcupacionalResponse;

/**
 * @author Carlos
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes =
{ ApplicationContextDAOConfig.class })
public class GrupoOcupacionalServiceTest
{
	@Autowired
	private GrupoOcupacionalService grupoOcupacionlaService;

	@Test
	public void obtenerGrupoOcupacionalTest()
	{
		ObtieneGrupoOcupacionalRequest request = new ObtieneGrupoOcupacionalRequest();
		request.setCodigoIeds("09");
		try
		{
			
			ObtieneGrupoOcupacionalResponse response = grupoOcupacionlaService.obtenerGrupoOcupacional(request);
			response.getGrupoOcupacionalList().forEach(grupoOcupacional ->
			{
				System.out.print(grupoOcupacional.getID());
				System.out.println(grupoOcupacional.getValor());
			});
		}
		catch (Exception e)
		{
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
